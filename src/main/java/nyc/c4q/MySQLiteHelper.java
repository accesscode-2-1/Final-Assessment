package nyc.c4q;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by c4q-vanice on 8/30/15.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_MEMBERS = "members.db";
    public static final String TABLE_MEMBERS = "members";
    public static final String TABLE_COLUMN_ID = "id";
    public static final String TABLE_COLUMN_NAME = "name";
    public static final String TABLE_COLUMN_MONTH = "dob_month";
    public static final String TABLE_COLUMN_DAY = "dob_day";
    public static final String TABLE_COLUMN_YEAR = "dob_year";
    public static final String TABLE_COLUMN_LOCATION = "location";

    public static final int VERSION = 1;
    private static MySQLiteHelper INSTANCE;

    public static synchronized MySQLiteHelper getInstance(Context context)
    {
        if(INSTANCE == null)
        {
            INSTANCE = new MySQLiteHelper(context.getApplicationContext());
        }

        return INSTANCE;
    }

    protected MySQLiteHelper(Context context) {
        super(context, DATABASE_MEMBERS, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    String CREATE_TABLE = "CREATE TABLE" + DATABASE_MEMBERS + "(" + TABLE_COLUMN_ID + "id," + TABLE_COLUMN_NAME
            + "name, " + TABLE_COLUMN_DAY + "dob_day, " + TABLE_COLUMN_MONTH + "dob_month, " + TABLE_COLUMN_YEAR + "dob_year, " +
            TABLE_COLUMN_LOCATION + "location, " + ")";
     db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Members addMembers(Members members ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TABLE_COLUMN_ID, members.getId());
        values.put(TABLE_COLUMN_NAME, members.getName());
        values.put(TABLE_COLUMN_MONTH, members.getDob_month());
        values.put(TABLE_COLUMN_DAY, members.getDob_day());
        values.put(TABLE_COLUMN_YEAR, members.getDob_year());
        values.put(TABLE_COLUMN_LOCATION, members.getCity() + members.getState());

        db.insert(TABLE_MEMBERS, null, values);
        db.close();

        return members;
    }
}
