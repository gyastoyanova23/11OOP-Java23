package Presentation;
import BusinessLogic.Services.BookService;
import BusinessLogic.Services.LoanService;
import DataAccess.Repositories.BookRepository;
import DataAccess.Repositories.LoanRepository;
import DataAccess.Repositories.StudentRepository;
import Presentation.LibraryMenu;

class Main{
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        LoanRepository loanRepository = new LoanRepository();
        StudentRepository studentRepository = new StudentRepository();
        LoanService loanService = new LoanService(loanRepository, bookRepository, studentRepository);
        BookService bookService = new BookService(bookRepository, loanRepository);
        LibraryMenu libraryMenu = new LibraryMenu(bookService, loanService);
        libraryMenu.showMenu();
    }
}