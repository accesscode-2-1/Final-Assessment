package nyc.c4q;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by c4q-marbella on 8/30/15.
 */
public class PersonsAdapter extends ArrayAdapter <Person> {

    public PersonsAdapter(Context context, Person[] persons) {
        super(context, 0, persons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       Person person = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_member, parent,false);
        }

        TextView tvName= (TextView) convertView.findViewById(R.id.text_name);
        TextView tvHouse = (TextView) convertView.findViewById(R.id.text_house);

        tvName.setText(person.firstName);
        tvHouse.setText(person.house.name());
       //Todo: set house color
       // convertView.setBackgroundColor();

        return convertView;
    }
}
