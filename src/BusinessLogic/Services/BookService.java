package BusinessLogic.Services;
import DataAccess.Repositories.BookRepository;
import BusinessLogic.Models.Book;
import BusinessLogic.Models.Loan;
import DataAccess.Repositories.LoanRepository;


public class BookService {
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;
    public BookService(BookRepository bookRepository, LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
    }
    public Book findBookByIsbn(String isbn) {
        for (Book book : bookRepository.findAll()) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    public void addBook(String title, String author, String isbn, int year) {
        Book book = new Book(title, author, isbn, year);
        if (book.getTitle() == null || book.getTitle().isBlank()) {
            System.out.println("Title cannot be null or empty");
        }else if (findBookByIsbn(isbn) != null) {
            System.out.println("Book already exists");
        }else{
            bookRepository.save(book);
        }
    }
    public void showAllBooks() {
        int count = 0;
        for (Book book : bookRepository.findAll()) {
            count++;
            System.out.println("added book" + count + ": " + book.toString());
        }
    }
    public void searchBook(String title) {
        for (Book book : bookRepository.findAll()) {
            if (book.getTitle().equals(title)) {
                System.out.println("found book: " + book.toString());
            }
        }
    }
    public void editBook(String newtitle, String newauthor, String isbn, int newyear) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }
        book.setTitle(newtitle);
        book.setAuthor(newauthor);
        book.setYear(newyear);
        bookRepository.save(book);
        System.out.println("edited book to: " + book.toString());
    }
    public void deleteBook(Book book) {
        if (book == null) {
            System.out.println("Book with ISBN " + book.getIsbn() + " not found.");
        }
        for (Loan loan : loanRepository.findAll()) {
            if (loan.getBook().equals(book) && !loan.isReturned()) {
                System.out.println("Cannot delete the book because it is currently borrowed.");
                return;
            }
        }
        bookRepository.delete(book);
        System.out.println("Book has been deleted");
    }
}
