package BusinessLogic.Models;
import BusinessLogic.Models.*;
import java.time.LocalDate;

public class Loan {
    private Book book;
    private Student student;
    private LocalDate loanDate;
    private boolean isReturned;

    public Loan(Book book, Student student) {
        this.book = book;
        this.student = student;
        this.loanDate = LocalDate.now();
        this.isReturned = false;
    }

    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public boolean isReturned() {
        return isReturned;
    }
    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
