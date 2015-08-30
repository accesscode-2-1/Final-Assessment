package nyc.c4q;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DBAsyncTask2 extends AsyncTask<String, Void, Void> {

    public Context context;

    @Override
    protected Void doInBackground(String... strings) {
        LibraryDBHelper helper = new LibraryDBHelper(context);
        try {
            JSONArray members = new JSONArray(strings[0]);
            for (int i = 0; i < members.length(); i++) {
                JSONObject member = members.getJSONObject(i);
                int id = member.getInt("id");
                String name = member.getString("name");
                int dob_month = member.getInt("dob_month");
                int dob_day = member.getInt("dob_day");
                int dob_year = member.getInt("dob_year");
                String city = member.getString("city");
                String state = member.getString("state");
                Member newMember = new Member(id, name, dob_month, dob_day, dob_year, city, state);
                helper.insertMember(newMember);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
