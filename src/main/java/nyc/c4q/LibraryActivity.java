package nyc.c4q;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class LibraryActivity extends Activity {

    public EditText inputParameter;
    DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        dbAdapter = new DBAdapter(this);

        inputParameter = (EditText) findViewById(R.id.input_parameter);

        loadBookJSONFromAsset("books.json");
        loadMemberJSONFromAsset("members.json");


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
        String name = inputParameter.getText().toString();

        dbAdapter.getDataForMember(name);

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

    public void loadMemberJSONFromAsset(String fileName) {
        String json = null;
        try {
            InputStream is = getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        sendMemberInfo(json);
    }
    public void loadBookJSONFromAsset(String fileName) {
        String json = null;
        try {
            InputStream is = getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        sendMemberInfo(json);
    }

    public void sendMemberInfo(String json){

        try {
            JSONArray obj = new JSONArray(json);

            for(int i=0;i<obj.length();i++) {
                JSONObject jsonObject = obj.getJSONObject(0);
                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                int birthMonth = jsonObject.getInt("dob_month");
                int birthDay = jsonObject.getInt("dob_day");
                int birthYear = jsonObject.getInt("dob_year");
                String city = jsonObject.getString("city");
                String state = jsonObject.getString("state");
                dbAdapter.insertMemberData(id,name,city,state,birthMonth,birthDay,birthYear);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void sendBookInfoToDB(String json){
        try {
            JSONArray obj = new JSONArray(json);

            for(int i=0;i<obj.length();i++) {
                JSONObject jsonObject = obj.getJSONObject(0);
                int id = jsonObject.getInt("id");
                String title = jsonObject.getString("title");
                String author=jsonObject.getString("author");
                String isbn=jsonObject.getString("isbn");
                String isbn13=jsonObject.getString("isbn13");
                String publisher=jsonObject.getString("publisher");
                int publishYear= jsonObject.getInt("publishyear");
                boolean checkout=jsonObject.getBoolean("checkedout");
                int checkoutby=jsonObject.getInt("checkoutby");
                int chheckoutYear=jsonObject.getInt("checkoutdateyear");
                int checkoutdatemonth=jsonObject.getInt("checkoutdatemonth");
                int checkoutdateday=jsonObject.getInt("checkoutdateday");
                int dueDateYear=jsonObject.getInt("duedateyear");
                int dueDateMonth=jsonObject.getInt("duedatemonth");
                int dueDateDay=jsonObject.getInt("duedateday");

                dbAdapter.insertBookData(id,title,author,isbn,isbn13,publisher,publishYear,checkout,checkoutby,chheckoutYear,checkoutdatemonth,checkoutdateday
                ,dueDateYear,dueDateMonth,dueDateDay);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
