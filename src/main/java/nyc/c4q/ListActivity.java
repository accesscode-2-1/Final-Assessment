package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class ListActivity extends Activity {

    public ListView list;
    int numOfButtonToggles;
    int numofColorToggles;
    Button nameChange;
    Button colorChange;
    ArrayList<Person> peopleList;

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
        nameChange=(Button) findViewById(R.id.button_name);
        colorChange=(Button) findViewById(R.id.button_color);
        peopleList= new ArrayList<>(Arrays.asList(PEOPLE));

        SharedPreferences sharedPreferences=getSharedPreferences("Info", Context.MODE_PRIVATE);

        numOfButtonToggles=sharedPreferences.getInt("numForName",0);
        numofColorToggles=sharedPreferences.getInt("numForColor",0);
        TestListAdapter testListAdapter = new TestListAdapter(this, peopleList, numOfButtonToggles, numofColorToggles);


        list.setAdapter(testListAdapter);



        nameChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfButtonToggles++;
                TestListAdapter testListAdapter = new TestListAdapter(ListActivity.this, peopleList, numOfButtonToggles, numofColorToggles);
                list.setAdapter(testListAdapter);
            }
        });

        colorChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numofColorToggles++;
                TestListAdapter testListAdapter = new TestListAdapter(ListActivity.this, peopleList, numOfButtonToggles, numofColorToggles);
                list.setAdapter(testListAdapter);
            }
        });

    }
}
