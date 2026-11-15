package Presentation;
import BusinessLogic.Services.BookService;
import BusinessLogic.Services.LoanService;

import java.util.Scanner;
public class LibraryMenu {
    BookService bookService;
    LoanService loanService;
    public LibraryMenu(BookService bookService, LoanService loanService) {
        this.bookService = bookService;
        this.loanService = loanService;
    }
    public void showMenu(){
        boolean bool = true;
        while(bool){
            System.out.println("Library Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Show all books");
            System.out.println("3. Search book");
            System.out.println("4. Edit book");
            System.out.println("5. Delete book");
            System.out.println("6. Borrow book");
            System.out.println("7. Return book");
            System.out.println("8. Show available books");
            System.out.println("0. Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.next();
                    System.out.print("Enter book author: ");
                    String author = sc.next();
                    System.out.print("Enter book isbn: ");
                    String isbn = sc.next();
                    System.out.print("Enter book year: ");
                    int year = sc.nextInt();
                    bookService.addBook(title,author,isbn,year);
                    break;
                case 2:
                    bookService.showAllBooks();
                    break;
                case 3:
                    System.out.print("Enter book title: ");
                    String title1 = sc.next();
                    bookService.searchBook(title1);
                    break;
                case 4:
                    System.out.print("Enter book isbn: ");
                    String isbn1 = sc.next();
                    System.out.print("Enter new book title: ");
                    String title2 = sc.next();
                    System.out.print("Enter new book author: ");
                    String author1 = sc.next();
                    System.out.print("Enter new book year: ");
                    int year1 = sc.nextInt();
                    bookService.editBook(title2,author1,isbn1,year1);
                    break;
                case 5:
                    System.out.print("Enter book isbn: ");
                    String isbn4 = sc.next();
                    bookService.deleteBook(bookService.findBookByIsbn(isbn4));
                    break;
                case 6:
                    System.out.print("Enter book isbn: ");
                    String isbn2 = sc.next();
                    System.out.println("login or sign in for student");
                    System.out.print("Enter full name of student: ");
                    String firstName = sc.next();
                    String lastName = sc.next();
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    loanService.borrowBook(bookService.findBookByIsbn(isbn2), firstName, lastName, id);
                    break;
                case 7:
                    System.out.print("Enter book isbn: ");
                    String isbn3 = sc.next();
                    System.out.print("student id: ");
                    int id1 = sc.nextInt();
                    loanService.returnBook(bookService.findBookByIsbn(isbn3), id1);
                    break;
                case 8:
                    System.out.println(loanService.getAvailableBooks());
                    break;
                case 0:
                    bool = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
