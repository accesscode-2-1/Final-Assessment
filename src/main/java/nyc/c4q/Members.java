package nyc.c4q;

/**
 * Created by c4q-vanice on 8/30/15.
 */
public class Members {

    protected String id;
    protected String name;
    protected String dob_month;
    protected String dob_day;
    protected String dob_year;
    protected String city;
    protected String state;
    protected String location;

    public Members(){

    }

    public Members(String id, String name, String dob_month, String dob_day, String dob_year, String location) {
        this.id = id;
        this.name = name;
        this.dob_month = dob_month;
        this.dob_day = dob_day;
        this.dob_year = dob_year;
        this.location = location;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob_month() {
        return dob_month;
    }

    public void setDob_month(String dob_month) {
        this.dob_month = dob_month;
    }

    public String getDob_day() {
        return dob_day;
    }

    public void setDob_day(String dob_day) {
        this.dob_day = dob_day;
    }

    public String getDob_year() {
        return dob_year;
    }

    public void setDob_year(String dob_year) {
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

    public String getLocation(){
        return location;
    }

    public void location(String city, String state ){
        this.state = state;
        this.city = city;
    }
}
