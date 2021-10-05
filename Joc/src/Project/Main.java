package Project;
import java.util.Objects;
import java.util.Scanner;
import java.lang.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        People person = new People();
        mainMenu(person);

    }

    public static void mainMenu(People person) throws InterruptedException {
        System.out.println("------| Library Menu |------");
        System.out.println("1) Create person");
        System.out.println("2) Show all the people");
        System.out.println("3) Ban person");
        System.out.println("4) Unban person");
        System.out.println("------| General Library |-----");
        System.out.println("5) See all the books in the library");
        System.out.println("6) Add a book to the library");
        System.out.println("7) Remove a book from the library");
        System.out.println("------| People Library |----");
        System.out.println("8) See all books of a person by Id");
        System.out.println("9) Add a book to person by Id");
        System.out.println("10) Remove a book to person by Id");
        System.out.println("----------------------------");
        System.out.println("11) Exit program");

        System.out.println("Enter your choice: ");

        Scanner sc = new Scanner(System.in);
        String response = new String();

        response = sc.next();

        if (Objects.equals(response, "11")) {
            System.out.println("Bye :)");
            System.exit(0);
        } else if (Objects.equals(response, "1")) {
            createPerson(person);
        } else if (Objects.equals(response, "2")) {
            person.showAllPeople();
        } else if (Objects.equals(response, "3")) {
            banPerson(person);
        } else if (Objects.equals(response, "4")) {
            unbanPerson(person);
        } else if (Objects.equals(response, "5")) {
            showAllBooksInGeneralLibrary(person);
        } else if (Objects.equals(response, "6")) {
            addBookToGeneralLibrary(person);
        } else if (Objects.equals(response, "7")) {
            //createNewPerson();
        } else if (Objects.equals(response, "8")) {
            //createNewPerson();
        } else if (Objects.equals(response, "9")) {
            //createNewPerson();
        } else if (Objects.equals(response, "10")) {
            //createNewPerson();
        } else {
            System.out.println("I can't understand your answer. Please try again.\n");
            TimeUnit.SECONDS.sleep(2);
            mainMenu(person);
        }
    }

    public static void createPerson(People person) throws InterruptedException {
        System.out.println("Do you want an Administrator account? (yes/no)");
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();

        String adminPasword = person.get_adminPassword();

        //Person info's
        String personName;
        boolean isAdmin = false;

        if (Objects.equals(answer, "yes") || Objects.equals(answer, "Yes") || Objects.equals(answer, "YES")) {
            System.out.println("Please enter the Administrator Password to continue: ");
            String answer2 = sc.next();
            if (answer2.equals(adminPasword))  //Password accepted
                isAdmin = true;
            else {
                System.out.println("The password is incorrect. Try again or quit.\n");
                createPerson(person);
            }
        }

        System.out.println("Enter person's name: ");
        personName = sc.next();

        //Creating person
        person.createNewPerson(personName, isAdmin);
        mainMenu(person);
    }

    public static void banPerson(People person) throws InterruptedException {
        System.out.println("Enter Admin Password to proceed: ");

        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        boolean isAdmin = false;

        String adminPasword = person.get_adminPassword();
        if (answer.equals(adminPasword))  //Password accepted
            isAdmin = true;
        else {
            System.out.println("The password is incorrect. Try again or quit.\n");
            banPerson(person);
        }

        if (isAdmin) {
            System.out.println("Enter the person's ID to ban: ");
            int persId = sc.nextInt();
            person.banPersonById(persId);
        }
        mainMenu(person);
    }

    public static void unbanPerson(People person) throws InterruptedException {
        System.out.println("Enter Admin Password to proceed: ");

        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        boolean isAdmin = false;

        String adminPasword = person.get_adminPassword();
        if (answer.equals(adminPasword))  //Password accepted
            isAdmin = true;
        else {
            System.out.println("The password is incorrect. Try again or quit.\n");
            banPerson(person);
        }

        if (isAdmin) {
            System.out.println("Enter the person's ID to unban: ");
            int persId = sc.nextInt();
            person.unbanPersonById(persId);
        }
        mainMenu(person);
    }

    public static void addBookToGeneralLibrary(People person) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Scanner buffer = new Scanner(System.in);
        System.out.println("Do you know the author? (yes/no)");
        String authorKnown = sc.nextLine();


        //Book(bookName, bookAuthor, bookCategory, bookPagesNumber, bookPremium, belongsTo)
        if (authorKnown.equals("yes")) {
            String bookName;
            String bookAuthor;
            String bookCategory;
            int bookPageNumber;
            boolean premiumBook = false;

            System.out.println("Enter the book name: ");
            bookName = sc.nextLine();
            System.out.println("[log]Bookname:" + bookName);

            System.out.println("Enter the book author: ");
            bookAuthor = sc.nextLine();

            System.out.println("Enter the book category (1/2/3/4): ");
            bookCategory = sc.next();

            System.out.println("Enter the number of pages: ");
            bookPageNumber = sc.nextInt();

            System.out.println("Is this a premium book? (yes/no)");
            String isPremium = sc.next();

            if (isPremium.equals("yes")) {
                premiumBook = true;
            }

            person.library.addNewBookInLibrary(bookName, bookAuthor, bookCategory, bookPageNumber, premiumBook, 0);
            System.out.println("Book created successfully!");
        }
        //Book(String bookName, String bookCategory, int bookPagesNumber, boolean bookPremium, int belongsTo)
        else if (authorKnown.equals("no")) {
            String bookName;
            String bookCategory;
            int bookPageNumber;
            boolean premiumBook = false;

            System.out.println("Enter the book name: ");
            bookName = sc.nextLine();
            System.out.println("[log]Bookname:" + bookName);

            System.out.println("Available categories: (1) SF | (2) Adventure | (3) Programming | (4) Comedy");
            System.out.println("Enter the book category: ");
            bookCategory = sc.nextLine();

            System.out.println("Enter the number of pages: ");
            bookPageNumber = sc.nextInt();

            System.out.println("Is this a premium book? (yes/no)");
            String isPremium = sc.next();

            if (isPremium.equals("yes")) {
                premiumBook = true;
            }

            person.library.addNewBookInLibraryUnkownAuthor(bookName, bookCategory, bookPageNumber, premiumBook, 0);
            System.out.println("Book created successfully!");
        }
        else {
            System.out.println("I didn't understand your message.");
        }

        mainMenu(person);
    }

    public static void showAllBooksInGeneralLibrary(People person) throws InterruptedException {
        person.library.showAllBooksInLibrary();
        mainMenu(person);
    }
}
