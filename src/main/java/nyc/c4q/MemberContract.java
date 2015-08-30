package nyc.c4q;

import android.provider.BaseColumns;

public class MemberContract {

    public static final String PRIMARY_KEY = " PRIMARY KEY";
    public static final String INT_TYPE = " INTEGER";
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MemberEntry.TABLE_NAME +
                    " (" +
                    MemberEntry.COLUMN_ID + INT_TYPE + PRIMARY_KEY + COMMA_SEP +
                    MemberEntry.COLUMN_NAME + TEXT_TYPE + COMMA_SEP +
                    MemberEntry.COLUMN_DOBMONTH + INT_TYPE + COMMA_SEP +
                    MemberEntry.COLUMN_DOBDAY + INT_TYPE + COMMA_SEP +
                    MemberEntry.COLUMN_DOBYEAR + INT_TYPE + COMMA_SEP +
                    MemberEntry.COLUMN_CITY + TEXT_TYPE + COMMA_SEP +
                    MemberEntry.COLUMN_STATE + TEXT_TYPE + COMMA_SEP +
                    ")";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MemberEntry.TABLE_NAME;

    public static abstract class MemberEntry implements BaseColumns {
        public static final String TABLE_NAME = "MEMBERS";
        public static final String COLUMN_ID = "ID";
        public static final String COLUMN_NAME = "TITLE";
        public static final String COLUMN_DOBMONTH = "AUTHOR";
        public static final String COLUMN_DOBDAY = "ISBN";
        public static final String COLUMN_DOBYEAR = "ISBN13";
        public static final String COLUMN_CITY = "PUBLISHER";
        public static final String COLUMN_STATE = "PUBLISHYEAR";
    }
}
