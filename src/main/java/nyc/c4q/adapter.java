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
 * Created by c4q-vanice on 8/30/15.
 */
public class adapter extends ArrayAdapter<Person>{
    public adapter(Context context, int persons) {
        super(context, persons);
    }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                Person person = getItem(position);

                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_member, parent, false);}

                TextView textName = (TextView) convertView.findViewById(R.id.text_name);
                TextView textHouse = (TextView) convertView.findViewById(R.id.text_house);

                textName.setText(person.firstName);
                textName.setText(person.lastName);
           //     textHouse.setText(person.house);

                return convertView;
            }
    }


