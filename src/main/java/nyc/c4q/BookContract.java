package nyc.c4q;

import android.provider.BaseColumns;

public class BookContract {

    public static final String PRIMARY_KEY = " PRIMARY KEY";
    public static final String INT_TYPE = " INTEGER";
    public static final String TEXT_TYPE = " TEXT";
    public static final String BOOLEAN_TYPE = " BOOLEAN";
    public static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + BookEntry.TABLE_NAME +
                    " (" +
                    BookEntry.COLUMN_ID + INT_TYPE + PRIMARY_KEY + COMMA_SEP +
                    BookEntry.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_AUTHOR + TEXT_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_ISBN + TEXT_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_ISBN13 + TEXT_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_PUBLISHER + TEXT_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_PUBLISHYEAR + INT_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_CHECKEDOUT + BOOLEAN_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_CHECKEDOUTBY+ INT_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_CHECKOUTDATEYEAR + INT_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_CHECKOUTDATEMONTH + INT_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_CHECKOUTDATEDAY + INT_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_DUEDATEYEAR + INT_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_DUEDATEMONTH + INT_TYPE + COMMA_SEP +
                    BookEntry.COLUMN_DUEDATEDAY + INT_TYPE + COMMA_SEP +
                    ")";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + BookEntry.TABLE_NAME;

    public static abstract class BookEntry implements BaseColumns {
        public static final String TABLE_NAME = "BOOKS";
        public static final String COLUMN_ID = "ID";
        public static final String COLUMN_TITLE = "TITLE";
        public static final String COLUMN_AUTHOR = "AUTHOR";
        public static final String COLUMN_ISBN = "ISBN";
        public static final String COLUMN_ISBN13 = "ISBN13";
        public static final String COLUMN_PUBLISHER = "PUBLISHER";
        public static final String COLUMN_PUBLISHYEAR = "PUBLISHYEAR";
        public static final String COLUMN_CHECKEDOUT = "CHECKEDOUT";
        public static final String COLUMN_CHECKEDOUTBY = "CHECKEDOUTBY";
        public static final String COLUMN_CHECKOUTDATEYEAR = "CHECKOUTDATEYEAR";
        public static final String COLUMN_CHECKOUTDATEMONTH = "CHECKOUTDATEMONTH";
        public static final String COLUMN_CHECKOUTDATEDAY = "CHECKOUTDATEDAY";
        public static final String COLUMN_DUEDATEYEAR = "DUEDATEYEAR";
        public static final String COLUMN_DUEDATEMONTH = "DUEDATEMONTH";
        public static final String COLUMN_DUEDATEDAY = "DUEDATEDAY";


    }
}
