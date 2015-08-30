package nyc.c4q;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ListActivity extends Activity {

    public ListView list;

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

    public static final ArrayList<String> people1 = new ArrayList<>();

    int MODE = 1;
    SQLiteDatabase.CursorFactory cursorFactory;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Button buttonName = (Button)findViewById(R.id.button_name);

        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("members", MODE, cursorFactory);

        db.execSQL("DROP TABLE members");

        db.execSQL("CREATE TABLE members (firstName TEXT, lastName TEXT, house TEXT)");

        for (Person person: PEOPLE) {
            db.execSQL("INSERT INTO members VALUES ( '" + person.getFirstName() + "' , '" + person.getLastName()
                    + "' , '" + person.getHouse() + "')");
            people1.add(person.getLastName() +", "+ person.getFirstName() + ":     " + person.getHouse().toString() );

        }
        Collections.sort(people1);

        //get entire db back
        Cursor query = db.rawQuery("SELECT * from members", null);

        if (query.moveToFirst()){
            do {
                String firstName = query.getString(0);
                String lastName = query.getString(1);
                String house = query.getString(2);
            } while (query.moveToNext());
        }
        else {
            Toast.makeText(getBaseContext(), "Error retriveing data", Toast.LENGTH_SHORT).show();
        }

        db.close();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, people1);
        list = (ListView) findViewById(R.id.list);

        list.setAdapter(adapter);
    }

public static Comparator<String> alphatetizer = new Comparator<String>() {
    @Override
    public int compare(String lhs, String rhs) {
        String name1 = lhs;
        String name2 = rhs;

        return name1.compareTo(name2);
    }

    public  Comparator<String> dealphatetizer = new Comparator<String>() {
        @Override
        public int compare(String lhs, String rhs) {
            String name1 = lhs;
            String name2 = rhs;

            return name2.compareTo(name1);
        }
};


    //Now, populate listview with db items.

};}
