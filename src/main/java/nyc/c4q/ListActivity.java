package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListActivity extends Activity implements View.OnClickListener {

    public ListView list;

    public Button btnName;
    public Button btnColor;

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

        initViews();

        ArrayAdapter<Person> peopleAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PEOPLE);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(peopleAdapter);
    }

    private void initViews() {
        btnName = (Button) findViewById(R.id.button_name);
        btnColor = (Button) findViewById(R.id.button_color);
    }

    @Override
    public void onClick(View v) {

    }

    public class ListAdapter extends ArrayAdapter<Person> {
        public ListAdapter(Context context, ArrayList<Person> people) {
            super(context, 0, people);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get data for current position
            Person person = getItem(position);

            // Is existing view being used? If not, inflate a view.
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_member, parent, false);
            }

            // Lookup view for person
            TextView tvName = (TextView) convertView.findViewById(R.id.text_name);
            TextView tvHouse = (TextView) convertView.findViewById(R.id.text_house);

            // Populate data into view using data object
            tvName.setText(person.getFirstName() + " " + person.getLastName());
            tvHouse.setText(person.getHouse().name());

            // Set row background color

            if (person.getHouse().toString().equalsIgnoreCase("gryffindor")) {
                convertView.setBackgroundColor(getResources().getColor(R.color.gryffindor_red));
            } else if (person.getHouse().toString().equalsIgnoreCase("ravenclaw")) {
                convertView.setBackgroundColor(getResources().getColor(R.color.ravenclaw_blue));
            } else if (person.getHouse().toString().equalsIgnoreCase("hufflepuff")) {
                convertView.setBackgroundColor(getResources().getColor(R.color.hufflepuff_yellow));
            } else if (person.getHouse().toString().equalsIgnoreCase("slytherin")) {
                convertView.setBackgroundColor(getResources().getColor(R.color.slytherin_green));
            } else {
                convertView.setBackgroundColor(Color.parseColor("#000000"));
            }

            return convertView;
        }
    }
}
