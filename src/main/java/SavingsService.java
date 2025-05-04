import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsService {

    @Autowired
    private SavingsRepository savingsRepository;

    @Autowired
    public SavingsService(SavingsRepository savingsRepository) {
        this.savingsRepository = savingsRepository;
    }

    public SavingsEntry addSavings(SavingsEntry savingsEntry) {
        InputValidator validator = new InputValidator();
        if (!validator.validateAmount(savingsEntry.getAmount())) {
            throw new IllegalArgumentException("Invalid amount: " + savingsEntry.getAmount());
        }

        if (!validator.validateDate(savingsEntry.getDate())) {
            throw new IllegalArgumentException("Invalid date format: " + savingsEntry.getDate() + ". Expected MM-DD-YYYY");
        }

        return savingsRepository.save(savingsEntry);
    }

    public List<SavingsEntry> getAllSavings() {
        return savingsRepository.findAll();
    }

    public void deleteSavings(int id) {
        Optional<SavingsEntry> existingSavings = savingsRepository.findById(id);
        if (existingSavings.isPresent()) {
            savingsRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Income entry not found with id: " + id);
        }
    }
}
