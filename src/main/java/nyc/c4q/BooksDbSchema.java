package nyc.c4q;

/**
 * Created by jaellysbales on 8/30/15.
 */
public class BooksDbSchema {
    public static final class BooksTable {
        public static final String name = "books";

        public static final class Cols {
            public static final String ID = "id";
            public static final String TITLE = "title";
            public static final String AUTHOR = "author";
            public static final String ISBN = "isbn";
            public static final String ISBN13 = "isbn13";
            public static final String PUBLISHER = "publisher";
            public static final String PUBLISHYEAR = "publish year";
            public static final String CHECKEDOUT = "checked out";
            public static final String CHECKEDOUTBY = "checked out by";
            public static final String CHECKOUTDATEYEAR = "check out date year";
            public static final String CHECKOUTDATEMONTH = "check out date month";
            public static final String CHECKOUTDATEDAY = "check out date day";
            public static final String DUEDATEYEAR = "due date year";
            public static final String DUEDATEMONTH = "due date month";
            public static final String DUEDATEDAY = "due date day";
        }
    }
}
