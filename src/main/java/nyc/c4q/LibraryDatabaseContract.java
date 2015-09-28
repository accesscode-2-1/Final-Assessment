package nyc.c4q;

import android.provider.BaseColumns;

/**
 * Created by alvin2 on 9/27/15.
 */
public final class LibraryDatabaseContract {

    public LibraryDatabaseContract() {
    }


    // Members table
    public static abstract class Members implements BaseColumns {
        public static final String TABLE_NAME = "members";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DOB_MONTH = "dob_month";
        public static final String COLUMN_NAME_DOB_DAY = "dob_day";
        public static final String COLUMN_NAME_DOB_YEAR = "dob_year";
        public static final String COLUMN_NAME_CITY = "city";
        public static final String COLUMN_NAME_STATE = "state";
    }

    // Books table
    public static abstract class Books implements BaseColumns {
        public static final String TABLE_NAME = "books";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_AUTHOR = "author";
        public static final String COLUMN_NAME_ISBN = "isbn";
        public static final String COLUMN_NAME_ISBN13 = "isbn13";
        public static final String COLUMN_NAME_PUBLISHER = "publisher";
        public static final String COLUMN_NAME_PUBLISH_YEAR = "publish_year";
        public static final String COLUMN_NAME_CHECKED_OUT = "checked_out";
        public static final String COLUMN_NAME_CHECKED_OUT_BY = "co_by";
        public static final String COLUMN_NAME_CHECKOUT_MONTH = "co_month";
        public static final String COLUMN_NAME_CHECKOUT_DAY = "co_day";
        public static final String COLUMN_NAME_CHECKOUT_YEAR = "co_year";
        public static final String COLUMN_NAME_DUE_MONTH = "due_month";
        public static final String COLUMN_NAME_DUE_DAY = "due_day";
        public static final String COLUMN_NAME_DUE_YEAR = "due_year";

    }
}
