import java.util.Objects;
import java.util.Scanner;
import java.lang.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        libraryMenu();
    }

    public static void libraryMenu() throws InterruptedException {
        System.out.println("------| Library Menu |------");
        System.out.println("Available categories: (0) SF | (1) Adventure | (2) Programming | (3) Comedy");
        System.out.println("Available options:\n1) See all books in the library\n2) Chose a book category from the library\n3) See your books\n4) Exit program");
        System.out.println("----------------------------\n");
        System.out.println("Enter your choice: ");

        Scanner sc = new Scanner(System.in);
        String response = new String();

        response = sc.next();

        if (Objects.equals(response, "4")) {
            System.exit(0);
        } else if (Objects.equals(response, "1")) {
            //showAllBooksInLibrary();
        } else if (Objects.equals(response, "2")) {
            //showAllBookCategories();
        } else if (Objects.equals(response, "3")) {
            //showPersonBooks();
        } else {
            System.out.println("I can't understand your answer. Please try again.");
            TimeUnit.SECONDS.sleep(2);
            libraryMenu();
        }
    }
}
