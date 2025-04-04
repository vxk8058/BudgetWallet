public class InputValidator {

    public boolean validateAmount(int amount) {
        return amount > 0; // Amount must always be positive
    }

    public boolean validateCategory(String category) {
        return category != null && !category.isEmpty(); // Non-empty category
    }

    public boolean validateDate(String date) {
        return date != null && !date.isEmpty(); // non-empty date check -> needs to be more complex later
    }
}
