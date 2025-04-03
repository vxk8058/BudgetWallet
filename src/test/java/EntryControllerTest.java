import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntryControllerTest {
    private User user;
    private IncomeEntry incomeEntry;
    private ExpenseEntry expenseEntry;

    @BeforeEach
    public void setUp() {
        user = new User("test@example.com", "password123");
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

}
