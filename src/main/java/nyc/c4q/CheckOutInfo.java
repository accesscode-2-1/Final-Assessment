package nyc.c4q;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

public class CheckOutInfo {

    private String name;
    private String title;
    private String author;
    private Date checkout;
    private Date duedate;

    public CheckOutInfo() {
    }

    public CheckOutInfo(String name, String title, String author, Date checkout, Date duedate) {
        this.name = name;
        this.title = title;
        this.author = author;
        this.checkout = checkout;
        this.duedate = duedate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }
}
