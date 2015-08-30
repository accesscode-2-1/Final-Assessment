package nyc.c4q;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alvin2 on 8/30/15.
 */
public class Book {

    @SerializedName("id")
    private int bookID;

    @SerializedName("title")
    private String bookTitle;

    @SerializedName("author")
    private String bookAuthor;

    @SerializedName("isbn")
    private String bookISBN;

    @SerializedName("isbn13")
    private String bookISBN13;

    @SerializedName("publisher")
    private String bookPublisher;

    @SerializedName("publishyear")
    private int bookPublishYear;

    @SerializedName("checkedout")
    private int bookCheckedOut;

    @SerializedName("checkedoutby")
    private int bookCheckedOutBy;

    @SerializedName("checkoutdateyear")
    private int bookCheckedOutYear;

    @SerializedName("checkoutdatemonth")
    private int bookCheckedOutMonth;

    @SerializedName("checkoutdateday")
    private int bookCheckedOutDay;

    @SerializedName("duedatemonth")
    private int bookDueMonth;

    @SerializedName("duedateday")
    private int bookDueDay;

    @SerializedName("duedateyear")
    private int bookDueYear;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookISBN13() {
        return bookISBN13;
    }

    public void setBookISBN13(String bookISBN13) {
        this.bookISBN13 = bookISBN13;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public int getBookPublishYear() {
        return bookPublishYear;
    }

    public void setBookPublishYear(int bookPublishYear) {
        this.bookPublishYear = bookPublishYear;
    }

    public int getBookCheckedOut() {
        return bookCheckedOut;
    }

    public void setBookCheckedOut(int bookCheckedOut) {
        this.bookCheckedOut = bookCheckedOut;
    }

    public int getBookCheckedOutBy() {
        return bookCheckedOutBy;
    }

    public void setBookCheckedOutBy(int bookCheckedOutBy) {
        this.bookCheckedOutBy = bookCheckedOutBy;
    }

    public int getBookCheckedOutYear() {
        return bookCheckedOutYear;
    }

    public void setBookCheckedOutYear(int bookCheckedOutYear) {
        this.bookCheckedOutYear = bookCheckedOutYear;
    }

    public int getBookCheckedOutMonth() {
        return bookCheckedOutMonth;
    }

    public void setBookCheckedOutMonth(int bookCheckedOutMonth) {
        this.bookCheckedOutMonth = bookCheckedOutMonth;
    }

    public int getBookCheckedOutDay() {
        return bookCheckedOutDay;
    }

    public void setBookCheckedOutDay(int bookCheckedOutDay) {
        this.bookCheckedOutDay = bookCheckedOutDay;
    }

    public int getBookDueMonth() {
        return bookDueMonth;
    }

    public void setBookDueMonth(int bookDueMonth) {
        this.bookDueMonth = bookDueMonth;
    }

    public int getBookDueDay() {
        return bookDueDay;
    }

    public void setBookDueDay(int bookDueDay) {
        this.bookDueDay = bookDueDay;
    }

    public int getBookDueYear() {
        return bookDueYear;
    }

    public void setBookDueYear(int bookDueYear) {
        this.bookDueYear = bookDueYear;
    }
}
