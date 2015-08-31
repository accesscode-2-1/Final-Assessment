package nyc.c4q;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by c4q-madelyntavarez on 8/30/15.
 */
public class TestListAdapter extends BaseAdapter {

    ArrayList<Person> persons;
    Context context;
    LayoutInflater layoutInflater;
    int numOfButtonToggles;
    int numOfColorToggles;

    public TestListAdapter(Context context,ArrayList<Person> persons,int numOfButtonToggles, int numOfColorToggles) {
        this.persons = persons;
        this.numOfButtonToggles=numOfButtonToggles;
        this.context = context;
        this.numOfColorToggles=numOfColorToggles;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=layoutInflater.inflate(R.layout.listitem_member,null);

        TextView house=(TextView) view.findViewById(R.id.text_house);
        TextView name=(TextView) view.findViewById(R.id.text_name);

        if(numOfButtonToggles % 2==0){
            name.setText(persons.get(position).lastName + ", " + persons.get(position).firstName);
            house.setText(persons.get(position).house.toString());
            Collections.sort(persons, new Comparator<Person>() {
                public int compare(Person result1, Person result2) {
                    return result1.lastName.compareTo(result2.lastName);
                }
            });

        }
         else{
            name.setText(persons.get(position).firstName + " " + persons.get(position).lastName);
            house.setText(persons.get(position).house.toString());

            Collections.sort(persons, new Comparator<Person>() {
                public int compare(Person result1, Person result2) {
                    return result1.firstName.compareTo(result2.firstName);
                }
            });
        }

            House houseForColor=persons.get(position).house;
            String color=houseForColor.toString();
            if(numOfColorToggles%2==0){
            name.setBackgroundColor(Color.TRANSPARENT);
            }
            else{
            if (color.equals("Gryffindor")) {
                name.setBackgroundColor(context.getResources().getColor(R.color.gryffindor_red));
                Log.d("COLOR", color);
            }
            if (color.equals("Ravenclaw")) {
                name.setBackgroundColor(context.getResources().getColor(R.color.ravenclaw_blue));
                Log.d("COLOR", color);
            }
            if (color.equals("Hufflepuff")) {
                name.setBackgroundColor(context.getResources().getColor(R.color.hufflepuff_yellow));
                Log.d("COLOR", color);
            }
            if (color.equals("Slytherin")) {
                name.setBackgroundColor(context.getResources().getColor(R.color.slytherin_green));
                Log.d("COLOR", color);
            }
        }

        SharedPreferences sharedPreferences=context.getSharedPreferences("Info",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("numForName",numOfButtonToggles);
        editor.putInt("numForColor",numOfColorToggles);
        editor.commit();

        return view;
    }
}
