package nyc.c4q;

public class Person implements Comparable<Person>{
    public String firstName;
    public String lastName;
    public House house;

    public Person(String firstName, String lastName, House house) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.house     = house;
    }


    @Override
    public int compareTo(Person person) {
        return firstName.compareTo(person.firstName);
    }

    public int compareToFirstName(Person person) {
        return lastName.compareTo(person.lastName);
    }
}
