package nyc.c4q;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hoshiko on 8/30/15.
 */

@DatabaseTable(tableName = "books")
public class Book {
    @DatabaseField
    private Integer id;

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
    private Integer publishyear;

    @DatabaseField
    private Boolean checkedout;

    @DatabaseField
    private Integer checkedoutby;

    @DatabaseField
    private Integer checkoutdateyear;

    @DatabaseField
    private Integer checkoutdatemonth;

    @DatabaseField
    private Integer checkoutdateday;

    @DatabaseField
    private Integer duedateyear;

    @DatabaseField
    private Integer duedatemonth;

    @DatabaseField
    private Integer duedateday;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Book(Integer id, String title, String author, String isbn, String isbn13, String publisher, Integer publishyear, Boolean checkedout, Integer checkedoutby, Integer checkoutdateyear, Integer checkoutdatemonth, Integer checkoutdateday, Integer duedateyear, Integer duedatemonth, Integer duedateday) {
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

    public Book(Integer id, String title, String author, String isbn, String isbn13, String publisher, Integer publishyear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.publisher = publisher;
        this.publishyear = publishyear;

    }

    Book (){}
    /**
     *
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     *     The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     *     The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     *     The isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     *     The isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @return
     *     The isbn13
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     *
     * @param isbn13
     *     The isbn13
     */
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     *
     * @return
     *     The publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     *
     * @param publisher
     *     The publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     *
     * @return
     *     The publishyear
     */
    public Integer getPublishyear() {
        return publishyear;
    }

    /**
     *
     * @param publishyear
     *     The publishyear
     */
    public void setPublishyear(Integer publishyear) {
        this.publishyear = publishyear;
    }

    /**
     *
     * @return
     *     The checkedout
     */
    public Boolean getCheckedout() {
        return checkedout;
    }

    /**
     *
     * @param checkedout
     *     The checkedout
     */
    public void setCheckedout(Boolean checkedout) {
        this.checkedout = checkedout;
    }

    /**
     *
     * @return
     *     The checkedoutby
     */
    public Integer getCheckedoutby() {
        return checkedoutby;
    }

    /**
     *
     * @param checkedoutby
     *     The checkedoutby
     */
    public void setCheckedoutby(Integer checkedoutby) {
        this.checkedoutby = checkedoutby;
    }

    /**
     *
     * @return
     *     The checkoutdateyear
     */
    public Integer getCheckoutdateyear() {
        return checkoutdateyear;
    }

    /**
     *
     * @param checkoutdateyear
     *     The checkoutdateyear
     */
    public void setCheckoutdateyear(Integer checkoutdateyear) {
        this.checkoutdateyear = checkoutdateyear;
    }

    /**
     *
     * @return
     *     The checkoutdatemonth
     */
    public Integer getCheckoutdatemonth() {
        return checkoutdatemonth;
    }

    /**
     *
     * @param checkoutdatemonth
     *     The checkoutdatemonth
     */
    public void setCheckoutdatemonth(Integer checkoutdatemonth) {
        this.checkoutdatemonth = checkoutdatemonth;
    }

    /**
     *
     * @return
     *     The checkoutdateday
     */
    public Integer getCheckoutdateday() {
        return checkoutdateday;
    }

    /**
     *
     * @param checkoutdateday
     *     The checkoutdateday
     */
    public void setCheckoutdateday(Integer checkoutdateday) {
        this.checkoutdateday = checkoutdateday;
    }

    /**
     *
     * @return
     *     The duedateyear
     */
    public Integer getDuedateyear() {
        return duedateyear;
    }

    /**
     *
     * @param duedateyear
     *     The duedateyear
     */
    public void setDuedateyear(Integer duedateyear) {
        this.duedateyear = duedateyear;
    }

    /**
     *
     * @return
     *     The duedatemonth
     */
    public Integer getDuedatemonth() {
        return duedatemonth;
    }

    /**
     *
     * @param duedatemonth
     *     The duedatemonth
     */
    public void setDuedatemonth(Integer duedatemonth) {
        this.duedatemonth = duedatemonth;
    }

    /**
     *
     * @return
     *     The duedateday
     */
    public Integer getDuedateday() {
        return duedateday;
    }

    /**
     *
     * @param duedateday
     *     The duedateday
     */
    public void setDuedateday(Integer duedateday) {
        this.duedateday = duedateday;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
