import java.util.Arrays;
import java.util.List;

public class InvestmentEntry {
    public static final List<String> investment_categories = Arrays.asList("Stocks", "Real Estate", "ETFs");

    private String name;
    private String category;
    private int amount;

    public InvestmentEntry(String name, String category, int amount) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Investment name cannot be empty");
        }

        if (!investment_categories.contains(category)) {
            throw new IllegalArgumentException("Invalid investment category: " + category);
        }

        if (amount < 0) {
            throw new IllegalArgumentException("Investment value must be positive");
        }

        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Investment name cannot be empty");
        }
        this.name = name;
    }

    public void setCategory(String category) {
        if (!investment_categories.contains(category)) {
            throw new IllegalArgumentException("Invalid investment category: " + category);
        }
        this.category = category;
    }

    public void setAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Investment value must be positive");
        }
        this.amount = amount;
    }

}