package Presentation;
import BusinessLogic.Services.BookService;
import java.util.Scanner;
public class LibraryMenu {
    BookService bookService;
    public LibraryMenu(BookService bookService) {
        this.bookService = bookService;
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
                    String title = sc.nextLine();
                    String author = sc.nextLine();
                    String isbn = sc.nextLine();
                    int year = sc.nextInt();
                    bookService.addBook(title,author,isbn,year);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
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
