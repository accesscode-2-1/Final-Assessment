package nyc.c4q;

import java.util.Date;

/**
 * Created by Luke on 8/24/2015.
 */
public class HistoryInfo {

    private String name;
    private String title;
    private String author;
    private Date checkoutDate;
    private Date returnDate;

    public HistoryInfo() {
    }

    public HistoryInfo(String name, String title, String author, Date checkoutDate, Date returnDate) {
        this.name = name;
        this.title = title;
        this.author = author;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
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

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }


}
