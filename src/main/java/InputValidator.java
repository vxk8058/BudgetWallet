import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class InputValidator {

    public boolean validateAmount(int amount) {
        return amount > 0; // Amount must always be positive
    }

    public boolean validateCategory(String category) {
        return category != null && !category.isEmpty(); // Non-empty category
    }

    /*public static boolean validateDate(String date) {
        if (date == null || date.isEmpty()) return false;

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        dateFormat.setLenient(false); // Do not allow lenient parsing like "February 30"

        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }*/

    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");

    public boolean validateDate(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }
}