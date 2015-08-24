package nyc.c4q;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.ListView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MembersActivity extends Activity {

    public ListView list;
    private MemberAdapter mAdapter;
    private DatabaseHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);

        list = (ListView) findViewById(R.id.list);
        new DatabaseTask().execute();
    }

    private class DatabaseTask extends AsyncTask<Void, Void, List<Member>> {

        @Override
        protected List<Member> doInBackground(Void... params) {

            mHelper = DatabaseHelper.getInstance(getApplicationContext());
            Calendar calendar = Calendar.getInstance();
            Date today = new Date(calendar.get(Calendar.YEAR)-1900, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

            List<Member> list = mHelper.loadMemberData();

            for (Member member : list) {
                List<CheckedOut> dues = mHelper.loadCheckOuts(member.getName());
                for (CheckedOut out : dues) {

                    if (today.after(out.getDueDate())) {
                        member.setIsRed(true);
                        break;
                    }

                }
            }


            return list;

        }

        @Override
        protected void onPostExecute(List<Member> members) {
            mAdapter = new MemberAdapter(getApplicationContext(), members);
            list.setAdapter(mAdapter);
        }
    }

}
