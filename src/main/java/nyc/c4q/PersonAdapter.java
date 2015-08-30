package nyc.c4q;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PersonAdapter extends ArrayAdapter<Person> {

    Context context;
    private Person[] people;
    private LayoutInflater li;
    View view;

    public PersonAdapter(Context context, Person[] people) {
        super(context, R.layout.listitem_member, people);
        this.context = context;
        this.people = people;
        li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonViewHolder personViewHolder;

        if (convertView == null) {
            convertView = li.inflate(R.layout.listitem_member, parent, false);
            personViewHolder = new PersonViewHolder();
            personViewHolder.text_house = (TextView) convertView.findViewById(R.id.text_house);
            personViewHolder.text_name = (TextView) convertView.findViewById(R.id.text_name);

            convertView.setTag(personViewHolder);
            convertView.setTag(R.id.text_house, personViewHolder.text_house);
            convertView.setTag(R.id.text_name, personViewHolder.text_name);
        } else {
            personViewHolder = (PersonViewHolder) convertView.getTag();
        }

        Person person = people[position];

        if (person.house == House.Gryffindor) {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.gryffindor_red));
        } else if (person.house == House.Ravenclaw) {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.ravenclaw_blue));
        } else if (person.house == House.Hufflepuff) {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.hufflepuff_yellow));
        } else if (person.house == House.Slytherin) {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.slytherin_green));
        }

        personViewHolder.text_house.setText(person.house.toString());
        personViewHolder.text_name.setText(person.lastName + ", " + person.firstName);

        return convertView;
    }

    static class PersonViewHolder {
        TextView text_house;
        TextView text_name;
    }
}
