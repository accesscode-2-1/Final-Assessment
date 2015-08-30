package nyc.c4q;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import nyc.c4q.BooksDbSchema.BooksTable;


public class LibraryActivity extends Activity {

    public EditText inputParameter;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        mContext = this.getApplicationContext();
//        mDatabase = new DatabaseHelper(mContext).getWritableDatabase();
//        mBooks = new ArrayList<>();

        inputParameter = (EditText) findViewById(R.id.input_parameter);
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

    private static ContentValues getContentValues(Books book) {
        ContentValues values = new ContentValues();

        values.put(BooksTable.Cols.ID, book.getId().toString());
        values.put(BooksTable.Cols.TITLE, book.getTitle());
        values.put(BooksTable.Cols.AUTHOR, book.getAuthor());
        values.put(BooksTable.Cols.ISBN, book.getIsbn());
        values.put(BooksTable.Cols.ISBN13, book.getIsbn13());
        values.put(BooksTable.Cols.PUBLISHER, book.getPublisher());
        values.put(BooksTable.Cols.PUBLISHYEAR, book.getPublishyear());
        values.put(BooksTable.Cols.CHECKEDOUT, book.getCheckedout());
        values.put(BooksTable.Cols.CHECKEDOUTBY, book.getCheckedoutby());
        values.put(BooksTable.Cols.CHECKOUTDATEYEAR, book.getCheckoutdateyear());
        values.put(BooksTable.Cols.CHECKOUTDATEMONTH, book.getCheckoutdatemonth());
        values.put(BooksTable.Cols.CHECKOUTDATEDAY, book.getCheckoutdateday());
        values.put(BooksTable.Cols.DUEDATEYEAR, book.getDuedateyear());
        values.put(BooksTable.Cols.DUEDATEMONTH, book.getDuedatemonth());
        values.put(BooksTable.Cols.DUEDATEDAY, book.getDuedateday());

        return values;
    }

    public void addBook(Books b) {
        ContentValues values = getContentValues(b);
        mDatabase.insert(BooksTable.name, null, values);
    }


}
