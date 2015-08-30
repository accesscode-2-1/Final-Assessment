package nyc.c4q;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ListActivity extends Activity {

    public ListView list;
    private Button buttonName,buttonColor;
    private TextView textName,textHouse;

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
        buttonColor = (Button) findViewById(R.id.button_color);
        buttonName = (Button) findViewById(R.id.button_name);
        textHouse = (TextView) findViewById(R.id.text_house);
        textName = (TextView) findViewById(R.id.text_name);

        final ArrayList<Person> peopleList = new ArrayList<>();

        for(int i = 0;i<PEOPLE.length;i++){
            peopleList.add(PEOPLE[i]);
        }

        final CustomListAdapter adapter = new CustomListAdapter(this, R.layout.listitem_member, peopleList);

        list.setAdapter(adapter);

        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> peopleNamesList = new ArrayList<>();

                for(Person person: peopleList){
                    peopleNamesList.add(person.getFirstName());
                }
                Collections.sort(peopleNamesList, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.compareToIgnoreCase(s2);
                    }
                });
            }
        });

        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    for (Person people : peopleList) {
                        for (int i = 0; i < list.getCount(); i++) {
                        if (people.getHouse().toString().equalsIgnoreCase("Gryffindor")) {
                            adapter.getView(i, null, list).setBackgroundColor(R.color.gryffindor_red);
                        } else if (people.getHouse().toString().equalsIgnoreCase("Ravenclaw")) {
                            adapter.getView(i, null, list).setBackgroundColor(R.color.ravenclaw_blue);
                        } else if (people.getHouse().toString().equalsIgnoreCase("Hufflepuff")) {
                            adapter.getView(i, null, list).setBackgroundColor(R.color.hufflepuff_yellow);
                        } else if (people.getHouse().toString().equalsIgnoreCase("Slytherin")) {
                            adapter.getView(i, null, list).setBackgroundColor(R.color.slytherin_green);
                        }
                        }
                    }
                }
            });




        }
    }


