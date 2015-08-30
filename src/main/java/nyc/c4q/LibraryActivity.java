package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;


public class LibraryActivity extends Activity {

    public EditText inputParameter;

    LibraryDBHelper helper;

    DBAsyncTask1 dbAsyncTask1;
    DBAsyncTask2 dbAsyncTask2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        inputParameter = (EditText) findViewById(R.id.input_parameter);

        helper = new LibraryDBHelper(this);

        dbAsyncTask1 = new DBAsyncTask1();
        dbAsyncTask2 = new DBAsyncTask2();

        dbAsyncTask1.execute(getRawJSON(this, R.raw.books));
        dbAsyncTask2.execute(getRawJSON(this, R.raw.members));
    }

    public String getRawJSON (Context context, int jsonResource) {
        InputStream is = context.getResources().openRawResource(jsonResource);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String rawJSON;
        while (true) {
            try {
                rawJSON = reader.readLine();
                if (rawJSON == null) {
                    break;
                }
                sb.append(rawJSON + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String jsonString = sb.toString();
        return jsonString;
    }

    public void checkOut(int memberId, int bookId) {
        // TODO This method is called when the member with the given ID checks
        //      out the book with the given ID. Update the system accordingly.
        //      The due date for the book is two weeks from today.
        helper.checkOut(memberId, bookId);
    }

    public boolean checkIn(int memberId, int bookId) {
        // TODO This method is called when the member with the given ID returns
        //      the book with the given ID. Update the system accordingly. If
        //      the member is returning the book on time, return true. If it's
        //      late, return false.
        helper.checkIn(memberId, bookId);
        return false;
    }

    public void button_getMember_onClick(View view) {
        String name = inputParameter.getText().toString();

        // TODO Display member information for the member with the given name.
        helper.getMemberInfo(name);
    }

    public void button_getBook_onClick(View view) {
        String isbn = inputParameter.getText().toString();

        // TODO Display book information for the book with the given ISBN.
        helper.getBookInfo(isbn);
    }

    public void button_getCheckedOut_onClick(View view) {
        String name = inputParameter.getText().toString();

        // TODO Display a list of books that the member with the given name
        //      currently has checked out, ordered by due date, with the
        //      earliest due first.
    }

}
