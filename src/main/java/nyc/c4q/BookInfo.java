package nyc.c4q;

/**
 * Created by c4q-marbella on 8/30/15.
 */
public class BookInfo {

    public int id;
    public String title;
    public String author;
    public long isbn;
    public long isbn13;
    public String publisher;
    public int publishyear;

    public BookInfo(String author, int id, long isbn, long isbn13, int publishyear, String publisher, String title) {
        this.author = author;
        this.id = id;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.publishyear = publishyear;
        this.publisher = publisher;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(long isbn13) {
        this.isbn13 = isbn13;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getPublishyear() {
        return publishyear;
    }

    public void setPublishyear(int publishyear) {
        this.publishyear = publishyear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "author='" + author + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", isbn=" + isbn +
                ", isbn13=" + isbn13 +
                ", publisher='" + publisher + '\'' +
                ", publishyear=" + publishyear +
                '}';
    }
}
