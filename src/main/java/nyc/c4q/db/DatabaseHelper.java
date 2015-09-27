package nyc.c4q.db;

import android.accounts.Account;
import android.app.DownloadManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q-anthonyf on 8/30/15.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private final static int VERSION = 1;
    private final static String MYDB = "MyDb";

    private static DatabaseHelper mHelper;
    private Dao<Member, String> memberDao;
    private Dao<Book, Integer> bookDao;

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

    public Dao<Member,String> getMemberDao() throws SQLException{
        if(memberDao == null){
            memberDao = getDao(Member.class);
        }
        return memberDao;
    }

    public Dao<Book, Integer> getBookDao() throws SQLException{
        if(bookDao == null){
            bookDao = getDao(Book.class);
        }
        return bookDao;
    }

    public List<Book> loadSpecificBook(int id) throws SQLException {
        Log.d("DB SEARCH", "ISBN: "+ id);
        bookDao = getBookDao();
        QueryBuilder<Book, Integer> queryBuilder = bookDao.queryBuilder();
        queryBuilder.where().eq(Book.ID, id);
        PreparedQuery<Book> preparedQuery = queryBuilder.prepare();

        Log.d("Book Search", "Complete");

        return bookDao.query(preparedQuery);
    }

    public void insertRow(Book book) throws SQLException {
        getDao(Book.class).create(book);
    }

    public List<Book> loadAllBooks() throws SQLException {
        return getDao(Book.class).queryForAll();
    }

    public List<Member> loadSpecificMember(String name) throws SQLException {
        Log.d("DB SEARCH", "Member: "+ name);

        memberDao = getMemberDao();
        QueryBuilder<Member, String> queryBuilder = memberDao.queryBuilder();
        queryBuilder.where().eq(Member.NAME, name);
        PreparedQuery<Member> preparedQuery = queryBuilder.prepare();

        Log.d("Member Search", "Complete");
        return memberDao.query(preparedQuery);
    }

    public void insertRow(Member member) throws SQLException {
        getDao(Member.class).create(member);
    }

    public List<Member> loadAllMembers() throws SQLException {
        return getDao(Member.class).queryForAll();
    }

}

