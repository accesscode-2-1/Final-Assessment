package nyc.c4q;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by Luke on 8/24/2015.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String MYDB = "mydb.db";
    private static final int VERSION = 10;

    private static DatabaseHelper mHelper;

    public static synchronized  DatabaseHelper getInstance(Context context) {
        if (mHelper == null) {
            mHelper = new DatabaseHelper(context.getApplicationContext());
        }
        return mHelper;
    }

    public DatabaseHelper(Context context) {
        super(context, MYDB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Member.class);
            TableUtils.createTable(connectionSource, Book.class);
            TableUtils.createTable(connectionSource, CheckedOut.class);
            TableUtils.createTable(connectionSource, History.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource, Member.class, true);
            TableUtils.dropTable(connectionSource, Book.class, true);
            TableUtils.dropTable(connectionSource, CheckedOut.class, true);
            TableUtils.dropTable(connectionSource, History.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertMemberRow(int id, String name, int dob_month, int dob_day, int dob_year, String city, String state) {
        Member member = new Member(id, name, dob_month, dob_day, dob_year, city, state);
        try {
            getDao(Member.class).create(member);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBookRow(int id, String title, String author, String isbn, String isbn13, String publisher, int publishyear) {
        Book book = new Book(id, title, author, isbn, isbn13, publisher, publishyear);
        try {
            getDao(Book.class).create(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCheckedOutRow(int memberId, int bookId, Date checkoutDate, Date dueDate) {
        CheckedOut checkedOut = new CheckedOut(memberId, bookId, checkoutDate, dueDate);
        try {
            getDao(CheckedOut.class).create(checkedOut);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public History deleteCheckedOutRow(int memberId, int bookId) {
        CheckedOut out = getCheckedOut(memberId, bookId);

        if (out != null) {
            try {
                History history = new History();
                //getDao(CheckedOut.class).deleteBuilder().where().eq("memberId", memberId).and().eq("bookId", bookId).queryForFirst();
                getDao(CheckedOut.class).delete(out);
                history.setMemberId(memberId);
                history.setBookId(bookId);
                history.setCheckoutDate(out.getCheckoutDate());
                Calendar calendar = Calendar.getInstance();
                Date today = new Date(calendar.get(Calendar.YEAR)-1900, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                history.setReturnDate(today);
                history.setWasLate(today.after(out.getDueDate()));
                return history;

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public CheckedOut getCheckedOut(int memberId, int bookId) {
        try {
            return getDao(CheckedOut.class).queryBuilder().where().eq("memberId", memberId).and().eq("bookId", bookId).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertHistoryRow(int memberId, int bookId, Date checkoutDate, Date returnDate, boolean wasLate) {
        History history = new History(memberId, bookId, checkoutDate, returnDate, wasLate);
        try {
            getDao(History.class).create(history);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertHistoryRow(History history) {
        try {
            getDao(History.class).create(history);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Member loadMember(String name) {
        try {
            Member member = getDao(Member.class).queryBuilder().where().eq("name", name).queryForFirst();
            return member;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Book loadBook(String isbn) {
        try {
            if (isbn.length() == 10) {
                return getDao(Book.class).queryBuilder().where().eq("isbn", isbn).queryForFirst();
            } else if (isbn.length() == 13) {
                return getDao(Book.class).queryBuilder().where().eq("isbn13", isbn).queryForFirst();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Book getBook(int bookId) {
        try {
            return getDao(Book.class).queryBuilder().where().eq("id", bookId).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CheckedOut> loadCheckOuts(String name) {
        int memberId = loadMember(name).getId();
        try {
            return getDao(CheckedOut.class).queryBuilder().where().eq("memberId", memberId).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Member> loadMemberData() {
        try {
            return getDao(Member.class).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Member getMember(int memberId) {
        try {
            return getDao(Member.class).queryBuilder().where().eq("id", memberId).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> loadBookData() {
        try {
            return getDao(Book.class).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CheckedOut> loadAllCheckedOuts() {
        try {
            return getDao(CheckedOut.class).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<History> loadAllHistory() {
        try {
            return getDao(History.class).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HistoryInfo> loadMemberHistory(String name) {
        List<HistoryInfo> result = new ArrayList<>();
        List<History> all = loadAllHistory();
        int memberId = loadMember(name).getId();
        for (History history : all) {
            if (history.getMemberId() == memberId) {

                HistoryInfo info = new HistoryInfo();

                info.setName(name);
                info.setTitle(mHelper.getBook(history.getBookId()).getTitle());
                info.setAuthor(mHelper.getBook(history.getBookId()).getAuthor());
                info.setCheckoutDate(history.getCheckoutDate());
                info.setReturnDate(history.getReturnDate());

                result.add(info);
            }
        }

        Collections.sort(result, new Comparator<HistoryInfo>() {
            @Override
            public int compare(HistoryInfo lhs, HistoryInfo rhs) {
                return lhs.getCheckoutDate().compareTo(rhs.getCheckoutDate());
            }
        });
        return result;
    }



}
