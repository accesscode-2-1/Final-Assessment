package nyc.c4q;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by charlynbuchanan on 8/30/15.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "members.db";
    private static final int DATABASE_VERSION = 1;

    //Set up columns
    public static final String TABLE_MEMBERS = "members";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FIRST_NAME = "first";
    public static final String COLUMN_LAST_NAME = "last";
    public static final String COLUMN_HOUSE = "house";

    //Database creation sql statement
    public static final String DATABASE_CREATE = "create table "
    + TABLE_MEMBERS + "(" + COLUMN_FIRST_NAME + "integer primary key autoincrement, "
            + "text not null);" + COLUMN_LAST_NAME + COLUMN_HOUSE;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //make table with previously made create string.
        getReadableDatabase().execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBERS);

    }
}
