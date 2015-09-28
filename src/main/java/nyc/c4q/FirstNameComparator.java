package nyc.c4q;

import java.util.Comparator;

/**
 * Created by alvin2 on 9/26/15.
 */
public class FirstNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person person, Person person2) {
        if (person.firstName.equals(person2.firstName)) {
            return person.lastName.compareTo(person2.lastName);
        }

        return person.firstName.compareTo(person2.firstName);
    }
}
