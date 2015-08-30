package nyc.c4q;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DBAsyncTask1 extends AsyncTask<String, Void, Void> {

    public Context context;

    @Override
    protected Void doInBackground(String... strings) {
        LibraryDBHelper helper = new LibraryDBHelper(context);

        try {
            JSONArray books = new JSONArray(strings[0]);
            for (int i = 0; i < books.length(); i++) {
                JSONObject book = books.getJSONObject(i);
                int id = book.getInt("id");
                String title = book.getString("title");
                String author = book.getString("author");
                String isbn = book.getString("isbn");
                String isbn13 = book.getString("isbn13");
                String publisher = book.getString("publisher");
                int publisheryear = book.getInt("publishyear");
                boolean checkedout = book.getBoolean("checkedout");
                int checkedoutby = book.getInt("checkedoutby");
                int checkoutdateyear = book.getInt("checkoutdateyear");
                int checkoutdatemonth = book.getInt("checkoutdatemonth");
                int checkoutdateday = book.getInt("checkoutdateday");
                int duedateyear = book.getInt("duedateyear");
                int duedatemonth = book.getInt("duedatemonth");
                int duedateday = book.getInt("duedateday");
                Book newBook = new Book(id, title, author, isbn, isbn13, publisher, publisheryear, checkedout, checkedoutby, checkoutdateyear, checkoutdatemonth, checkoutdateday, duedateyear, duedatemonth, duedateday);
                helper.insertBook(newBook);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
