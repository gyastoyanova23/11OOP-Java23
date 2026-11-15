package DataAccess.Repositories;
import BusinessLogic.Models.Book;

import java.util.ArrayList;
import java.util.List;
public class BookRepository {
    private final List<Book> books = new ArrayList<>();
    public void save(Book book) {
        books.add(book);
    }
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }
}
