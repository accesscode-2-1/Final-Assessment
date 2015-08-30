package nyc.c4q;

public class Book {

    private int id;
    private String title;
    private String author;
    private String isbn;
    private String isbn13;
    private String publisher;
    private int publishyear;
    private boolean checkedout;
    private int checkedoutby;
    private int checkoutdateyear;
    private int checkoutdatemonth;
    private int checkoutdateday;
    private int duedateyear;
    private int duedatemonth;
    private int duedateday;

    public Book(int id, String title, String author, String isbn, String isbn13, String publisher, int publishyear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.publisher = publisher;
        this.publishyear = publishyear;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" + "title: " + this.title + "\n" + "author: " + this.author + "\n" + "isbn: " + this.isbn + "\n" + "isbn13: " + this.isbn13 + "\n" + "publisher: " + this.publisher + "\n" + "publication year: " + this.publishyear + "\n";
    }

    public Book(int id, String title, String author, String isbn, String isbn13, String publisher, int publishyear, boolean checkedout, int checkedoutby, int checkoutdateyear, int checkoutdatemonth, int checkoutdateday, int duedateyear, int duedatemonth, int duedateday) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.publisher = publisher;
        this.publishyear = publishyear;
        this.checkedout = checkedout;
        this.checkedoutby = checkedoutby;
        this.checkoutdateyear = checkoutdateyear;
        this.checkoutdatemonth = checkoutdatemonth;
        this.checkoutdateday = checkoutdateday;
        this.duedateyear = duedateyear;
        this.duedatemonth = duedatemonth;
        this.duedateday = duedateday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishyear() {
        return publishyear;
    }

    public void setPublishyear(int publishyear) {
        this.publishyear = publishyear;
    }

    public boolean getCheckedout() {
        return checkedout;
    }

    public void setCheckedout(boolean checkedout) {
        this.checkedout = checkedout;
    }

    public int getCheckedoutby() {
        return checkedoutby;
    }

    public void setCheckedoutby(int checkedoutby) {
        this.checkedoutby = checkedoutby;
    }

    public int getCheckoutdateyear() {
        return checkoutdateyear;
    }

    public void setCheckoutdateyear(int checkoutdateyear) {
        this.checkoutdateyear = checkoutdateyear;
    }

    public int getCheckoutdatemonth() {
        return checkoutdatemonth;
    }

    public void setCheckoutdatemonth(int checkoutdatemonth) {
        this.checkoutdatemonth = checkoutdatemonth;
    }

    public int getCheckoutdateday() {
        return checkoutdateday;
    }

    public void setCheckoutdateday(int checkoutdateday) {
        this.checkoutdateday = checkoutdateday;
    }

    public int getDuedateyear() {
        return duedateyear;
    }

    public void setDuedateyear(int duedateyear) {
        this.duedateyear = duedateyear;
    }

    public int getDuedatemonth() {
        return duedatemonth;
    }

    public void setDuedatemonth(int duedatemonth) {
        this.duedatemonth = duedatemonth;
    }

    public int getDuedateday() {
        return duedateday;
    }

    public void setDuedateday(int duedateday) {
        this.duedateday = duedateday;
    }
}
