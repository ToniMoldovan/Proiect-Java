package Project;
import java.util.Objects;
import java.util.Scanner;

public class Library {
    private int booksInLibrary = 0;
    private int _personId;

    public Library() {
        this.booksInLibrary = 0;
    }

    class Book{
        String bookName;
        String bookAuthor;
        String bookCategory;
        int bookPagesNumber;
        int belongsTo;
        boolean bookPremium;

        Book next;

        //Constructor for when you know the author of the book
        public Book(String bookName, String bookAuthor, String bookCategory, int bookPagesNumber, boolean bookPremium, int belongsTo) {
            this.bookName = bookName;
            this.bookAuthor = bookAuthor;
            this.bookCategory = bookCategory;
            this.bookPagesNumber = bookPagesNumber;
            this.bookPremium = bookPremium;
            this.belongsTo = belongsTo;
        }

        // Constructor for when you don't know the author
        public Book(String bookName, String bookCategory, int bookPagesNumber, boolean bookPremium, int belongsTo) {
            this.bookName = bookName;
            this.bookCategory = bookCategory;
            this.bookPagesNumber = bookPagesNumber;
            this.bookPremium = bookPremium;
            this.belongsTo = belongsTo;
        }

    }

    //Represent the head and tail of the singly linked list
    public Book head = null;
    public Book tail = null;

    //addNewBookInLibrary() will add a new node to the list
    public void addNewBookInLibrary(String bookName, String bookAuthor, String bookCategory, int bookPagesNumber, boolean bookPremium, int belongsTo) {
        //Create a new node
        boolean isBanned = People.checkIfPersonIsBannedById(belongsTo);

        if (!isBanned) {
            Book newBook = new Book(bookName, bookAuthor, bookCategory, bookPagesNumber, bookPremium, belongsTo);
            this.booksInLibrary++; //Incrementing the number of books in this library

            //Checks if the list is empty
            if(this.head == null) {
                //If list is empty, both head and tail will point to new node
                this.head = newBook;
                tail = newBook;
            }
            else {
                //newNode will be added after tail such that tail's next will point to newNode
                tail.next = newBook;
                //newNode will become new tail of the list
                tail = newBook;
            }
        }
        else {
            System.out.println("I'm sorry. This user is banned.");
        }

    }

    //showAllBooksInLibrary() will display all the nodes present in the list
    public void showAllBooksInLibrary() {
        //Node current will point to head
        Book current = head;
        int numberOfBooks = getBooksInLibrary();

        if(head == null) {
            System.out.println("Library is empty");
            return;
        }
        System.out.println("All books in the library (" + numberOfBooks + ")");
        while(current != null) {
            //Prints each node by incrementing pointer
            System.out.println("Book [" + current.bookName + "] Author [" + current.bookAuthor + "] Category [" + current.bookCategory + "] No. pages [" + current.bookPagesNumber + "] Is Premium [" + current.bookPremium + "] Belongs to [" + current.belongsTo + "].");
            current = current.next;
        }
        System.out.println("\n");
    }

    public void showBooksById(int id) {
        Book current = head;
        int numberOfBooks = 0;

        if(head == null) {
            System.out.println("Library is empty");
            return;
        }

        while (current != null) {
            if (current.belongsTo == id) {
                System.out.println("Book [" + current.bookName + "] Author [" + current.bookAuthor + "] Category [" + current.bookCategory + "] No. pages [" + current.bookPagesNumber + "] Is Premium [" + current.bookPremium + "] Belongs to [" + current.belongsTo + "].");
                numberOfBooks++;
            }
            current = current.next;
        }
        System.out.println("Number of books in this library (" + numberOfBooks + ")\n");

    }

    public void setAllBooksByIdOnZero(int id) { //for when you want to delete a user, set all his books on zero

    }
    public int getBooksInLibrary() {
        return booksInLibrary;
    }

}
