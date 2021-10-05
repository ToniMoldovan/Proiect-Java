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
        private int _bookId = booksInLibrary + 1;
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

    public void addNewBookInLibraryUnkownAuthor(String bookName, String bookCategory, int bookPagesNumber, boolean bookPremium, int belongsTo) {
        //Create a new node
        boolean isBanned = People.checkIfPersonIsBannedById(belongsTo);

        if (!isBanned) {
            Book newBook = new Book(bookName, bookCategory, bookPagesNumber, bookPremium, belongsTo);
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
        System.out.println("All categories: (1) SF | (2) Adventure | (3) Programming | (4) Comedy");
        System.out.println("All books in the library (" + numberOfBooks + ")");
        while(current != null) {
            //Prints each node by incrementing pointer
            System.out.println("Book ID [" + current._bookId + "] Name [" + current.bookName + "] Author [" + current.bookAuthor + "] Category [" + current.bookCategory + "] No. pages [" + current.bookPagesNumber + "] Is Premium [" + current.bookPremium + "] Belongs to [" + current.belongsTo + "].");
            current = current.next;
        }
        System.out.println("\n");
    }

    public void showBooksPersonById(int id) {
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

    public void addBookToPersonLibraryById(int id) {
        Book current = head;
        System.out.println("Input the book ID you want to add: ");
        Scanner sc = new Scanner(System.in);
        int bookId = sc.nextInt();

        while (current != null) {
            if (current._bookId == bookId && current.belongsTo == 0) {
                current.belongsTo = id;
            }
            else if (current.belongsTo != 0) {
                System.out.println("This book belongs to [" + current.bookAuthor + "].");
            }
            current = current.next;
        }
    }

    public void removeBookById(int position) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter admin password: ");
        String adminPw = sc.nextLine();

        int booksNumber = getBooksInLibrary();

        if (adminPw.equals("pufuleti")) {
            position = position - 1;
            // If linked list is empty
            if (head == null)
                return;

            // Store head node
            Book temp = head;

            // If head needs to be removed
            if (position == 0)
            {
                head = temp.next;   // Change head
                booksNumber = booksNumber - 1;
                setBooksInLibrary(booksNumber);
                return;
            }

            // Find previous node of the node to be deleted
            for (int i=0; temp!=null && i<position-1; i++)
                temp = temp.next;

            // If position is more than number of nodes
            if (temp == null || temp.next == null)
                return;

            // Node temp->next is the node to be deleted
            // Store pointer to the next of node to be deleted
            booksNumber = booksNumber - 1;
            setBooksInLibrary(booksNumber);
            Book next = temp.next.next;

            temp.next = next;  // Unlink the deleted node from list
        }
        else {
            System.out.println("The password is incorrect.");
            return;
        }
    }

    public void setBookByIdOnZero() { //for when you want to delete a user, set all his books on zero
        Book current = head;
        System.out.println("Input the book ID you want to set on zero: ");
        Scanner sc = new Scanner(System.in);
        int bookId = sc.nextInt();

        while (current != null) {
            if (current._bookId == bookId && current.belongsTo != 0) {
                current.belongsTo = 0;
            }
            else if (current.belongsTo == 0) {
                System.out.println("This book already belongs to nobody.");
            }
            current = current.next;
        }
    }

    public int getBooksInLibrary() {
        return booksInLibrary;
    }

    public void setBooksInLibrary(int booksInLibrary) {
        this.booksInLibrary = booksInLibrary;
    }
}
