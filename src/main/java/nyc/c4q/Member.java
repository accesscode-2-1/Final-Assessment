package nyc.c4q;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by c4q-ac35 on 8/30/15.
 */
public class Member {
    @Expose
    private Integer id;
    @Expose
    private String name;
    @SerializedName("dob_month")
    @Expose
    private Integer dobMonth;
    @SerializedName("dob_day")
    @Expose
    private Integer dobDay;
    @SerializedName("dob_year")
    @Expose
    private Integer dobYear;
    @Expose
    private String city;
    @Expose
    private String state;

    Member(){

    }
    Member(Integer id,String name,Integer dobMonth,Integer dobDay,Integer dobYear,String city, String state){
        this.id = id;
        this.name = name;
        this.dobMonth = dobMonth;
        this.dobDay = dobDay;
        this.dobYear = dobYear;
        this.city = city;
        this.state = state;
    }

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
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The dobMonth
     */
    public Integer getDobMonth() {
        return dobMonth;
    }

    /**
     *
     * @param dobMonth
     * The dob_month
     */
    public void setDobMonth(Integer dobMonth) {
        this.dobMonth = dobMonth;
    }

    /**
     *
     * @return
     * The dobDay
     */
    public Integer getDobDay() {
        return dobDay;
    }

    /**
     *
     * @param dobDay
     * The dob_day
     */
    public void setDobDay(Integer dobDay) {
        this.dobDay = dobDay;
    }

    /**
     *
     * @return
     * The dobYear
     */
    public Integer getDobYear() {
        return dobYear;
    }

    /**
     *
     * @param dobYear
     * The dob_year
     */
    public void setDobYear(Integer dobYear) {
        this.dobYear = dobYear;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     * The state
     */
    public void setState(String state) {
        this.state = state;
    }

}
