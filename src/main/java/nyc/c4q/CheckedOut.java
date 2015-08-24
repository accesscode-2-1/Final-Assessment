package nyc.c4q;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class CheckedOut {

    @DatabaseField
    private int memberId;
    @DatabaseField
    private int bookId;
    @DatabaseField
    private Date checkoutDate;
    @DatabaseField
    private Date dueDate;


    public CheckedOut() {
    }

    public CheckedOut(int memberId, int bookId, Date checkoutDate, Date dueDate) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
