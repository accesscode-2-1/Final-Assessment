package nyc.c4q;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alvin2 on 8/30/15.
 */
public class Member {

    @SerializedName("id")
    private int memberID;

    @SerializedName("name")
    private String memberName;

    @SerializedName("dob_month")
    private int memberDOBmonth;

    @SerializedName("dob_day")
    private int memberDOBday;

    @SerializedName("dob_year")
    private int memberDOByear;

    @SerializedName("city")
    private String memberCity;

    @SerializedName("state")
    private String memberState;

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getMemberDOBmonth() {
        return memberDOBmonth;
    }

    public void setMemberDOBmonth(int memberDOBmonth) {
        this.memberDOBmonth = memberDOBmonth;
    }

    public int getMemberDOBday() {
        return memberDOBday;
    }

    public void setMemberDOBday(int memberDOBday) {
        this.memberDOBday = memberDOBday;
    }

    public int getMemberDOByear() {
        return memberDOByear;
    }

    public void setMemberDOByear(int memberDOByear) {
        this.memberDOByear = memberDOByear;
    }

    public String getMemberCity() {
        return memberCity;
    }

    public void setMemberCity(String memberCity) {
        this.memberCity = memberCity;
    }

    public String getMemberState() {
        return memberState;
    }

    public void setMemberState(String memberState) {
        this.memberState = memberState;
    }
}
