package nyc.c4q;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Luke on 8/24/2015.
 */
public class MemberAdapter extends BaseAdapter {

    private Context mContext;
    private List<Member> mList;

    public MemberAdapter(Context context, List<Member> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Member getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listitem_member, parent, false);
        }

        Member member = getItem(position);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView dob = (TextView) convertView.findViewById(R.id.dob);
        TextView id = (TextView) convertView.findViewById(R.id.id);

        name.setText(member.getName());
        dob.setText(member.getDob_month() + "/" + member.getDob_day() + "/" + member.getDob_year());
        id.setText(member.getId());
        if (member.isRed()) {
            name.setTextColor(Color.parseColor("#AA0000"));
        }


        return convertView;
    }
}
