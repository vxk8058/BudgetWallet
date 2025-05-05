import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private List<IncomeEntry> incomeEntries = new ArrayList<>();
    private List<ExpenseEntry> expenseEntries = new ArrayList<>();
    private List<InvestmentEntry> investmentEntries = new ArrayList<>();
    private List<SavingsEntry> savingsEntries = new ArrayList<>();


    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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

    public void addInvestmentEntry(InvestmentEntry entry) {
        investmentEntries.add(entry);
        System.out.println("Investment entry added for " + email);
    }

    public void deleteInvestmentEntry(InvestmentEntry entry) {
        boolean removed = false;
        for (InvestmentEntry currentEntry : investmentEntries) {
            if (currentEntry.getName().equals(entry.getName())
                    && currentEntry.getCategory().equals(entry.getCategory())
                    && currentEntry.getAmount() == entry.getAmount()) {
                investmentEntries.remove(currentEntry);
                System.out.println("Investment entry deleted for " + email);
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Investment entry not found for " + email);
        }
    }

    public void addSavingsEntry(SavingsEntry entry) {
        savingsEntries.add(entry);
        System.out.println("Savings entry added for " + email);
    }

    public void deleteSavingsEntry(SavingsEntry entry) {
        boolean removed = false;
        for (SavingsEntry currentEntry : savingsEntries) {
            if (currentEntry.getAmount() == entry.getAmount()
                    && currentEntry.getCategory().equals(entry.getCategory())
                    && currentEntry.getDate().equals(entry.getDate())) {
                savingsEntries.remove(currentEntry);
                System.out.println("Savings entry deleted for " + email);
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Savings entry not found for " + email);
        }
    }

    public List<IncomeEntry> getIncomeEntries() {
        return incomeEntries;
    }

    public List<ExpenseEntry> getExpenseEntries() {
        return expenseEntries;
    }

    public List<InvestmentEntry> getInvestmentEntries() {return investmentEntries;}

    public List<SavingsEntry> getSavingsEntries() {return savingsEntries;}
}