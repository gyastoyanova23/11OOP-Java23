package BusinessLogic.Services;
import DataAccess.Repositories.BookRepository;
import DataAccess.Repositories.LoanRepository;
import BusinessLogic.Models.Loan;
import BusinessLogic.Models.Book;
import BusinessLogic.Models.Student;
import DataAccess.Repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;
    public LoanService(LoanRepository loanRepository,  BookRepository bookRepository,  StudentRepository studentRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
    }

    public void borrowBook(Book book, String firstName, String lastName, int id) {
        Student student = null;
        for (Student s : studentRepository.findAll()) {
            if (s.getId() == id) {
                student = s;
                break;
            }
        }
        if (student == null) {
            student = new Student(firstName, lastName, id);
            studentRepository.save(student);
        }

        studentRepository.save(student);
        for (Loan loan : loanRepository.findAll()) {
            if (loan.getBook().equals(book) && !loan.isReturned()) {
                System.out.println("the book is already borrowed");
                return;
            }
        }
        int activeLoansCount = 0;
        for (Loan loan : loanRepository.findAll()) {
            if (loan.getStudent().equals(student) && !loan.isReturned()) {
                activeLoansCount++;
            }
        }
        if (activeLoansCount >= 1) {
            System.out.println("The student can't have more than 3 loans.");
            return;
        }
        Loan newLoan = new Loan(book, student);
        loanRepository.save(newLoan);
    }
    public void returnBook(Book book, int studentId) {
        for (Loan loan : loanRepository.findAll()) {
            if (loan.getBook().equals(book) && loan.getStudent().getId() == studentId && !loan.isReturned()) {
                loan.setReturned(true);
                System.out.println(loan.getBook() + " has been returned.");
                return;
            }
        }
        System.out.println("the book is not borrowed by this student");
    }
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            boolean isBorrowed = false;
            for (Loan loan : loanRepository.findAll()) {
                if (loan.getBook().equals(book) && !loan.isReturned()) {
                    isBorrowed = true;
                    break;
                }
            }
            if (!isBorrowed) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}
