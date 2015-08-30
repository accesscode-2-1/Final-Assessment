package nyc.c4q;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Calendar;

public class LibraryDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "library.db";
    private static final int DATABASE_VERSION = 1;

    public LibraryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(BookContract.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(MemberContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL(BookContract.SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(MemberContract.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public void insertBook(Book book) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BookContract.BookEntry.COLUMN_ID, book.getId());
        values.put(BookContract.BookEntry.COLUMN_TITLE, book.getTitle());
        values.put(BookContract.BookEntry.COLUMN_AUTHOR, book.getAuthor());
        values.put(BookContract.BookEntry.COLUMN_ISBN, book.getIsbn());
        values.put(BookContract.BookEntry.COLUMN_ISBN13, book.getIsbn13());
        values.put(BookContract.BookEntry.COLUMN_PUBLISHER, book.getPublisher());
        values.put(BookContract.BookEntry.COLUMN_PUBLISHYEAR, book.getPublishyear());
        values.put(BookContract.BookEntry.COLUMN_CHECKEDOUT, book.getCheckedout());
        values.put(BookContract.BookEntry.COLUMN_CHECKEDOUTBY, book.getCheckedoutby());
        values.put(BookContract.BookEntry.COLUMN_CHECKOUTDATEYEAR, book.getCheckoutdateyear());
        values.put(BookContract.BookEntry.COLUMN_CHECKOUTDATEMONTH, book.getCheckoutdatemonth());
        values.put(BookContract.BookEntry.COLUMN_CHECKOUTDATEDAY, book.getCheckoutdateday());
        values.put(BookContract.BookEntry.COLUMN_DUEDATEYEAR, book.getDuedateyear());
        values.put(BookContract.BookEntry.COLUMN_DUEDATEMONTH, book.getDuedatemonth());
        values.put(BookContract.BookEntry.COLUMN_DUEDATEDAY, book.getDuedateday());
        db.insert(BookContract.BookEntry.TABLE_NAME, null, values);
        db.close();
    }

    public void insertMember(Member member) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MemberContract.MemberEntry.COLUMN_ID, member.getId());
        values.put(MemberContract.MemberEntry.COLUMN_NAME, member.getName());
        values.put(MemberContract.MemberEntry.COLUMN_DOBMONTH, member.getDob_month());
        values.put(MemberContract.MemberEntry.COLUMN_DOBDAY, member.getDob_day());
        values.put(MemberContract.MemberEntry.COLUMN_DOBYEAR, member.getDob_year());
        values.put(MemberContract.MemberEntry.COLUMN_CITY, member.getCity());
        values.put(MemberContract.MemberEntry.COLUMN_STATE, member.getState());
        db.insert(MemberContract.MemberEntry.TABLE_NAME, null, values);
        db.close();
    }

    public void checkOut(int memberId, int bookId) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DAY_OF_MONTH, 14);
        int yearDue = calendar.get(Calendar.YEAR);
        int monthDue = calendar.get(Calendar.MONTH);
        int dayDue = calendar.get(Calendar.DAY_OF_MONTH);
        values.put(BookContract.BookEntry.COLUMN_CHECKEDOUT, true);
        values.put(BookContract.BookEntry.COLUMN_CHECKEDOUTBY, memberId);
        values.put(BookContract.BookEntry.COLUMN_CHECKOUTDATEYEAR, year);
        values.put(BookContract.BookEntry.COLUMN_CHECKOUTDATEMONTH, month);
        values.put(BookContract.BookEntry.COLUMN_CHECKOUTDATEDAY, day);
        values.put(BookContract.BookEntry.COLUMN_DUEDATEYEAR, yearDue);
        values.put(BookContract.BookEntry.COLUMN_DUEDATEMONTH, monthDue);
        values.put(BookContract.BookEntry.COLUMN_DUEDATEDAY, dayDue);
        db.update(BookContract.BookEntry.TABLE_NAME, values, BookContract.BookEntry.COLUMN_ID + " = ?", new String[]{String.valueOf(bookId)});
    }

    public boolean checkIn(int memberId, int bookId) {
        SQLiteDatabase db = getWritableDatabase();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //query db for overdue status comparing with calendar instance

        ContentValues values = new ContentValues();
        values.put(BookContract.BookEntry.COLUMN_CHECKEDOUT, false);
        values.put(BookContract.BookEntry.COLUMN_CHECKEDOUTBY, 0);
        values.put(BookContract.BookEntry.COLUMN_CHECKOUTDATEYEAR, 0);
        values.put(BookContract.BookEntry.COLUMN_CHECKOUTDATEMONTH, 0);
        values.put(BookContract.BookEntry.COLUMN_CHECKOUTDATEDAY, 0);
        values.put(BookContract.BookEntry.COLUMN_DUEDATEYEAR, 0);
        values.put(BookContract.BookEntry.COLUMN_DUEDATEMONTH, 0);
        values.put(BookContract.BookEntry.COLUMN_DUEDATEDAY, 0);
        db.update(BookContract.BookEntry.TABLE_NAME, values, BookContract.BookEntry.COLUMN_ID + " = ?", new String[]{String.valueOf(bookId)});
        return false;
    }

    public String getMemberInfo(String name) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(MemberContract.MemberEntry.TABLE_NAME, new String[]{
                MemberContract.MemberEntry.COLUMN_ID,
                MemberContract.MemberEntry.COLUMN_NAME,
                MemberContract.MemberEntry.COLUMN_DOBMONTH,
                MemberContract.MemberEntry.COLUMN_DOBDAY,
                MemberContract.MemberEntry.COLUMN_DOBYEAR,
                MemberContract.MemberEntry.COLUMN_CITY,
                MemberContract.MemberEntry.COLUMN_STATE}, MemberContract.MemberEntry.COLUMN_NAME + " = ?", new String[]{
                name}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Member searchedMember = new Member(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4),
                cursor.getString(5), cursor.getString(6));
        return searchedMember.toString();
    }

    public String getBookInfo(String isbn) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(BookContract.BookEntry.TABLE_NAME, new String[]{
                BookContract.BookEntry.COLUMN_ID,
                BookContract.BookEntry.COLUMN_TITLE,
                BookContract.BookEntry.COLUMN_AUTHOR,
                BookContract.BookEntry.COLUMN_ISBN,
                BookContract.BookEntry.COLUMN_ISBN13,
                BookContract.BookEntry.COLUMN_PUBLISHER,
                BookContract.BookEntry.COLUMN_PUBLISHYEAR,
                BookContract.BookEntry.COLUMN_CHECKEDOUT,
                BookContract.BookEntry.COLUMN_CHECKEDOUTBY,
                BookContract.BookEntry.COLUMN_CHECKOUTDATEYEAR,
                BookContract.BookEntry.COLUMN_CHECKOUTDATEMONTH,
                BookContract.BookEntry.COLUMN_CHECKOUTDATEDAY,
                BookContract.BookEntry.COLUMN_DUEDATEYEAR,
                BookContract.BookEntry.COLUMN_DUEDATEMONTH,
                BookContract.BookEntry.COLUMN_DUEDATEDAY}, BookContract.BookEntry.COLUMN_ISBN + " = ?", new String[]{
                isbn}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Book searchedBook = new Book(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getInt(6));
        return searchedBook.toString();
    }
}
