package nyc.c4q;

/**
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Person> people;


    public CustomListAdapter(Activity activity, List<Person> people) {
        this.activity = activity;
        this.people = people;
    }

    @Override
    public int getCount() {
        return people.size();
    }

    @Override
    public Object getItem(int location) {
        return people.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.listitem_member, null);

        TextView names = (TextView) convertView.findViewById(R.id.text_name);
        TextView houses = (TextView) convertView.findViewById(R.id.text_house);

        // getting movie data for the row
        Person m = people.get(position);

        // Names
        names.setText("Name");

        // Houses
        houses.setText("House");

        return convertView;
    }
}