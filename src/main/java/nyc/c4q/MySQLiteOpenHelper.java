package nyc.c4q;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by c4q-marbella on 8/30/15.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "memberManager";

    // Contacts table name
    private static final String TABLE_MEMBERS = "members";




    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }

public static abstract class MemberEntry implements BaseColumns{
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DOB = "dob";
    private static final String KEY_LOCATION = "location";
}
    //   CREATE TABLE
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + MemberEntry.TABLE_NAME;

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + MemberEntry.TABLE_NAME;
}