import java.util.Arrays;
import java.util.List;

public class ExpenseEntry {
    public static final List<String> expense_categories = Arrays.asList("Groceries", "Food", "Rent", "Travel", "Gas", "Healthcare", "Insurance", "Miscellaneous");
    private int amount;
    private String category;
    private String date;


    public ExpenseEntry(int amount, String category, String date) {
        if (!expense_categories.contains(category)) {
            throw new IllegalArgumentException("Invalid expense category: " + category);
        }

        InputValidator validator = new InputValidator();
        if (!validator.validateDate(date)) {
            throw new IllegalArgumentException("Invalid date format: " + date + ". Expected MM-dd-yyyy");
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
