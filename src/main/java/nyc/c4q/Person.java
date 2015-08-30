package nyc.c4q;

public class Person implements Comparable<Person> {
    public String firstName;
    public String lastName;
    public House house;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, House house) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.house     = house;
    }

    @Override
    public int compareTo(Person another) {
        int comparedFirstName = this.firstName.compareToIgnoreCase(another.getFirstName());
        if(comparedFirstName == 0){
            return this.lastName.compareTo(another.getLastName());
        }
        return comparedFirstName;
    }
}
