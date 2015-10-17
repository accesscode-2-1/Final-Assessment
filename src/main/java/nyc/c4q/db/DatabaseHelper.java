package nyc.c4q.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by c4q-anthonyf on 8/30/15.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private final static int VERSION = 1;
    private final static String MYDB = "MyDb";

    private static DatabaseHelper mHelper;

    public DatabaseHelper(Context context) {
        super(context, MYDB, null, VERSION);
    }

    public static synchronized DatabaseHelper getInstance(Context context){

        if(mHelper == null){
            mHelper = new DatabaseHelper(context.getApplicationContext());
        }

        return mHelper;

    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Book.class);
            TableUtils.createTable(connectionSource, Member.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Book.class, true);
            TableUtils.dropTable(connectionSource, Member.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Member loadSpecificMember(String name) throws SQLException, java.sql.SQLException {
                return getDao(Member.class)
                                .queryBuilder()
                                .where().eq("NAME", name)
                                .queryForFirst();
    }

    public Book loadSpecificBook(String isbn) throws SQLException, java.sql.SQLException {
        return getDao(Book.class)
                    .queryBuilder()
                    .where().eq("ISBN", isbn)
                    .queryForFirst();
    }

    public void insertRow(Book book) throws SQLException {
        getDao(Book.class).create(book);
    }

    public void insertRow(Member member) throws SQLException {
        getDao(Member.class).create(member);
    }

}

