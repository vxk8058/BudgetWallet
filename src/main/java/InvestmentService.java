import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentService {

    private final InvestmentRepository investmentRepository;

    @Autowired
    public InvestmentService(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    // Fetch all investment entries
    public List<InvestmentEntry> getAllInvestments() {
        return investmentRepository.findAll();
    }

    // Add a new investment entry
    public InvestmentEntry addInvestment(InvestmentEntry investmentEntry) {
        // Validate name, category, and amount before saving
        InputValidator validator = new InputValidator();

        if (investmentEntry.getAmount() < 0) {
            throw new IllegalArgumentException("Investment value must be positive");
        }

        if (!InvestmentEntry.investment_categories.contains(investmentEntry.getCategory())) {
            throw new IllegalArgumentException("Invalid investment category: " + investmentEntry.getCategory());
        }

        return investmentRepository.save(investmentEntry);
    }

    // Delete an investment entry by ID
    public void deleteInvestment(Long id) {
        Optional<InvestmentEntry> existingInvestment = investmentRepository.findById(id);
        if (existingInvestment.isPresent()) {
            investmentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Investment entry with ID " + id + " not found");
        }
    }

    // Fetch a specific investment entry by ID
    public Optional<InvestmentEntry> getInvestmentById(Long id) {
        return investmentRepository.findById(id);
    }
}
