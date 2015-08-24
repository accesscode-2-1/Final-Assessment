package nyc.c4q;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Book {

    @DatabaseField
    private int id;
    @DatabaseField
    private String title;
    @DatabaseField
    private String author;
    @DatabaseField
    private String isbn;
    @DatabaseField
    private String isbn13;
    @DatabaseField
    private String publisher;
    @DatabaseField
    private int publishyear;

    public Book() {
    }

    public Book(int id, String title, String author, String isbn, String isbn13, String publisher, int publishyear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.publisher = publisher;
        this.publishyear = publishyear;
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
}
