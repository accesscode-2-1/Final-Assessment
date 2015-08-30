package nyc.c4q;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String MYDB = "mydb.db";
    private static final int VERSION = 1;
    private static DatabaseHelper mHelper;

    private DatabaseHelper getInstance(Context context) {
        if (mHelper == null) {
            mHelper = new DatabaseHelper(context.getApplicationContext());
            return mHelper;
        }
        return mHelper;
    }

    public DatabaseHelper(Context context) {
        super(context, MYDB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Books.class);
            TableUtils.createTable(connectionSource, Members.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Books.class, true);
            TableUtils.dropTable(connectionSource, Members.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertMemberRow(int id, String name, int dob_month, int dob_day, int dob_year, String city, String state) {
        Members member = new Members( name, dob_month, dob_day, dob_year, city, state);
        try {
            getDao(Members.class).create(member);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBookRow(int id, String title, String author, String isbn, String isbn13, String publisher, int publishyear) {
        Books book = new Books( title, author, isbn, isbn13, publisher, publishyear);
        try {
            getDao(Books.class).create(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Books> loadBookData() throws SQLException {
        List<Books> isbn = getDao(Books.class).queryForAll();
        return isbn;
    }

    public List<Members> loadMemberData() throws SQLException {
        List<Members> name = getDao(Members.class).queryForAll();
        return name;
    }
}
