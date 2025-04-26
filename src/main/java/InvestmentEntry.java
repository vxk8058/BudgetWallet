import java.util.Arrays;
import java.util.List;

public class InvestmentEntry {
    public static final List<String> investment_categories = Arrays.asList("Stocks", "Real Estate", "ETFs");

    private String name;
    private String category;
    private int currentValue;

    public InvestmentEntry(String name, String category, int currentValue) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Investment name cannot be empty");
        }

        if (!investment_categories.contains(category)) {
            throw new IllegalArgumentException("Invalid investment category: " + category);
        }

        if (currentValue < 0) {
            throw new IllegalArgumentException("Investment value must be positive");
        }

        this.name = name;
        this.category = category;
        this.currentValue = currentValue;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        if (!investment_categories.contains(category)) {
            throw new IllegalArgumentException("Invalid investment category: " + category);
        }
        this.category = category;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
}