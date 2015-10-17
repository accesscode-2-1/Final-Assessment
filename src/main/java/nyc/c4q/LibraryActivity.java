package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;

import nyc.c4q.db.Book;
import nyc.c4q.db.DatabaseHelper;
import nyc.c4q.db.Member;


public class LibraryActivity extends Activity {

    public EditText inputParameter;
    DatabaseHelper dbHelper;
    TextView displayInfo;
    Context context;
    Member member = null;
    Book book = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        context = this;

        inputParameter = (EditText) findViewById(R.id.input_parameter);
        dbHelper = DatabaseHelper.getInstance(this);
        displayInfo = (TextView) findViewById(R.id.text_display);

        new dbInitialize().execute();
    }

    private class dbInitialize extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            //BOOKS
            Reader reader = null;
            InputStream stream = context.getResources()
                    .openRawResource(R.raw.books);
            reader = new BufferedReader(new InputStreamReader(stream), 8092);

            // parse json
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = (JsonArray)parser.parse(reader);
            ArrayList<Book> books = new ArrayList<>();
            for(JsonElement jsonElement : jsonArray){
                books.add(new Gson().fromJson(jsonElement, Book.class));
            }
            Log.d("BOOKS", "Parsed");

            //MEMBERS
            Reader memReader = null;
            InputStream memStream = context.getResources()
                    .openRawResource(R.raw.members);
            memReader = new BufferedReader(new InputStreamReader(memStream), 8092);

            // parse json
            JsonParser memParser = new JsonParser();
            JsonArray memJsonArray = (JsonArray)memParser.parse(memReader);
            ArrayList<Member> members = new ArrayList<>();
            for(JsonElement jsonElement : memJsonArray){
                members.add(new Gson().fromJson(jsonElement, Member.class));
            }
            Log.d("MEMBERS", "Parsed");

            //Insert Into DB
            for(Book book: books) {
                try {
                    dbHelper.insertRow(book);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            for(Member member: members){
                try {
                    dbHelper.insertRow(member);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            Log.d("DATABASE", "LOADED");

            return null;
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
        displayInfo.setText("");
        final String name = inputParameter.getText().toString();

        // TODO Display member information for the member with the given name.


        try {
            member = dbHelper.loadSpecificMember(name);
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(context,"SQLException error",Toast.LENGTH_SHORT).show();
        }

        if(member != null){
            Log.d("MEMBER", member.getId() + "");
            displayInfo.setText(member.toString());
        }else{
            Toast.makeText(context,"Member not found",Toast.LENGTH_SHORT).show();
        }

        inputParameter.setText("");
    }

    public void button_getBook_onClick(View view) {
        displayInfo.setText("");
        String isbn = inputParameter.getText().toString();

        // TODO Display book information for the book with the given ISBN.



        try {
            book = dbHelper.loadSpecificBook(isbn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(book != null){
            Log.d("BOOK", book.getId() + "");
            displayInfo.setText(book.toString());
        }else{
            Toast.makeText(context,"Book not found",Toast.LENGTH_SHORT).show();
        }

        inputParameter.setText("");
    }

    public void button_getCheckedOut_onClick(View view) {
        String name = inputParameter.getText().toString();

        // TODO Display a list of books that the member with the given name
        //      currently has checked out, ordered by due date, with the
        //      earliest due first.
    }

}
