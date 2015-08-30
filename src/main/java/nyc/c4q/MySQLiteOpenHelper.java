package nyc.c4q;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by c4q-raynaldie on 8/30/15.
 */
public class MySQLiteOpenHelper extends OrmLiteSqliteOpenHelper {
    public static final String MYDB = "mydb";
    public static final int VERSION = 5;

    private static MySQLiteOpenHelper INSTANCE;

    public static synchronized MySQLiteOpenHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new MySQLiteOpenHelper(context.getApplicationContext());
        }

        return INSTANCE;
    }

    private MySQLiteOpenHelper(Context context) {
        super(context, MYDB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Book.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Book.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertData() throws SQLException {
        Dao<Book, ?> dao = getDao(Book.class);

        dao.delete(dao.deleteBuilder().prepare());
        insertRow(1, "The Circle", "Dave Eggers", "0385351399", "9780385351393", "Knopf", "2013", true, null, null, null, null, null, null, null);
    }

    private void insertRow(int id,String title, String author, String isbn, String isbn13, String publisher, String publishyear,
                           boolean checkedout, String checkedoutby, String checkoutdateyear, String checkoutdatemonth, String checkoutdateday,
                           String duedateyear, String duedatemonth, String duedateday) throws SQLException {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setIsbn13(isbn13);
        book.setPublisher(publisher);
        book.setPublishyear(publishyear);
        book.setCheckedout(checkedout);
        book.setCheckedoutby(checkedoutby);
        book.setCheckoutdateyear(checkoutdateyear);
        book.setCheckoutdatemonth(checkoutdatemonth);
        book.setCheckoutdateday(checkoutdateday);
        book.setDuedateday(duedateday);
        book.setDuedateyear(duedateyear);
        book.setDuedatemonth(duedatemonth);
        getDao(Book.class).create(book);



    }

}


