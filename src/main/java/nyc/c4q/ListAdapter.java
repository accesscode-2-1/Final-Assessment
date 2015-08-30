package nyc.c4q;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by charlynbuchanan on 8/30/15.
 */
public class ListAdapter extends ArrayAdapter<Person> {

    Context context;
    ArrayList<String> people1;
    int resource;

    public ListAdapter(Context context, int resource, ArrayList<Person> PEOPLE) {
        super(context, resource, PEOPLE);
        this.context = context;
        this.people1 = people1;
        this.resource = resource;
    }

//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View rowView = convertView;
//
//        Person p = PEOPLE.get(position);
//
//        if (rowView == null) {
//            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            rowView = inflater.inflate(R.layout.activity_list, null);
//        }
//    }






}
