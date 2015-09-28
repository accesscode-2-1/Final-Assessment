package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class ListActivity extends Activity {

    public final String SHARED_FILE = "shared_file";
    public ListView list;
    ListAdapter listAdapter;
    Button buttonName, buttonColor;
    boolean isColorShown;
    SharedPreferences preferences;

    public static final Person[] PEOPLE = {
            new Person("Hannah", "Abbott", House.Hufflepuff),
            new Person("Katie", "Bell", House.Gryffindor),
            new Person("Susan", "Bones", House.Hufflepuff),
            new Person("Terry", "Boot", House.Ravenclaw),
            new Person("Lavender", "Brown", House.Gryffindor),
            new Person("Cho", "Chang", House.Ravenclaw),
            new Person("Michael", "Corner", House.Ravenclaw),
            new Person("Colin", "Creevey", House.Gryffindor),
            new Person("Marietta", "Edgecombe", House.Ravenclaw),
            new Person("Justin", "Finch-Fletchley", House.Hufflepuff),
            new Person("Seamus", "Finnigan", House.Gryffindor),
            new Person("Anthony", "Goldstein", House.Ravenclaw),
            new Person("Hermione", "Granger", House.Gryffindor),
            new Person("Angelina", "Johnson", House.Gryffindor),
            new Person("Lee", "Jordan", House.Gryffindor),
            new Person("Neville", "Longbottom", House.Gryffindor),
            new Person("Luna", "Lovegood", House.Ravenclaw),
            new Person("Ernie", "Macmillan", House.Hufflepuff),
            new Person("Parvati", "Patil", House.Gryffindor),
            new Person("Padma", "Patil", House.Ravenclaw),
            new Person("Harry", "Potter", House.Gryffindor),
            new Person("Zacharias", "Smith", House.Hufflepuff),
            new Person("Alicia", "Spinnet", House.Gryffindor),
            new Person("Dean", "Thomas", House.Gryffindor),
            new Person("Fred", "Weasley", House.Gryffindor),
            new Person("George", "Weasley", House.Gryffindor),
            new Person("Ginny", "Weasley", House.Gryffindor),
            new Person("Ron", "Weasley", House.Gryffindor)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

            preferences = this.getSharedPreferences(SHARED_FILE, Context.MODE_PRIVATE);
            isColorShown = preferences.getBoolean("color", false);

        list = (ListView) findViewById(R.id.list);
        listAdapter = new ListAdapter(getApplicationContext(), R.layout.listitem_member, PEOPLE, isColorShown);
        list.setAdapter(listAdapter);


        buttonName = (Button) findViewById(R.id.button_name);
        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonName.getText().toString().equals("Last, First")) {
                    buttonName.setText("First Last");
                    listAdapter.setFirstnameFirst(true);
                    listAdapter.notifyDataSetChanged();
                    list.setAdapter(listAdapter);
                } else if (buttonName.getText().toString().equals("First Last")) {
                    buttonName.setText("Last, First");
                    listAdapter.setFirstnameFirst(false);
                    listAdapter.notifyDataSetChanged();
                    list.setAdapter(listAdapter);
                }
            }
        });


        buttonColor = (Button) findViewById(R.id.button_color);
        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonColor.getText().toString().equals("Show Color")) {
                    buttonColor.setText("Hide Color");
                    listAdapter.setColorShown(false);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("color", false);
                    // .commit() runs in the foreground so when onDestroy() is called on quitting the app, the info will be safely written to SharedPrefs before the app is destroyed
                    editor.commit();
                    // refreshes the view of the listview
                    listAdapter.notifyDataSetChanged();
                } else if (buttonColor.getText().toString().equals("Hide Color")) {
                    buttonColor.setText("Show Color");
                    listAdapter.setColorShown(true);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("color", true);
                    editor.commit();
                    listAdapter.notifyDataSetChanged();
                }
            }
        });


    }

    public class ListAdapter extends ArrayAdapter<Person> {

        TextView house, name;
        boolean firstNameFirst;
        boolean isColorShown;


        public ListAdapter(Context context, int resource, Person[] objects, boolean isColorShown) {
            super(context, resource, objects);
            this.isColorShown = isColorShown;

        }

        public void setColorShown(boolean isColorShown) {
            this.isColorShown = isColorShown;
        }


        public void setFirstnameFirst(boolean enabled) {
            firstNameFirst = enabled;

            if (enabled) {
                Arrays.sort(PEOPLE, new FirstNameComparator());
            } else {
                Arrays.sort(PEOPLE, new LastNameComparator());
            }
        }

        @Override
        public View getView(int position, View v, ViewGroup parent) {

            Person person = getItem(position);

            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(R.layout.listitem_member, null);
            }

            house = (TextView) v.findViewById(R.id.text_house);
            name = (TextView) v.findViewById(R.id.text_name);

            house.setText(person.getHouse().toString());


            if (buttonName.getText().toString().equals("Last, First")) {
                name.setText(person.getLastName() + ", " + person.getFirstName());
            } else if (buttonName.getText().toString().equals("First Last")) {
                name.setText(person.getFirstName() + " " + person.getLastName());
            }

            if (isColorShown) {
                v.setBackgroundColor(Color.BLACK);
            } else {
                if (house.getText().equals("Gryffindor")) {
                    v.setBackgroundResource(R.color.gryffindor_red);
                } else if (house.getText().equals("Ravenclaw")) {
                    v.setBackgroundResource(R.color.ravenclaw_blue);
                } else if (house.getText().equals("Slytherin")) {
                    v.setBackgroundResource(R.color.slytherin_green);
                } else if (house.getText().equals("Hufflepuff")) {
                    v.setBackgroundResource(R.color.hufflepuff_yellow);
                }
            }


            return v;
        }
    }

}

