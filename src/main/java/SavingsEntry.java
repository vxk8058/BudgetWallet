import java.util.Arrays;
import java.util.List;

public class SavingsEntry {
    public static final List<String> savings_categories = Arrays.asList("Emergency Funds", "House", "Car", "Vacation", "Education");

    private int amount;
    private String category;
    private String date;

    public SavingsEntry(int amount, String category, String date) {
        if (!savings_categories.contains(category)) {
            throw new IllegalArgumentException("Invalid savings category: " + category);
        }

        InputValidator validator = new InputValidator();
        if (!validator.validateDate(date)) {
            throw new IllegalArgumentException("Invalid date format: " + date + ". Expected MM-DD-YYYY");
        }

        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        if (!savings_categories.contains(category)) {
            throw new IllegalArgumentException("Invalid savings category: " + category);
        }
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }
}