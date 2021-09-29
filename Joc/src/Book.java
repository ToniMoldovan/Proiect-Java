public class Book {
    String bookName;
    String bookAuthor;
    String bookCategory;
    int bookPagesNumber;
    boolean bookPremium;

    // Constructor for all details
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

    // Method for showing book details
    public String showBookDetails() {
        return "Book [" + bookName + "] Author [" + bookAuthor + "] Category [" + bookCategory + "] No. pages [" + bookPagesNumber + "] Is Premium [" + bookPremium + "].";
    }
}
