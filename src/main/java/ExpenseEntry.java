import java.util.Arrays;
import java.util.List;

public class ExpenseEntry {
    public static final List<String> expense_categories = Arrays.asList("Groceries", "Food", "Rent", "Travel", "Gas", "Healthcare", "Insurance", "Miscellaneous");
    private int amount;
    private String category;
    private String date;


    public ExpenseEntry(int amount, String category, String date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Expense amount must be greater than 0. Given: " + amount);
        }

        if (category == null || !expense_categories.contains(category)) {
            throw new IllegalArgumentException("Invalid expense category: " + category +
                    ". Valid categories are: " + expense_categories);
        }

        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException("Date cannot be null or empty.");
        }

        InputValidator validator = new InputValidator();
        if (!validator.validateDate(date)) {
            throw new IllegalArgumentException("Invalid date format: " + date +
                    ". Expected format is YYYY-MM-DD.");
        }

        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (!expense_categories.contains(category)) {
            throw new IllegalArgumentException("Invalid expense category: " + category);
        }
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}