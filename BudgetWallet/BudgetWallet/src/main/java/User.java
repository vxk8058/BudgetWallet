import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private List<IncomeEntry> incomeEntries = new ArrayList<>();
    private List<ExpenseEntry> expenseEntries = new ArrayList<>();


    public String getEmail(){
        return email;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public User(String email, String password, String firstName, String lastName){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public void addIncomeEntry(IncomeEntry entry) {
        incomeEntries.add(entry);
        System.out.println("Income entry added for " + email);
    }

    public void deleteIncomeEntry(IncomeEntry entry) {
        boolean removed = false;
        for (IncomeEntry currentEntry : incomeEntries) {
            if (currentEntry.getAmount() == entry.getAmount() && currentEntry.getCategory().equals(entry.getCategory()) && currentEntry.getDate().equals(entry.getDate())) {
                incomeEntries.remove(currentEntry);
                System.out.println("Income entry deleted for " + email);
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Income entry not found for " + email);
        }
    }

    public void addExpenseEntry(ExpenseEntry entry) {
        expenseEntries.add(entry);
        System.out.println("Expense entry added for " + email);
    }

    public void deleteExpenseEntry(ExpenseEntry entry) {
        boolean removed = false;
        for (ExpenseEntry currentEntry : expenseEntries) {
            if (currentEntry.getAmount() == entry.getAmount() && currentEntry.getCategory().equals(entry.getCategory()) && currentEntry.getDate().equals(entry.getDate())) {
                expenseEntries.remove(currentEntry);
                System.out.println("Expense entry deleted for " + email);
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Expense entry not found for " + email);
        }
    }

    public List<IncomeEntry> getIncomeEntries() {
        return incomeEntries;
    }

    public List<ExpenseEntry> getExpenseEntries() {
        return expenseEntries;
    }
}
