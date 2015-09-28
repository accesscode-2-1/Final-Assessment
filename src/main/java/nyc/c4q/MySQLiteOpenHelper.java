package nyc.c4q;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;




/**
 * Created by Hoshiko on 8/30/15.
 */
public class MySQLiteOpenHelper extends OrmLiteSqliteOpenHelper {

    // TODO: Once JSON data from raw file is converted into ArrayList of Book/Member objects, create methods USING JSONHELPER.lass to interact objects with SQLite Database

    public static final String DATABASE_NAME = "mydb.db";
    public static final int DATABASE_VERSION = 2;

    private static MySQLiteOpenHelper mHelper;

    // PRIMARY KEY "INTEGER"
    private Dao<Member, Integer> memberDao = null;
    private Dao<Book, Integer> bookDao = null;

    private RuntimeExceptionDao<Member, Integer> simpleRuntimeDao = null;
    private RuntimeExceptionDao<Book, Integer> simpleRuntimeDao2 = null;

    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized MySQLiteOpenHelper getInstance(Context context) {
        if (mHelper == null) {
            mHelper = new MySQLiteOpenHelper(context.getApplicationContext());
        }

        return mHelper;
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Book.class);
            TableUtils.createTable(connectionSource, Member.class);
        } catch (SQLException e) {
            Log.e(MySQLiteOpenHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }

  // onUpgrade only updates the TABLE columns (not the entries)
    @Override
    public void onUpgrade(SQLiteDatabase db,ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource, Member.class, false);
            TableUtils.dropTable(connectionSource, Book.class, false);

        }catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        onCreate(db, connectionSource);

    }

    public Dao<Member, Integer> getMembeDao() {
        if (null == memberDao) {
            try {
                memberDao = getDao(Member.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return memberDao;
    }


    public void insertMemberData(int id, String name, int dobMonth, int dobDay, int dobYear, String city, String state) throws SQLException {

        Member member = new Member(id, name, dobMonth, dobDay, dobYear, city, state);
        Dao<Member, Integer> dao = null;
        try {
            dao = getDao(Member.class);
            dao.create(member);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }


    public Member loadMemberData(String name) throws SQLException, java.sql.SQLException {
        // queryForFirst() will return just ONE result object
        return getDao(Member.class).queryBuilder().where().eq("name", name).queryForFirst();
    }

    public List <Member> loadAllMember () throws java.sql.SQLException {
        // no where statement because getting ALL objects from row
        return getDao(Member.class).queryForAll();
    }

    public Dao<Book, Integer> getBookDao() {
        if (null == bookDao) {
            try {
                bookDao = getDao(Book.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return bookDao;
    }

    public void insertBookData(int id, String title, String author, String isbn,
                               String isbn13, String publisher, int publishyear) throws SQLException {

        Book book = new Book(id, title, author, isbn, isbn13, publisher, publishyear);
        Dao<Book, Integer> dao = null;
        try {
            dao = getDao(Book.class);
            dao.create(book);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertBookCheckedOutData(int id, String title, String author, String isbn,
                                         String isbn13, String publisher, int publishyear,
                                         Boolean checkedout, int checkedoutby, int checkoutdateyear,
                                         int checkoutdatemonth, int checkoutdateday, int duedateyear,
                                         int duedatemonth, int duedateday) throws SQLException {

        Book book = new Book(id, title, author, isbn, isbn13, publisher, publishyear, checkedout,
                checkedoutby, checkoutdateyear, checkoutdatemonth, checkoutdateday, duedateyear, duedatemonth, duedateday);
        Dao<Book, Integer> dao = null;
        try {
            dao = getDao(Book.class);
            dao.create(book);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }



    public Book loadBookData(String isbn) throws SQLException, java.sql.SQLException {
        return getDao(Book.class).queryBuilder().where().eq("isbn", isbn).queryForFirst();
    }

    public List <Book> loadAllBook () throws java.sql.SQLException {
        return getDao(Book.class).queryForAll();
    }

    public List <Book> loadCheckedOutBooks (String name) throws java.sql.SQLException {
        Member member = getDao(Member.class).queryBuilder().where().eq("name", name).queryForFirst();
        // once member object is accessed, go into row entry and retrieve member ID to access checked out books
        int memberId = member.getId();

        // .query() because not sure if the member borrowed more than 1 book
        return getDao(Book.class).queryBuilder().where().eq("checkedout", true).and().eq("checkedoutby", memberId).query();
    }

}