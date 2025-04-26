import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class LoginController {
    private static final int PORT = 8080;
    private static final Gson gson = new Gson();
    private static Connection connection;

    public static void main(String[] args) throws Exception {
        // Initialize database connection
        connectToDatabase();

        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/login", new LoginHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port " + PORT);
    }

    private static void connectToDatabase() throws SQLException {
        String url = "jdbc:sqlite:/Users/vikyathak/Documents/GitHub/BudgetWallet/accounts.db";
        connection = DriverManager.getConnection(url);
    }

    static class LoginHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
                return;
            }

            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder jsonBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBody.append(line);
            }

            Map<String, String> credentials = gson.fromJson(jsonBody.toString(), Map.class);
            String email = credentials.get("email");
            String password = credentials.get("password");

            Map<String, Object> responseJson = new HashMap<>();
            boolean valid = checkCredentials(email, password);
            if (valid) {
                responseJson.put("success", true);
                responseJson.put("token", "dummy-jwt-token"); // or generate JWT if needed
                sendJsonResponse(exchange, 200, responseJson);
            } else {
                responseJson.put("success", false);
                responseJson.put("message", "Invalid email or password.");
                sendJsonResponse(exchange, 401, responseJson);
            }
        }

        private boolean checkCredentials(String email, String password) {
            try {
                String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
                /*PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, email);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    System.out.println("User found: " + rs.getString("email"));
                    // Your login success logic
                } else {
                    System.out.println("Invalid login attempt.");
                    // Return failure message to frontend
                }*/

                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, email);
                stmt.setString(2, password); // Consider hashing in real apps
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        private void sendJsonResponse(HttpExchange exchange, int statusCode, Map<String, Object> data) throws IOException {
            String response = gson.toJson(data);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(statusCode, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
