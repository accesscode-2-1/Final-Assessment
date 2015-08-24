package nyc.c4q;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by Luke on 8/24/2015.
 */
@DatabaseTable
public class History {

    @DatabaseField
    private int memberId;
    @DatabaseField
    private int bookId;
    @DatabaseField
    private Date checkoutDate;
    @DatabaseField
    private Date returnDate;
    @DatabaseField
    private boolean wasLate;

    public History() {
    }

    public History(int memberId, int bookId, Date checkoutDate, Date returnDate, boolean wasLate) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
        this.wasLate = wasLate;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isWasLate() {
        return wasLate;
    }

    public void setWasLate(boolean wasLate) {
        this.wasLate = wasLate;
    }


}
