package nyc.c4q;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ListActivity extends Activity {

    public ListView list;
    private ArrayList<Person> people;
    private Button lastFirstButton, showColorButton;
    private BooleanObj doShowColor, displayLastFirst;
    private static final String S_PREF = "s pref";
    private static final String SHOW_COLOR = "show color";
    private static final String DISPLAY_LAST_FIRST = "last name first";
    private RosterListAdapter rosterListAdapter;

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
        SharedPreferences sharedPreferences = getSharedPreferences(S_PREF,MODE_PRIVATE);
        doShowColor = new BooleanObj(sharedPreferences.getBoolean(SHOW_COLOR, true));
        displayLastFirst = new BooleanObj(sharedPreferences.getBoolean(DISPLAY_LAST_FIRST, true));

        list = (ListView) findViewById(R.id.list);
        lastFirstButton = (Button) findViewById(R.id.button_name);
        showColorButton = (Button) findViewById(R.id.button_color);
        people = new ArrayList<>();

        for(int i = 0; i < PEOPLE.length; i++){
            people.add(PEOPLE[i]);
        }
        rosterListAdapter = new RosterListAdapter(people, doShowColor, displayLastFirst);
        list.setAdapter(rosterListAdapter);
        sortData();

        if(!displayLastFirst.getBooleanValue()){
            lastFirstButton.setText("First Last");
        }
        lastFirstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastFirstButton.getText().toString().equals("Last, First")) {
                    lastFirstButton.setText("First Last");
                    setDisplayLastFirst(false);
                    sortData();
                } else {
                    lastFirstButton.setText("Last, First");
                    setDisplayLastFirst(true);
                    sortData();
                }
            }
        });

        if(!doShowColor.getBooleanValue()){
            showColorButton.setText("Hide Color");
        }
        showColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showColorButton.getText().toString().equals("Show Color")) {
                    showColorButton.setText("Hide Color");
                    setShowColor(false);
                    rosterListAdapter.notifyDataSetChanged();
                } else {
                    showColorButton.setText("Show Color");
                    setShowColor(true);
                    rosterListAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void setShowColor(boolean bool){
        doShowColor.setBooleanValue(bool);
        SharedPreferences sharedPreferences = getSharedPreferences(S_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SHOW_COLOR, bool);
        editor.commit();
    }

    private void setDisplayLastFirst(boolean bool){
        displayLastFirst.setBooleanValue(bool);
        SharedPreferences sharedPreferences = getSharedPreferences(S_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(DISPLAY_LAST_FIRST, bool);
        editor.commit();
    }

    private void sortData() {
        if(displayLastFirst.getBooleanValue())
            sortByLastName();
        else
            sortByFirstName();


        rosterListAdapter.notifyDataSetChanged();
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
