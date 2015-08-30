package nyc.c4q;

/**
 * Created by c4q-marbella on 8/30/15.
 */
public class MemberInfo {
    public int id;
    public String name;
    public int dob_day;
    public int dob_year;
    public String city;
    public String state;

    public MemberInfo(String city, int dob_day, int dob_year, int id, String name, String state) {
        this.city = city;
        this.dob_day = dob_day;
        this.dob_year = dob_year;
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "city='" + city + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", dob_day=" + dob_day +
                ", dob_year=" + dob_year +
                ", state='" + state + '\'' +
                '}';
    }
}
