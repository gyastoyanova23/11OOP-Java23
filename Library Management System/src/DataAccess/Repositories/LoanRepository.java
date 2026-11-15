package DataAccess.Repositories;
import BusinessLogic.Models.Loan;
import java.util.ArrayList;
import java.util.List;
public class LoanRepository {
    private final List<Loan> loans = new ArrayList<>();
    public void save(Loan loan) {
        loans.add(loan);
    }
    public List<Loan> findAll() {
        return new ArrayList<>(loans);
    }
}
