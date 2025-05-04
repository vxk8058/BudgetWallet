
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Fetch all expense entries
    public List<ExpenseEntry> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Add a new expense entry
    public ExpenseEntry addExpense(ExpenseEntry expenseEntry) {
        // Validate amount, category, and date before saving
        InputValidator validator = new InputValidator();
        if (!validator.validateAmount(expenseEntry.getAmount())) {
            throw new IllegalArgumentException("Invalid amount: " + expenseEntry.getAmount());
        }

        if (!validator.validateDate(expenseEntry.getDate())) {
            throw new IllegalArgumentException("Invalid date format: " + expenseEntry.getDate() + ". Expected MM-DD-YYYY");
        }

        return expenseRepository.save(expenseEntry);
    }

    // Delete an expense entry by ID
    public void deleteExpense(Long id) {
        Optional<ExpenseEntry> existingExpense = expenseRepository.findById(id);
        if (existingExpense.isPresent()) {
            expenseRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Expense entry with ID " + id + " not found");
        }
    }

    // Fetch a specific expense entry by ID
    public Optional<ExpenseEntry> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }
}
