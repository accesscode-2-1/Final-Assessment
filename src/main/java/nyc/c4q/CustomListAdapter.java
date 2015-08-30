package nyc.c4q;

import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by c4q-ac35 on 8/30/15.
 */
public class CustomListAdapter extends ArrayAdapter {

    private ArrayList<Person> objects;


    public CustomListAdapter(Context context, int resource, ArrayList<Person> objects) {
        super(context, resource, objects);
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.listitem_member,null);
        }

        Person i = objects.get(position);

        if(i != null){
            TextView name = (TextView) v.findViewById(R.id.text_name);
            TextView house = (TextView) v.findViewById(R.id.text_house);

            if(name != null){
                name.setText(i.getFirstName() + "," + i.getLastName());
            }
            if(house != null){
                house.setText(i.getHouse().toString());
            }
        }
        return v;

    }
}
