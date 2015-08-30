package nyc.c4q.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by c4q-ac35 on 8/30/15.
 */
public class BooksHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "books.db";
    private static final int DB_VERSION = 1;

    private static BooksHelper INSTANCE;


    public static synchronized BooksHelper getInstance(Context context)
    {
        if(INSTANCE == null)
        {
            INSTANCE = new BooksHelper(context.getApplicationContext());
        }

        return INSTANCE;
    }

    public BooksHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_BOOKS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void insertData(String tableName){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(tableName, null, null);
    }

    public static void insertRow(String bookTitle, String author, String isbn, String isbn13, String tableName, String publisher, int publishYear, boolean checkedOut, int memberId, int checkedOutYear, int checkoutMonth, int checkoutDay, int yearDue, int monthDue, int dayDue ,SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(BookEntry.COLUMN_TITLE,bookTitle);
        values.put(BookEntry.COLUMN_AUTHOR,author);
        values.put(BookEntry.COLUMN_ISBN,isbn);
        values.put(BookEntry.COLUMN_ISBN_13,isbn13);
        values.put(BookEntry.COLUMN_PUBLISHER,publisher);
        values.put(BookEntry.COLUMN_PUBLISH_YEAR,publishYear);
        values.put(BookEntry.COLUMN_CHECKED_OUT,checkedOut);
        values.put(BookEntry.COLUMN_CHECKED_OUT_BY,memberId);
        values.put(BookEntry.COLUMN_CHECKOUT_YEAR,checkedOutYear);
        values.put(BookEntry.COLUMN_CHECKOUT_MONTH,checkoutMonth);
        values.put(BookEntry.COLUMN_CHECKOUT_DAY,checkoutDay);
        values.put(BookEntry.COLUMN_DUE_DATE_YEAR,yearDue);
        values.put(BookEntry.COLUMN_DUE_DATE_MONTH,monthDue);
        values.put(BookEntry.COLUMN_DUE_DATE_DAY,dayDue);

        db.insertOrThrow(tableName,null,values);
    }

    public static abstract class BookEntry implements BaseColumns {
        public static final String COLUMN_TITLE = "Title";
        public static final String COLUMN_AUTHOR = "Author";
        public static final String COLUMN_ISBN = "ISBN";
        public static final String COLUMN_ISBN_13 = "Hours";
        public static final String COLUMN_PUBLISHER = "Publisher";
        public static final String COLUMN_PUBLISH_YEAR = "Publish Year";
        public static final String COLUMN_CHECKED_OUT = "Checked Out";
        public static final String COLUMN_CHECKED_OUT_BY = "Checked Out By";
        public static final String COLUMN_CHECKOUT_YEAR = "Checkout Year";
        public static final String COLUMN_CHECKOUT_MONTH = "Checkout Month";
        public static final String COLUMN_CHECKOUT_DAY = "Checkout Day";
        public static final String COLUMN_DUE_DATE_YEAR = "Year Due";
        public static final String COLUMN_DUE_DATE_MONTH = "Month Due";
        public static final String COLUMN_DUE_DATE_DAY = "Day Due";
    }

    private static final String SQL_CREATE_TABLE_BOOKS =
            "CREATE TABLE" + "BOOKS" +" (" +
                    BookEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    BookEntry.COLUMN_TITLE+" TEXT," +
                    BookEntry.COLUMN_AUTHOR+" TEXT," +
                    BookEntry.COLUMN_ISBN+" TEXT," +
                    BookEntry.COLUMN_ISBN_13+" TEXT"+
                    BookEntry.COLUMN_PUBLISHER+" TEXT"+
                    BookEntry.COLUMN_PUBLISH_YEAR+" INTEGER"+
                    BookEntry.COLUMN_CHECKED_OUT+" BOOLEAN"+
                    BookEntry.COLUMN_CHECKED_OUT_BY+" INTEGER"+
                    BookEntry.COLUMN_CHECKOUT_YEAR+" INTEGER"+
                    BookEntry.COLUMN_CHECKOUT_MONTH+" INTEGER"+
                    BookEntry.COLUMN_CHECKOUT_DAY+" INTEGER"+
                    BookEntry.COLUMN_DUE_DATE_YEAR+" INTEGER"+
                    BookEntry.COLUMN_DUE_DATE_MONTH+" INTEGER"+
                    BookEntry.COLUMN_DUE_DATE_DAY+" INTEGER"+
                    " )";


    public String deleteTable(String tableName){
        String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + tableName.toUpperCase();
        return SQL_DELETE_ENTRIES;
    }
}
