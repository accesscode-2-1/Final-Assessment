package nyc.c4q;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.CheckedOutputStream;


/**
 * Created by c4q-anthonyf on 8/30/15.
 */
public class RosterListAdapter extends BaseAdapter{

    private ArrayList<Person> roster;
    private boolean displayLastNameFirst;
    private boolean doDisplayColor;
    final Map<String, Integer> HOUSE_COLORS;

    public RosterListAdapter(ArrayList<Person> roster, boolean doDisplayColor, boolean displayLastNameFirst){
        this.roster = roster;
        this.doDisplayColor = doDisplayColor;
        this.displayLastNameFirst = displayLastNameFirst;
        HOUSE_COLORS = new TreeMap<>();
        HOUSE_COLORS.put("Gryffindor", R.color.gryffindor_red);
        HOUSE_COLORS.put("Ravenclaw",  R.color.ravenclaw_blue);
        HOUSE_COLORS.put("Hufflepuff", R.color.hufflepuff_yellow);
        HOUSE_COLORS.put("Slytherin",  R.color.slytherin_green);
    }

    @Override
    public int getCount() {
        return roster.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_member, viewGroup, false);
        TextView houseTV = (TextView) itemView.findViewById(R.id.text_house);
        TextView personNameTV = (TextView) itemView.findViewById(R.id.text_name);

        Person person = roster.get(i);

        if(displayLastNameFirst)
            personNameTV.setText(person.lastName + ", " + person.firstName);
        else
            personNameTV.setText(person.firstName + " " + person.lastName);
        houseTV.setText(person.house + "");


        if(doDisplayColor)
            itemView.setBackgroundResource(HOUSE_COLORS.get(person.house + ""));

        return itemView;
    }


}
