import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EntryControllerTest {
    private User user;
    private IncomeEntry incomeEntry;
    private ExpenseEntry expenseEntry;

    @BeforeEach
    public void setUp() {
        user = new User("test@example.com", "password123",
                "firstName", "lastName");
        incomeEntry = new IncomeEntry(500, "Salary", "03-30-2025");
        expenseEntry = new ExpenseEntry(200, "Groceries", "03-30-2025");
    }

    @Test
    public void testAddIncomeEntry() { // test to see if the income entry has been added
        user.addIncomeEntry(incomeEntry);
        assertEquals(1, user.getIncomeEntries().size());
    }

    @Test
    public void testDeleteIncomeEntry() { // test to see if the added income entry gets deleted
        user.addIncomeEntry(incomeEntry);
        assertEquals(1, user.getIncomeEntries().size());

        user.deleteIncomeEntry(incomeEntry);
        assertEquals(0, user.getIncomeEntries().size(), "Income entry should be deleted");
    }

    @Test
    public void testAddExpenseEntry() { // test to see if the expense entry has been added
        user.addExpenseEntry(expenseEntry);
        assertEquals(1, user.getExpenseEntries().size());
    }

    @Test
    public void testDeleteExpenseEntry() {  // test to see if the expense income entry gets deleted
        user.addExpenseEntry(expenseEntry);
        assertEquals(1, user.getExpenseEntries().size());

        user.deleteExpenseEntry(expenseEntry);
        assertEquals(0, user.getExpenseEntries().size(), "Expense entry should be deleted");
    }

    @Test
    public void testInvalidIncomeCategoryThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new IncomeEntry(300, "Freelance", "04-01-2025")
        );
        assertEquals("Invalid income category: Freelance", exception.getMessage());
    }

    @Test
    public void testInvalidExpenseCategoryThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new ExpenseEntry(100, "Tuition", "04-01-2025")
        );
        assertEquals("Invalid expense category: Tuition", exception.getMessage());
    }

    @Test
    public void testNegativeIncomeAmount() {
        IncomeEntry negativeIncome = new IncomeEntry(-500, "Bonus", "04-01-2025");
        assertEquals(-500, negativeIncome.getAmount());
    }

    @Test
    public void testNegativeExpenseAmount() {
        ExpenseEntry negativeExpense = new ExpenseEntry(-200, "Rent", "04-01-2025");
        assertEquals(-200, negativeExpense.getAmount());
    }

    @Test
    public void testInvalidIncomeDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new IncomeEntry(300, "Commission", "April 2, 2025")
        );
        assertEquals("Invalid date format: April 2, 2025. Expected MM-DD-YYYY", exception.getMessage());
    }

    @Test
    public void testMultipleValidEntries() {
        user.addIncomeEntry(new IncomeEntry(1000, "Bonus", "04-02-2025"));
        user.addIncomeEntry(new IncomeEntry(200, "Tip", "04-03-2025"));
        user.addExpenseEntry(new ExpenseEntry(100, "Travel", "04-04-2025"));
        user.addExpenseEntry(new ExpenseEntry(250, "Gas", "04-05-2025"));

        assertEquals(2, user.getIncomeEntries().size());
        assertEquals(2, user.getExpenseEntries().size());
    }

    @Test
    public void testAddInvestmentEntry() {
        InvestmentEntry investment = new InvestmentEntry("Tesla", "Stocks", 100);
        user.addInvestmentEntry(investment);
        assertEquals(1, user.getInvestmentEntries().size());
    }

    @Test
    public void testDeleteInvestmentEntry() {
        InvestmentEntry investment = new InvestmentEntry("Tesla", "Stocks", 100);
        user.addInvestmentEntry(investment);
        user.deleteInvestmentEntry(investment);
        assertEquals(0, user.getInvestmentEntries().size());
    }

    @Test
    public void testNegativeInvestmentValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new InvestmentEntry("Apple", "Stocks", -100)
        );
        assertEquals("Investment value must be positive", exception.getMessage());
    }

    @Test
    public void testInvalidInvestmentCategory() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new InvestmentEntry("Dogecoin", "Crypto", 100)
        );
        assertEquals("Invalid investment category: Crypto", exception.getMessage());
    }

    @Test
    public void testEmptyInvestmentName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new InvestmentEntry("", "Real Estate", 1000)
        );
        assertEquals("Investment name cannot be empty", exception.getMessage());
    }

    @Test
    public void testAddSavingsEntry() {
        SavingsEntry savings = new SavingsEntry(300, "Emergency Funds", "04-12-2025");
        user.addSavingsEntry(savings);
        assertEquals(1, user.getSavingsEntries().size());
    }

    @Test
    public void testDeleteSavingsEntry() {
        SavingsEntry savings = new SavingsEntry(300, "Emergency Funds", "04-12-2025");
        user.addSavingsEntry(savings);
        user.deleteSavingsEntry(savings);
        assertEquals(0, user.getSavingsEntries().size());
    }

    @Test
    public void testInvalidSavingsDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new SavingsEntry(200, "Car", "April 1, 2025")
        );
        assertEquals("Invalid date format: April 1, 2025. Expected MM-DD-YYYY", exception.getMessage());
    }

    @Test
    public void testInvalidSavingsCategory() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new SavingsEntry(400, "Wedding", "04-12-2025")
        );
        assertEquals("Invalid savings category: Wedding", exception.getMessage());
    }

    @Test
    public void testNegativeSavingsAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new SavingsEntry(-200, "Vacation", "04-02-3035")
        );
        assertEquals("Savings amount must be positive", exception.getMessage());
    }

}