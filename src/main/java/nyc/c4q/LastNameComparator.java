package nyc.c4q;

/**
 * Created by alvin2 on 9/26/15.
 */
public class LastNameComparator implements java.util.Comparator<Person> {
    @Override
    public int compare(Person person, Person person2) {
        if (person.lastName.equals(person2.lastName)) {
            return person.firstName.compareTo(person2.firstName);
        }

        return person.lastName.compareTo(person2.lastName);
    }
}

