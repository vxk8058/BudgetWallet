import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    @Autowired
    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public IncomeEntry addIncome(IncomeEntry incomeEntry) {
        InputValidator validator = new InputValidator();
        if (!validator.validateAmount(incomeEntry.getAmount())) {
            throw new IllegalArgumentException("Invalid amount: " + incomeEntry.getAmount());
        }

        if (!validator.validateDate(incomeEntry.getDate())) {
            throw new IllegalArgumentException("Invalid date format: " + incomeEntry.getDate() + ". Expected MM-DD-YYYY");
        }

        return incomeRepository.save(incomeEntry);
    }

    public List<IncomeEntry> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public void deleteIncome(Long id) {
        Optional<IncomeEntry> incomeEntry = incomeRepository.findById(id);
        if (incomeEntry.isPresent()) {
            incomeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Income entry not found with id: " + id + " not found");
        }
    }
}