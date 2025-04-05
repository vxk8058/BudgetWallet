import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMgr {

    private static String[] sampleEmails =
            {"johnledford@gmail.com", "big1234@yahoo.com", "gigantic4452@gmail.com"};
    private static String[] sampleFirst = {"John", "Timothy", "Hank"};
    private static String[] sampleLast = {"Ledford", "Big", "Gigantic"};
    //password hashing will be implemented later, now is basic testing
    private static String[] samplePass = {"123456789", "987654321", "aabc44532"};

    enum EntryType {
        INCOME,
        EXPENSE,
        SAVINGS,
        INVESTMENT,
        PASSWORD
    }

    private static DBMgr instance;
    private Connection connection;
    private static final String url = "jdbc:sqlite:accounts.db";

    private DBMgr() {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static DBMgr getInstance() {
        if (instance == null) {
            instance = new DBMgr();
        }
        return instance;
    }

    public Connection getConn() {
        return connection;
    }

    public void establishDB() {
        String sql  = "     CREATE TABLE IF NOT EXISTS users ("
                    + "     user_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "     email TEXT NOT NULL UNIQUE,"
                    + "     password TEXT NOT NULL,"
                    + "     first_name TEXT NOT NULL,"
                    + "     last_name TEXT NOT NULL);";

        String sql2 = "     CREATE TABLE IF NOT EXISTS income ("
                    + "     income_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "     user_id INTEGER,"
                    + "     amount TEXT NOT NULL,"  // storing as text for ease of reading and writing
                    + "     date TEXT NOT NULL,"
                    + "     category TEXT NOT NULL,"
                    + "     FOREIGN KEY (user_id) REFERENCES users(user_id));";

        String sql3 = "     CREATE TABLE IF NOT EXISTS expenses ("
                    + "     expense_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "     user_id INTEGER,"
                    + "     amount TEXT NOT NULL,"
                    + "     date TEXT NOT NULL,"
                    + "     category TEXT NOT NULL,"
                    + "     FOREIGN KEY (user_id) REFERENCES users(user_id));";

        String sql4 = "     CREATE TABLE IF NOT EXISTS savings ("
                    + "     savings_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "     user_id INTEGER,"
                    + "     amount TEXT NOT NULL,"
                    + "     date TEXT NOT NULL,"
                    + "     category TEXT NOT NULL,"
                    + "     FOREIGN KEY (user_id) REFERENCES users(user_id));";

        String sql5 = "     CREATE TABLE IF NOT EXISTS investments ("
                    + "     investment_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "     user_id INTEGER,"
                    + "     amount TEXT NOT NULL,"
                    + "     date TEXT NOT NULL,"
                    + "     category TEXT NOT NULL,"
                    + "     FOREIGN KEY (user_id) REFERENCES users(user_id));";

        try (var stmt = connection.createStatement()) {
            stmt.execute(sql);
            stmt.execute(sql2);
            stmt.execute(sql3);
            stmt.execute(sql4);
            stmt.execute(sql5);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean validUser(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";

        try (var pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);

            var rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return true;
                }
            }
            // control flow only reaches here if count < 1 or table is empty
            // meaning user does not exist
            return false;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean registerAccount(String email, String password,
                                   String firstName, String lastName) {
        String sql  = "INSERT INTO users(email, password, first_name, last_name) "
                    + "VALUES(?, ?, ?, ?)";

        try (var pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean validUser(String email, String password) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";

        try (var pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            var rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return true;
                }
            }
            // control flow only reaches here if count < 1 or table is empty
            // meaning user does not exist
            return false;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //need to add insertEntry method
