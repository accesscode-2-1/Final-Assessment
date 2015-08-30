package nyc.c4q;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.Comparator;


public class ListActivity extends Activity {

    public ListView list;
    Button button_name, button_color;

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

        list = (ListView) findViewById(R.id.list);
        button_name = (Button) findViewById(R.id.button_name);
        button_color = (Button) findViewById(R.id.button_color);

        final PersonAdapter adapter = new PersonAdapter(this, PEOPLE);
        list.setAdapter(adapter);

        button_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counter = 0;
                if (counter % 2 == 0) {
                    adapter.sort(new Comparator<Person>() {
                        @Override
                        public int compare(Person person, Person person2) {
                            return person.lastName.compareTo(person2.lastName);
                        }
                    });
                    counter++;
                } else {
                    adapter.sort(new Comparator<Person>() {
                        @Override
                        public int compare(Person person, Person person2) {
                            return person.firstName.compareTo(person2.firstName);
                        }
                    });
                    counter++;
                }
                adapter.notifyDataSetChanged();
            }
        });

        button_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}
