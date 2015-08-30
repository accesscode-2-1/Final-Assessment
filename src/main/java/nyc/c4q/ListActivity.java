package nyc.c4q;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListActivity extends Activity {

    public ListView list;
    private ArrayList<Person> people;
    private Button lastFirstButton, showColorButton;
    private boolean doShowColor, displayLastFirst;

    public static final Person[] PEOPLE = {
        new Person("Hannah",    "Abbott",          House.Hufflepuff),
        new Person("Katie",     "Bell",            House.Gryffindor),
        new Person("Susan",     "Bones",           House.Hufflepuff),
        new Person("Terry",     "Boot",            House.Ravenclaw),
        new Person("Lavender",  "Brown",           House.Gryffindor),
        new Person("Cho",       "Chang",           House.Ravenclaw),
        new Person("Michael",   "Corner",          House.Ravenclaw),
        new Person("Colin",     "Creevey",         House.Gryffindor),
        new Person("Marietta",  "Edgecombe",       House.Ravenclaw),
        new Person("Justin",    "Finch-Fletchley", House.Hufflepuff),
        new Person("Seamus",    "Finnigan",        House.Gryffindor),
        new Person("Anthony",   "Goldstein",       House.Ravenclaw),
        new Person("Hermione",  "Granger",         House.Gryffindor),
        new Person("Angelina",  "Johnson",         House.Gryffindor),
        new Person("Lee",       "Jordan",          House.Gryffindor),
        new Person("Neville",   "Longbottom",      House.Gryffindor),
        new Person("Luna",      "Lovegood",        House.Ravenclaw),
        new Person("Ernie",     "Macmillan",       House.Hufflepuff),
        new Person("Parvati",   "Patil",           House.Gryffindor),
        new Person("Padma",     "Patil",           House.Ravenclaw),
        new Person("Harry",     "Potter",          House.Gryffindor),
        new Person("Zacharias", "Smith",           House.Hufflepuff),
        new Person("Alicia",    "Spinnet",         House.Gryffindor),
        new Person("Dean",      "Thomas",          House.Gryffindor),
        new Person("Fred",      "Weasley",         House.Gryffindor),
        new Person("George",    "Weasley",         House.Gryffindor),
        new Person("Ginny",     "Weasley",         House.Gryffindor),
        new Person("Ron",       "Weasley",         House.Gryffindor)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = (ListView) findViewById(R.id.list);
        lastFirstButton = (Button) findViewById(R.id.button_name);
        showColorButton = (Button) findViewById(R.id.button_color);
        doShowColor = true;
        displayLastFirst = true;
        people = new ArrayList<>();

        for(int i = 0; i < PEOPLE.length; i++){
            people.add(PEOPLE[i]);
        }

        setAdapter();


        lastFirstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastFirstButton.getText().toString().equals("Last, First")) {
                    lastFirstButton.setText("First Last");
                    displayLastFirst = false;
                    setAdapter();
                } else {
                    lastFirstButton.setText("Last, First");
                    displayLastFirst = true;
                    setAdapter();
                }
            }
        });

        showColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showColorButton.getText().toString().equals("Show Color")) {
                    showColorButton.setText("Hide Color");
                    doShowColor = false;
                    setAdapter();
                } else {
                    showColorButton.setText("Show Color");
                    doShowColor = true;
                    setAdapter();
                }
            }
        });
    }

    private void setAdapter() {
        if(displayLastFirst)
            sortByLastName();
        else
            sortByFirstName();

        RosterListAdapter rosterListAdapter = new RosterListAdapter(people, doShowColor, displayLastFirst);
        list.setAdapter(rosterListAdapter);
    }



    private class lastNameComparator implements  Comparator<Person>{

        @Override
        public int compare(Person person, Person t1) {
            int length = person.lastName.length();
            if (t1.lastName.length() <= person.lastName.length()) {
                length = t1.lastName.length();
            }
            for (int i = 0; i < length; i++) {
                int personChar = (int) person.lastName.toLowerCase().charAt(i);
                int t1Char = (int) t1.lastName.toLowerCase().charAt(i);

                if (personChar > t1Char)
                    return 1;
                else if (personChar < t1Char)
                    return -1;
            }
            return 0;
        }
    }

    private class firstNameComparator implements Comparator<Person>{

        @Override
        public int compare(Person person, Person t1) {
            int length = person.firstName.length();
            if (t1.firstName.length() <= person.firstName.length()) {
                length = t1.firstName.length();
            }
            for (int i = 0; i < length; i++) {
                int personChar = (int) person.firstName.toLowerCase().charAt(i);
                int t1Char = (int) t1.firstName.toLowerCase().charAt(i);

                if (personChar > t1Char)
                    return 1;
                else if (personChar < t1Char)
                    return -1;
            }
            return 0;
        }
    }

    private void sortByLastName() {
        Collections.sort(people, new lastNameComparator());
    }

    private void sortByFirstName() {
        Collections.sort(people, new firstNameComparator());
    }


}
