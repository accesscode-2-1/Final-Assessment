package nyc.c4q;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListActivity extends Activity {

    public ListView list;
    Button namebt;
    Button colorbt;
    ArrayAdapter<List> adapter;

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

       final PersonsAdapter adapter = new PersonsAdapter(this,PEOPLE);
        list = (ListView) findViewById(R.id.list);

            final List memberList = Arrays.asList(PEOPLE);

        list.setAdapter(adapter);

        namebt = (Button) findViewById(R.id.button_name);
        colorbt = (Button) findViewById(R.id.button_color);



        namebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   list.setAdapter(adapter);
                if(namebt.isPressed()) {
                    Collections.sort(memberList);
                    adapter.notifyDataSetChanged();
                }
//                else{
//                    Collections.reverse(memberList);
//                    adapter.notifyDataSetChanged();
//                }
            }
        });




        colorbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Integer> housecolors = new HashMap<String, Integer>();
                housecolors.put("Gryffindor", R.color.gryffindor_red);
                housecolors.put("Ravenclaw", R.color.ravenclaw_blue);
                housecolors.put("Hufflepuff", R.color.hufflepuff_yellow);
                housecolors.put("Slytherin", R.color.slytherin_green);


                for(int i=0;i<list.getChildCount();i++) {
                    View item = list.getChildAt(i);
                    //TODO: fix null pointer
                    item.setBackgroundColor(housecolors.get(housecolors));
                }
            }


        });


    }


}
