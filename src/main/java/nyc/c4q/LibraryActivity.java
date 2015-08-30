package nyc.c4q;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;


public class LibraryActivity extends Activity {

    public EditText inputParameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        MySQLiteHelper db = new MySQLiteHelper(this);

        inputParameter = (EditText) findViewById(R.id.input_parameter);

        InputStream inputStreamMembers = getResources().openRawResource(R.raw.members);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int ctr;
        try {
            ctr = inputStreamMembers.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStreamMembers.read();
            }
            inputStreamMembers.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v("Text Data", byteArrayOutputStream.toString());
        try {

            JSONArray jArray = new JSONArray(byteArrayOutputStream.toString());
            String id = "";
            String name = "";
            String dob_month = "";
            String dob_day = "";
            String dob_year = "";
            String city = "";
            String state = "";
            for (int i = 0; i < jArray.length(); i++) {
                id = jArray.getJSONObject(i).getString("id");
                name = jArray.getJSONObject(i).getString("name");
                dob_month = jArray.getJSONObject(i).getString("dob_month");
                dob_day = jArray.getJSONObject(i).getString("dob_day");
                dob_year = jArray.getJSONObject(i).getString("dob_year");
                city = jArray.getJSONObject(i).getString("city");
                state = jArray.getJSONObject(i).getString("state");
                HashMap<String, String> memberData = new HashMap<String, String>();
                memberData.put(id, "id");
                memberData.put(name, "name");
                memberData.put(dob_month, "dob_month");
                memberData.put(dob_day, "dob_day");
                memberData.put(dob_year, "dob_year");
                memberData.put(city, "city");
                memberData.put(state, "state");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void checkOut(int memberId, int bookId) {
        // TODO This method is called when the member with the given ID checks
        //      out the book with the given ID. Update the system accordingly.
        //      The due date for the book is two weeks from today.
    }

    public boolean checkIn(int memberId, int bookId) {
        // TODO This method is called when the member with the given ID returns
        //      the book with the given ID. Update the system accordingly. If
        //      the member is returning the book on time, return true. If it's
        //      late, return false.

        return false;
    }

    public void button_getMember_onClick(View view) {
        MySQLiteHelper db = new MySQLiteHelper(this);
        String name = inputParameter.getText().toString();

        // TODO Display member information for the member with the given name.
    }

    public void button_getBook_onClick(View view) {
        String isbn = inputParameter.getText().toString();

        // TODO Display book information for the book with the given ISBN.
    }

    public void button_getCheckedOut_onClick(View view) {
        String name = inputParameter.getText().toString();

        // TODO Display a list of books that the member with the given name
        //      currently has checked out, ordered by due date, with the
        //      earliest due first.
    }

}
