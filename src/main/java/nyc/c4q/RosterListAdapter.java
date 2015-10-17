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

    static class ViewHolder {
        TextView personNameTV, houseTV;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder v;
        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_member, viewGroup, false);
            v = new ViewHolder();
            v.houseTV = (TextView) view.findViewById(R.id.text_house);
            v.personNameTV = (TextView) view.findViewById(R.id.text_name);
            view.setTag(v);
        }else{
            v = (ViewHolder) view.getTag();
        }

        Person person = roster.get(i);

        if(displayLastNameFirst)
            v.personNameTV.setText(person.lastName + ", " + person.firstName);
        else
            v.personNameTV.setText(person.firstName + " " + person.lastName);
        v.houseTV.setText(person.house + "");


        if(doDisplayColor)
            view.setBackgroundResource(HOUSE_COLORS.get(person.house + ""));
        else
            view.setBackgroundResource(0);

        return view;
    }

    public void setDisplayLastNameFirst(boolean lastNameFirst){
        displayLastNameFirst = lastNameFirst;

        notifyDataSetChanged();
    }

    public void setDisplayColor(boolean showColor){
        doDisplayColor = showColor;

        notifyDataSetChanged();
    }

}
