package nyc.c4q;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.JsonArray;

import org.json.JSONException;
import org.json.JSONObject;


public class LibraryActivity extends Activity {

    public EditText inputParameter;
    private DatabaseHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        inputParameter = (EditText) findViewById(R.id.input_parameter);
    }

    private class MyDatabaseTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            mHelper = DatabaseHelper.getInstance(getApplicationContext());
            if (mHelper.fetchAllBooks() == null) {
                JsonArray bookArray = new JsonArray();
                for (int i =0; i<bookArray.size();i++){
                    JSONObject jsonObject = bookArray.getJsonObject(i);
                    try {
                        String title = jsonObject.getString("title");
                        String author = jsonObject.getString("author");
                        long isbn = jsonObject.getLong("isbn");
                        long isbn13 = jsonObject.getLong("isbn13");
                        String publisher = jsonObject.getString("publisher");
                        int publishyear = jsonObject.getInt("publishyear");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
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
