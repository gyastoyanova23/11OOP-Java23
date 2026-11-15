package Presentation;
import BusinessLogic.Services.BookService;
import DataAccess.Repositories.BookRepository;
import Presentation.LibraryMenu;

class Main{
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);
        LibraryMenu libraryMenu = new LibraryMenu(bookService);
        libraryMenu.showMenu();
    }
}