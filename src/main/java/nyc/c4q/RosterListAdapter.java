package nyc.c4q;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by c4q-anthonyf on 8/30/15.
 */
public class RosterListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Person[] roster;
    private boolean displayLastNameFirst;
    private boolean doDisplayColor;

    public RosterListAdapter(Person[] roster, boolean doDisplayColor, boolean displayLastNameFirst){
        this.roster = roster;
        this.doDisplayColor = doDisplayColor;
        this.displayLastNameFirst = displayLastNameFirst;
    }

    private class RosterViewHolder extends RecyclerView.ViewHolder{

        TextView houseTV, personNameTV;

        public RosterViewHolder(View itemView) {
            super(itemView);
            houseTV = (TextView) itemView.findViewById(R.id.text_house);
            personNameTV = (TextView) itemView.findViewById(R.id.text_name);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_member, viewGroup, false);
        return new RosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Person person = roster[i];
        RosterViewHolder vh = (RosterViewHolder) viewHolder;
        if(displayLastNameFirst)
            vh.personNameTV.setText(person.lastName + ", " + person.firstName);
        else
            vh.personNameTV.setText(person.firstName + " " + person.lastName);
        vh.houseTV.setText(person.house + "");
    }

    @Override
    public int getItemCount() {
        return roster.length;
    }
}
