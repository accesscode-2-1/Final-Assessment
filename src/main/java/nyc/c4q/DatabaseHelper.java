package nyc.c4q;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import nyc.c4q.BooksDbSchema.BooksTable;

/**
 * Created by jaellysbales on 8/30/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "booksBase.db";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_NAME, null, VERSION, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table" + BooksTable.name + "(" +
                        " _id integer primary key autoincrement, " +
                        BooksTable.Cols.ID + ", " +
                        BooksTable.Cols.TITLE + ", " +
                        BooksTable.Cols.AUTHOR + ", " +
                        BooksTable.Cols.ISBN + ", " +
                        BooksTable.Cols.ISBN13 + ", " +
                        BooksTable.Cols.PUBLISHER + ", " +
                        BooksTable.Cols.PUBLISHYEAR + ", " +
                        BooksTable.Cols.CHECKEDOUT + ", " +
                        BooksTable.Cols.CHECKEDOUTBY + ", " +
                        BooksTable.Cols.CHECKOUTDATEYEAR + ", " +
                        BooksTable.Cols.CHECKOUTDATEMONTH + ", " +
                        BooksTable.Cols.CHECKOUTDATEDAY + ", " +
                        BooksTable.Cols.DUEDATEYEAR + ", " +
                        BooksTable.Cols.DUEDATEMONTH + ", " +
                        BooksTable.Cols.DUEDATEDAY + ", "
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
