package repository;

import model.Book;
import model.Loan;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUser(User user);
    List<Loan> findByReturnDateIsNull();
    List<Loan> findByBook(Book book);
    boolean existsByBookAndReturnDateIsNull(Book book);
}
