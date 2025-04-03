import java.util.Arrays;
import java.util.List;

public class IncomeEntry {
    private int amount;
    private String category;
    private String date;

    public static final List<String> income_categories = Arrays.asList("Salary", "Tip", "Commission", "Bonus");


    public IncomeEntry(int amount, String category, String date) {
        if (!income_categories.contains(category)) {
            throw new IllegalArgumentException("Invalid income category: " + category);
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
        if (!income_categories.contains(category)) {
            throw new IllegalArgumentException("Invalid income category: " + category);
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
