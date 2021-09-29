import java.util.Objects;
import java.util.Scanner;

public class Library {
    String libraryName;
    private int booksInLibrary = 0;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.booksInLibrary = 0;

        System.out.println("Library „" + libraryName + "” created successfully!");
    }

    class Book{
        String bookName;
        String bookAuthor;
        String bookCategory;
        int bookPagesNumber;
        boolean bookPremium;

        Book next;

        //Constructor for when you know the author of the book
        public Book(String bookName, String bookAuthor, String bookCategory, int bookPagesNumber, boolean bookPremium) {
            this.bookName = bookName;
            this.bookAuthor = bookAuthor;
            this.bookCategory = bookCategory;
            this.bookPagesNumber = bookPagesNumber;
            this.bookPremium = bookPremium;
        }

        // Constructor for when you don't know the author
        public Book(String bookName, String bookCategory, int bookPagesNumber, boolean bookPremium) {
            this.bookName = bookName;
            this.bookCategory = bookCategory;
            this.bookPagesNumber = bookPagesNumber;
            this.bookPremium = bookPremium;
        }

    }

    //Represent the head and tail of the singly linked list
    public Book head = null;
    public Book tail = null;

    //addNewBookInLibrary() will add a new node to the list
    public void addNewBookInLibrary(String bookName, String bookAuthor, String bookCategory, int bookPagesNumber, boolean bookPremium) {
        //Create a new node
        Book newBook = new Book(bookName, bookAuthor, bookCategory, bookPagesNumber, bookPremium);
        this.booksInLibrary++; //Incrementing the number of books in this library

        //Checks if the list is empty
        if(head == null) {
            //If list is empty, both head and tail will point to new node
            head = newBook;
            tail = newBook;
        }
        else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newBook;
            //newNode will become new tail of the list
            tail = newBook;
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
        System.out.println("Books of this library (" + numberOfBooks + "): ");
        while(current != null) {
            //Prints each node by incrementing pointer
            System.out.println("Book [" + current.bookName + "] Author [" + current.bookAuthor + "] Category [" + current.bookCategory + "] No. pages [" + current.bookPagesNumber + "] Is Premium [" + current.bookPremium + "].");
            current = current.next;
        }
        System.out.println();
    }

    public int getBooksInLibrary() {
        return booksInLibrary;
    }
}
