package nyc.c4q;

import java.util.Comparator;

public class Person implements Comparator<Person> {
    public String firstName;
    public String lastName;
    public House house;

    public Person(String firstName, String lastName, House house) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.house     = house;
    }


    @Override
    public int compare(Person person, Person t1) {
        return 0;
    }
}
