package nyc.c4q;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jaellysbales on 8/30/15.
 */
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
        tvHouse.setText(person.getHouse().toString());

        return convertView;
    }
}

