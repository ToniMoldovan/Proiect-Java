import java.util.Objects;
import java.util.Scanner;
import java.lang.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        People person = new People();
        person.createNewPerson("Toni", 111, true);
        person.library.addNewBookInLibrary("verde", "Daria Barac", "Beauty", 13, true);
        person.library.addNewBookInLibrary("rosu", "Daria Barac", "Programming", 10, false);
        person.library.addNewBookInLibrary("maro", "Daria Barac", "Dance", 123, true);

        person.showAllPeople();

        person.library.showAllBooksInLibrary();

    }

    public static void mainMenu() throws InterruptedException {
        System.out.println("------| Library Menu |------");
        System.out.println("Available categories: (0) SF | (1) Adventure | (2) Programming | (3) Comedy");
        System.out.println("Available options:\n1) See all books in the library\n" +
                "2) Choose a book from the library\n3) See your books\n4) Add a new book to the library" +
                "\n5) Create new person \n6) Exit program");
        System.out.println("----------------------------\n");
        System.out.println("Enter your choice: ");

        Scanner sc = new Scanner(System.in);
        String response = new String();

        response = sc.next();

        if (Objects.equals(response, "6")) {
            System.exit(0);
        } else if (Objects.equals(response, "1")) {
            //showAllBooksInLibrary();
        } else if (Objects.equals(response, "2")) {
            //chooseBookFromLibrary();
        } else if (Objects.equals(response, "3")) {
            //showPersonBooks();
        } else if (Objects.equals(response, "4")) {
            //addNewBookInLibrary();
        } else if (Objects.equals(response, "5")) {
            //createNewPerson();
        }
        else {
            System.out.println("I can't understand your answer. Please try again.");
            TimeUnit.SECONDS.sleep(2);
            mainMenu();
        }
    }

}
