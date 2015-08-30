package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by c4q-rosmary on 8/30/15.
 */
public class ListActivityAdapter extends ArrayAdapter<Person> {

    Context context;
    int layoutResourceId;
    //ArrayList<Person> data;
    Person [] data;


    public ListActivityAdapter(Context context, int layoutResourceId, Person [] data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PersonHolder holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new PersonHolder();
            holder.mHouse = (TextView) row.findViewById(R.id.text_house);
            holder.mName = (TextView) row.findViewById(R.id.text_name);

            row.setTag(holder);
        } else {
            holder = (PersonHolder) row.getTag();
        }

        Person currentPerson = data[position];
        holder.mHouse.setText(currentPerson.house.toString());
        holder.mName.setText(currentPerson.firstName + " " + currentPerson.lastName);

        return row;
    }

    public static class PersonHolder {
        TextView mHouse;
        TextView mName;
    }
}
