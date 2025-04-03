import java.util.HashMap;
import java.util.Map;

public class DBMgr {
    private Map<String, User> users = new HashMap<>();

    // is email available, is it already registered
    public boolean isAvailable(String email) {
        return !users.containsKey(email);
    }

    // new account
    public void addNewAccount(String email, String password) {
        if (isAvailable(email)) {
            String hashedPassword = hashPassword(password);
            User newUser = new User(email, hashedPassword);
            users.put(email, newUser);
            System.out.println("New user created: " + email);
        } else {
            System.out.println("Email already exists: " + email);
        }
    }

    public boolean verifyEmail(String email) {
        return users.containsKey(email);
    }

    // sample authenticate method
    public boolean authenticate(String email, String password) {
        if (verifyEmail(email)) {
            User user = users.get(email);
            String hashedPassword = hashPassword(password);
            return user != null && user.getPassword().equals(hashedPassword);
        }
        return false;
    }

    public void addIncomeEntry(String email, IncomeEntry incomeEntry) {
        if (verifyEmail(email)) {
            User user = users.get(email);
            user.addIncomeEntry(incomeEntry);
        } else {
            System.out.println("User not found: " + email);
        }
    }

    public void addExpenseEntry(String email, ExpenseEntry expenseEntry) {
        if (verifyEmail(email)) {
            User user = users.get(email);
            user.addExpenseEntry(expenseEntry);
        } else {
            System.out.println("User not found: " + email);
        }
    }

    public void deleteIncomeEntry(String email, IncomeEntry incomeEntry) {
        if (verifyEmail(email)) {
            User user = users.get(email);
            user.deleteIncomeEntry(incomeEntry);
        } else {
            System.out.println("User not found: " + email);
        }
    }

    public void deleteExpenseEntry(String email, ExpenseEntry expenseEntry) {
        if (verifyEmail(email)) {
            User user = users.get(email);
            user.deleteExpenseEntry(expenseEntry);
        } else {
            System.out.println("User not found: " + email);
        }
    }

    // print statement (for now)
    public void printIncomeEntries(String email) {
        if (verifyEmail(email)) {
            User user = users.get(email);
            System.out.println("Income entries for user: " + email);
            for (IncomeEntry entry : user.getIncomeEntries()) {
                System.out.println(entry.getCategory() + ": $" + entry.getAmount() + " on " + entry.getDate());
            }
        } else {
            System.out.println("User not found: " + email);
        }
    }

    // print statement (for now)
    public void printExpenseEntries(String email) {
        if (verifyEmail(email)) {
            User user = users.get(email);
            System.out.println("Expense entries for user: " + email);
            for (ExpenseEntry entry : user.getExpenseEntries()) {
                System.out.println(entry.getCategory() + ": $" + entry.getAmount() + " on " + entry.getDate());
            }
        } else {
            System.out.println("User not found: " + email);
        }
    }

    // sample hashing for storing password safely.
    private String hashPassword(String password) {
        return Integer.toString(password.hashCode());
    }
}
