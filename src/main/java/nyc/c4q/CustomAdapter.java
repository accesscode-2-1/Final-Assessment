package nyc.c4q;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by elvisboves on 8/30/15.
 */
public class CustomAdapter extends BaseAdapter {

    ArrayList<Person> persons = new ArrayList<Person>();
    LayoutInflater mInflater;
    Context context;


    public CustomAdapter(Context context, ArrayList<Person> persons) {
        this.persons = persons;
        this.context = context;
        mInflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listitem_member, parent, false);
        }

        Person personFinal = getItem(position);

        TextView house = (TextView) convertView.findViewById(R.id.text_house);
        TextView name = (TextView) convertView.findViewById(R.id.text_name);

        name.setText(personFinal.firstName);
        house.setText(personFinal.house.toString());


        return convertView;
    }



}
