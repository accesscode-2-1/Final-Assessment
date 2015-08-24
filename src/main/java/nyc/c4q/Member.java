package nyc.c4q;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Member {

    @DatabaseField
    public int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private int dob_month;

    @DatabaseField
    private int dob_day;

    @DatabaseField
    private int dob_year;

    @DatabaseField
    private String city;

    @DatabaseField
    private String state;

    private boolean isRed;

    public Member() {
    }

    public Member(int id, String name, int dob_month, int dob_day, int dob_year, String city, String state) {
        this.id = id;
        this.name = name;
        this.dob_month = dob_month;
        this.dob_day = dob_day;
        this.dob_year = dob_year;
        this.city = city;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDob_month() {
        return dob_month;
    }

    public void setDob_month(int dob_month) {
        this.dob_month = dob_month;
    }

    public int getDob_day() {
        return dob_day;
    }

    public void setDob_day(int dob_day) {
        this.dob_day = dob_day;
    }

    public int getDob_year() {
        return dob_year;
    }

    public void setDob_year(int dob_year) {
        this.dob_year = dob_year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setIsRed(boolean isRed) {
        this.isRed = isRed;
    }
}
