package nyc.c4q;

public class Person {
    public String firstName;
    public String lastName;
    public House house;

    public Person(String firstName, String lastName, House house) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.house     = house;
    }
}
