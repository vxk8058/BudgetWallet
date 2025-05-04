import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FinancialEntryController {

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private SavingsService savingsService;

    @Autowired
    private InvestmentService investmentService;


    @PostMapping("/income")
    public ResponseEntity<?> addIncome(@RequestBody Map<String, String> payload) {
        try {
            // Extracting expense details from the request payload
            int amount = Integer.parseInt(payload.get("amount"));
            String category = payload.get("category");
            String date = payload.get("date");

            // Creating an ExpenseEntry object
            IncomeEntry incomeEntry = new IncomeEntry(amount, category, date);

            // Call the service to add the expense entry
            IncomeEntry savedIncome = incomeService.addIncome(incomeEntry);
            return ResponseEntity.ok(savedIncome);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());  // Frontend will see this
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid input data.");
        }
    }

    @GetMapping("/income")
    public ResponseEntity<?> getIncome() {
        return ResponseEntity.ok(incomeService.getAllIncomes());
    }

    @DeleteMapping("/income/{id}")
    public ResponseEntity<?> deleteIncome(@PathVariable Long id) {
        try {
            incomeService.deleteIncome(id); // Call the service method to delete income entry
            return ResponseEntity.ok("Income entry deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Handle errors if ID is not valid
        }
    }

    @PostMapping("/expense")
    public ResponseEntity<?> addExpense(@RequestBody Map<String, String> payload) {
        try {
            // Extracting expense details from the request payload
            int amount = Integer.parseInt(payload.get("amount"));
            String category = payload.get("category");
            String date = payload.get("date");

            // Creating an ExpenseEntry object
            ExpenseEntry expenseEntry = new ExpenseEntry(amount, category, date);

            // Call the service to add the expense entry
            ExpenseEntry savedExpense = expenseService.addExpense(expenseEntry);
            return ResponseEntity.ok(savedExpense);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());  // Frontend will see this
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid input data.");
        }
    }


    @GetMapping("/expense")
    public ResponseEntity<?> getExpense() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @DeleteMapping("/expense/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        try {
            expenseService.deleteExpense(id);
            return ResponseEntity.ok("Expense entry deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/savings")
    public List<SavingsEntry> getSavingsEntries() {
        return savingsService.getAllSavings();
    }

    @PostMapping("/savings")
    public ResponseEntity<?> addSavings(@RequestBody SavingsEntry savingsEntry) {
        try {
            SavingsEntry savedEntry = savingsService.addSavings(savingsEntry);
            return ResponseEntity.ok(savedEntry);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());  // Frontend will see this
        }
    }

    @DeleteMapping("/savings/{id}")
    public ResponseEntity<?> deleteSavings(@PathVariable int id) {
        try {
            savingsService.deleteSavings(id);
            return ResponseEntity.ok("Savings entry deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to delete savings entry");
        }
    }

    // Get all investment entries
    @GetMapping("/investments")
    public List<InvestmentEntry> getAllInvestments() {
        return investmentService.getAllInvestments();
    }

    // Add a new investment entry
    @PostMapping("/investments")
    public ResponseEntity<?> addInvestment(@RequestBody InvestmentEntry investmentEntry) {
        try {
            InvestmentEntry investment = investmentService.addInvestment(investmentEntry);
            return ResponseEntity.ok(investment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());  // Frontend will see this
        }

    }

    // Delete an investment entry by ID
    @DeleteMapping("/investments/{id}")
    public ResponseEntity<?> deleteInvestment(@PathVariable Long id) {
        try {
            investmentService.deleteInvestment(id);
            return ResponseEntity.ok("Investment entry deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to delete Investment entry");
        }
    }

}
