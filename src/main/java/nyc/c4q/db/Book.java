package nyc.c4q.db;

import com.google.gson.annotations.Expose;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Book {

    private static final String ID = "ID";
    private static final String TITLE = "TITLE";
    private static final String AUTHOR = "AUTHOR";
    private static final String ISBN = "ISBN";
    private static final String ISBN13 = "ISBN13";
    @Expose
    @DatabaseField(columnName = ID)
    public Integer id;
    @Expose
    @DatabaseField(columnName = TITLE)
    public String title;
    @Expose
    @DatabaseField(columnName = AUTHOR)
    public String author;
    @Expose
    @DatabaseField(columnName = ISBN)
    public String isbn;
    @Expose
    @DatabaseField(columnName = ISBN13)
    public String isbn13;
    @Expose
    @DatabaseField
    public String publisher;
    @Expose
    @DatabaseField
    public Integer publishyear;
    @Expose
    @DatabaseField
    public Boolean checkedout;
    @Expose
    @DatabaseField
    public Integer checkedoutby;
    @Expose
    @DatabaseField
    public Integer checkoutdateyear;
    @Expose
    @DatabaseField
    public Integer checkoutdatemonth;
    @Expose
    @DatabaseField
    public Integer checkoutdateday;
    @Expose
    @DatabaseField
    public Integer duedateyear;
    @Expose
    @DatabaseField
    public Integer duedatemonth;
    @Expose
    @DatabaseField
    public Integer duedateday;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     * The isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @return
     * The isbn13
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     *
     * @param isbn13
     * The isbn13
     */
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     *
     * @return
     * The publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     *
     * @param publisher
     * The publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     *
     * @return
     * The publishyear
     */
    public Integer getPublishyear() {
        return publishyear;
    }

    /**
     *
     * @param publishyear
     * The publishyear
     */
    public void setPublishyear(Integer publishyear) {
        this.publishyear = publishyear;
    }

    /**
     *
     * @return
     * The checkedout
     */
    public Boolean getCheckedout() {
        return checkedout;
    }

    /**
     *
     * @param checkedout
     * The checkedout
     */
    public void setCheckedout(Boolean checkedout) {
        this.checkedout = checkedout;
    }

    /**
     *
     * @return
     * The checkedoutby
     */
    public Integer getCheckedoutby() {
        return checkedoutby;
    }

    /**
     *
     * @param checkedoutby
     * The checkedoutby
     */
    public void setCheckedoutby(Integer checkedoutby) {
        this.checkedoutby = checkedoutby;
    }

    /**
     *
     * @return
     * The checkoutdateyear
     */
    public Integer getCheckoutdateyear() {
        return checkoutdateyear;
    }

    /**
     *
     * @param checkoutdateyear
     * The checkoutdateyear
     */
    public void setCheckoutdateyear(Integer checkoutdateyear) {
        this.checkoutdateyear = checkoutdateyear;
    }

    /**
     *
     * @return
     * The checkoutdatemonth
     */
    public Integer getCheckoutdatemonth() {
        return checkoutdatemonth;
    }

    /**
     *
     * @param checkoutdatemonth
     * The checkoutdatemonth
     */
    public void setCheckoutdatemonth(Integer checkoutdatemonth) {
        this.checkoutdatemonth = checkoutdatemonth;
    }

    /**
     *
     * @return
     * The checkoutdateday
     */
    public Integer getCheckoutdateday() {
        return checkoutdateday;
    }

    /**
     *
     * @param checkoutdateday
     * The checkoutdateday
     */
    public void setCheckoutdateday(Integer checkoutdateday) {
        this.checkoutdateday = checkoutdateday;
    }

    /**
     *
     * @return
     * The duedateyear
     */
    public Integer getDuedateyear() {
        return duedateyear;
    }

    /**
     *
     * @param duedateyear
     * The duedateyear
     */
    public void setDuedateyear(Integer duedateyear) {
        this.duedateyear = duedateyear;
    }

    /**
     *
     * @return
     * The duedatemonth
     */
    public Integer getDuedatemonth() {
        return duedatemonth;
    }

    /**
     *
     * @param duedatemonth
     * The duedatemonth
     */
    public void setDuedatemonth(Integer duedatemonth) {
        this.duedatemonth = duedatemonth;
    }

    /**
     *
     * @return
     * The duedateday
     */
    public Integer getDuedateday() {
        return duedateday;
    }

    /**
     *
     * @param duedateday
     * The duedateday
     */
    public void setDuedateday(Integer duedateday) {
        this.duedateday = duedateday;
    }

}