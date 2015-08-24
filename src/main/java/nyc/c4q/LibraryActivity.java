package nyc.c4q;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class LibraryActivity extends Activity {

    public EditText inputParameter;
    private TextView mTextViewDisplay;
    private DatabaseHelper mHelper;
    private boolean wasLate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        inputParameter = (EditText) findViewById(R.id.input_parameter);
        mTextViewDisplay = (TextView) findViewById(R.id.text_display);
    }

    public void checkOut(int memberId, int bookId) {
        // TODO This method is called when the member with the given ID checks
        //      out the book with the given ID. Update the system accordingly.
        //      The due date for the book is two weeks from today.

        new CheckOutTask().execute(memberId, bookId);


    }



    public void button_getMember_onClick(View view) {
        String name = inputParameter.getText().toString();
        new DatabaseMemberTask().execute(name);
        // TODO Display member information for the member with the given name.
    }

    public void button_getBook_onClick(View view) {
        String isbn = inputParameter.getText().toString();
        new DatabaseBookTask().execute(isbn);
        // TODO Display book information for the book with the given ISBN.
    }

    public void button_getCheckedOut_onClick(View view) {
        String name = inputParameter.getText().toString();
        new DatabaseCheckedOutTask().execute(name);
        // TODO Display a list of books that the member with the given name
        //      currently has checked out, ordered by due date, with the
        //      earliest due first.
    }

    public void button_getHistory_onClick(View view) {
        String name = inputParameter.getText().toString();
        new DatabaseHistory().execute(name);
        // TODO Display a list of books that the member with the given name
        //      has ever checked out, ordered by date, with the earliest
        //      book first. You do not need to display books that are currently
        //      checked out.

    }

    private class DatabaseMemberTask extends AsyncTask<String, Void, Member> {
        @Override
        protected Member doInBackground(String... params) {

            mHelper = DatabaseHelper.getInstance(getApplicationContext());

            if (mHelper.loadMemberData().size() == 0) {

                File file = new File("C:\\Users\\Luke\\Desktop\\Final-Assessment\\data\\members.json");
                try {
                    FileInputStream stream = new FileInputStream(file);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                    String line = "";
                    StringBuilder builder = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                    String json = builder.toString();
                    JSONArray array = new JSONArray(json);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject item = array.getJSONObject(i);
                        int id = item.getInt("id");
                        String name = item.getString("name");
                        int month = item.getInt("dob_month");
                        int day = item.getInt("dob_day");
                        int year = item.getInt("dob_year");
                        String city = item.getString("city");
                        String state = item.getString("state");
                        mHelper.insertMemberRow(id, name, month, day, year, city, state);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return mHelper.loadMember(params[0]);
        }

        @Override
        protected void onPostExecute(Member member) {
            mTextViewDisplay.setText("id: " + member.getId() + "\n"
             + "name: " + member.getName() + "\n"
             + "dob: " + member.getDob_month() + "/" + member.getDob_day() + "/" + member.getDob_year() + "\n"
             + "location: " + member.getCity() + ", " + member.getState());
        }
    }

    private class DatabaseBookTask extends AsyncTask<String, Void, Book> {
        @Override
        protected Book doInBackground(String... params) {
            mHelper = DatabaseHelper.getInstance(getApplicationContext());

            if (mHelper.loadBookData().size() == 0) {

                File file = new File("C:\\Users\\Luke\\Desktop\\Final-Assessment\\data\\books.json");
                try {
                    FileInputStream stream = new FileInputStream(file);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                    String line = "";
                    StringBuilder builder = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                    String json = builder.toString();
                    JSONArray array = new JSONArray(json);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject item = array.getJSONObject(i);
                        int id = item.getInt("id");
                        String title = item.getString("title");
                        String author = item.getString("author");
                        String isbn = item.getString("isbn");
                        String isbn13 = item.getString("isbn13");
                        String publisher = item.getString("publisher");
                        int publishyear = item.getInt("publishyear");

                        mHelper.insertBookRow(id, title, author, isbn, isbn13, publisher, publishyear);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return mHelper.loadBook(params[0]);
        }

        @Override
        protected void onPostExecute(Book book) {
            mTextViewDisplay.setText("id: " + book.getId() + "\n" +
                    "title: " + book.getTitle() + "\n" +
                    "author: " + book.getAuthor() + "\n" +
                    "isbn: " + book.getIsbn() + "\n" +
                    "isbn13: " + book.getIsbn13() + "\n" +
                    "publisher: " + book.getPublisher() + "\n" +
                    "publication year: " + book.getPublishyear());


        }
    }

    private class DatabaseCheckedOutTask extends AsyncTask<String, Void, List<CheckOutInfo>> {
        @Override
        protected List<CheckOutInfo> doInBackground(String... params) {
            mHelper = DatabaseHelper.getInstance(getApplicationContext());
            List<CheckOutInfo> result = new ArrayList<>();
            if (mHelper.loadAllCheckedOuts().size() == 0) {
                File file = new File("C:\\Users\\Luke\\Desktop\\Final-Assessment\\data\\checkouts.json");
                try {
                    FileInputStream stream = new FileInputStream(file);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                    String line = "";
                    StringBuilder builder = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                    String json = builder.toString();
                    JSONArray array = new JSONArray(json);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject item = array.getJSONObject(i);

                        int memberId = item.getInt("memberId");
                        int bookId = item.getInt("bookId");
                        int checkYear = item.getInt("checkoutDate_year");
                        int checkMonth = item.getInt("checkoutDate_month");
                        int checkDay = item.getInt("checkoutDate_day");
                        int dueYear = item.getInt("dueDate_year");
                        int dueMonth = item.getInt("dueDate_month");
                        int dueDay = item.getInt("dueDate_day");
                        Date checkDate = new Date(checkYear-1900, checkMonth-1, checkDay);
                        Date dueDate = new Date(dueYear-1900, dueMonth-1, dueDay);
                        mHelper.insertCheckedOutRow(memberId, bookId, checkDate, dueDate);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            List<CheckedOut> checkedOuts = mHelper.loadAllCheckedOuts();

            for (CheckedOut out : checkedOuts) {
                Member member = mHelper.loadMember(params[0]);
                if (out.getMemberId() == member.getId()) {
                    CheckOutInfo info = new CheckOutInfo();
                    info.setName(params[0]);
                    info.setTitle(mHelper.getBook(out.getBookId()).getTitle());
                    info.setAuthor(mHelper.getBook(out.getBookId()).getAuthor());

                    info.setCheckout(out.getCheckoutDate());
                    info.setDuedate(out.getDueDate());
                    result.add(info);
                }

            }



            Collections.sort(result, new Comparator<CheckOutInfo>() {
                @Override
                public int compare(CheckOutInfo lhs, CheckOutInfo rhs) {
                    return lhs.getDuedate().compareTo(rhs.getDuedate());
                }
            });
            return result;
        }

        @Override
        protected void onPostExecute(List<CheckOutInfo> checkOutInfos) {
            SimpleDateFormat format = new SimpleDateFormat("M/d/y");
            mTextViewDisplay.setText("name: " + checkOutInfos.get(0).getName() + "\n");
            for (CheckOutInfo info : checkOutInfos) {
                mTextViewDisplay.append("-----\n");
                mTextViewDisplay.append("title: " + info.getTitle() + "\n");
                mTextViewDisplay.append("author: " + info.getAuthor() + "\n");
                mTextViewDisplay.append("checkout date: " + format.format(info.getCheckout()) + "\n");
                mTextViewDisplay.append("due date: " + format.format(info.getDuedate()) + "\n");
            }

        }
    }

    private class CheckOutTask extends AsyncTask<Integer, Void, CheckOutInfo> {
        @Override
        protected CheckOutInfo doInBackground(Integer... params) {

            int memberId = params[0];
            int bookId = params[1];

            mHelper = DatabaseHelper.getInstance(getApplicationContext());

            CheckOutInfo info = new CheckOutInfo();
            info.setName(mHelper.getMember(memberId).getName());
            info.setTitle(mHelper.getBook(bookId).getTitle());

            Calendar calendar = Calendar.getInstance();
            Date today = new Date(calendar.get(Calendar.YEAR)-1900, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            info.setCheckout(today);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.add(Calendar.DATE, 14);
            Date due = new Date(calendar1.get(Calendar.YEAR)-1900, calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH));
            info.setDuedate(due);


            mHelper.insertCheckedOutRow(memberId, bookId, today, due);


            return info;


        }

        @Override
        protected void onPostExecute(CheckOutInfo checkOutInfo) {
            SimpleDateFormat format = new SimpleDateFormat("M/d/y");

            mTextViewDisplay.setText("name: " + checkOutInfo.getName() + "\n" +
            "-----\n" + "title: " + checkOutInfo.getTitle() + "\n" +
            "author: " + checkOutInfo.getAuthor() + "\n" +
            "checkout date: " +  format.format(checkOutInfo.getCheckout()) + "\n" +
            "due date: " +  format.format(checkOutInfo.getDuedate()) + "\n");
        }
    }

    private class DatabaseHistory extends AsyncTask<String, Void, List<HistoryInfo>> {
        @Override
        protected List<HistoryInfo> doInBackground(String... params) {
            mHelper = DatabaseHelper.getInstance(getApplicationContext());

            if (mHelper.loadAllHistory().size() == 0) {
                File file = new File("C:\\Users\\Luke\\Desktop\\Final-Assessment\\data\\history.json");
                try {
                    FileInputStream stream = new FileInputStream(file);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                    String line = "";
                    StringBuilder builder = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                    String json = builder.toString();
                    JSONArray array = new JSONArray(json);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject item = array.getJSONObject(i);

                        int memberId = item.getInt("memberId");
                        int bookId = item.getInt("bookId");
                        int checkYear = item.getInt("checkoutDate_year");
                        int checkMonth = item.getInt("checkoutDate_month");
                        int checkDay = item.getInt("checkoutDate_day");
                        int returnYear = item.getInt("returnDate_year");
                        int returnMonth = item.getInt("returnDate_month");
                        int returnDay = item.getInt("returnDate_day");
                        boolean wasLate = item.getBoolean("wasLate");
                        Date checkDate = new Date(checkYear-1900, checkMonth-1, checkDay);
                        Date returnDate = new Date(returnYear-1900, returnMonth-1, returnDay);
                        mHelper.insertHistoryRow(memberId, bookId, checkDate, returnDate, wasLate);
                    }


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return mHelper.loadMemberHistory(params[0]);
        }

        @Override
        protected void onPostExecute(List<HistoryInfo> infos) {
            SimpleDateFormat format = new SimpleDateFormat("M/d/y");
            mTextViewDisplay.setText("name: " + infos.get(0).getName() + "\n");
            for (HistoryInfo info : infos) {
                mTextViewDisplay.append("-----\n");
                mTextViewDisplay.append("title: " + info.getTitle() + "\n");
                mTextViewDisplay.append("author: " + info.getAuthor() + "\n");
                mTextViewDisplay.append("checkout date: " + format.format(info.getCheckoutDate()) + "\n");
                mTextViewDisplay.append("return date: " + format.format(info.getReturnDate()) + "\n");
            }

        }
    }

    public boolean checkIn(int memberId, int bookId) {
        // TODO This method is called when the member with the given ID returns
        //      the book with the given ID. Update the system accordingly. If
        //      the member is returning the book on time, return true. If it's
        //      late, return false.

        new CheckInTask().execute(memberId, bookId);

        return wasLate;
    }

    private class CheckInTask extends AsyncTask<Integer, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Integer... params) {

            int memberId = params[0];
            int bookId = params[1];

            mHelper = DatabaseHelper.getInstance(getApplicationContext());

            History history = mHelper.deleteCheckedOutRow(memberId, bookId);
            if (history != null) {
                mHelper.insertHistoryRow(history);
                return history.isWasLate();
            }




           return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            wasLate = !aBoolean;
        }
    }
}
