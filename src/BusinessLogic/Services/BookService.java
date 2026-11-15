package BusinessLogic.Services;
import DataAccess.Repositories.BookRepository;
import BusinessLogic.Models.Book;

public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void addBook(String title, String author, String isbn, int year) {
        Book book = new Book(title, author, isbn, year);
        if (book.getTitle() == null || book.getTitle().isBlank()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        bookRepository.save(book);
    }

}
