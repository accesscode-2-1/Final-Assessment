package nyc.c4q;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created on 8/30/15.
 */
class CustomAdapter extends ArrayAdapter<Person> {

    CustomAdapter(Context context, Person[] PEOPLE) {
        super(context, R.layout.listitem_member, PEOPLE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater personInflater = LayoutInflater.from(getContext());
        View customView = personInflater.inflate(R.layout.listitem_member, parent, false);

        Person name = getItem(position);
        TextView personName = (TextView) customView.findViewById(R.id.text_name);
        Person house = getItem(position);
        TextView personHouse = (TextView)customView.findViewById(R.id.text_house);

        personName.setText((CharSequence) name);
        personHouse.setText((CharSequence) house);
        return convertView;
    }
}
