package nyc.c4q;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;


public class LibraryActivity extends Activity {

    public TextView textDisplay;
    public EditText inputParameter;
    Book book;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        inputParameter = (EditText) findViewById(R.id.input_parameter);
        textDisplay = (TextView) findViewById(R.id.text_display);

        Gson gson = new Gson();
        book = gson.fromJson("books.json", Book.class);
        member = gson.fromJson("members.json", Member.class);



    }

    public void checkOut(int memberId, int bookId) {
        // TODO This method is called when the member with the given ID checks
        //      out the book with the given ID. Update the system accordingly.
        //      The due date for the book is two weeks from today.
    }

    public boolean checkIn(int memberId, int bookId) {
        // TODO This method is called when the member with the given ID returns
        //      the book with the given ID. Update the system accordingly. If
        //      the member is returning the book on time, return true. If it's
        //      late, return false.

        return false;
    }

    public void button_getMember_onClick(View view) {
        String name = inputParameter.getText().toString();

        // TODO Display member information for the member with the given name.

        textDisplay.setText(member.getMemberID() + "\n" + member.getMemberName() + "\n" + member.getMemberDOBmonth() + "/" + member.getMemberDOBday() + "/" + member.getMemberDOByear() + "\n" +
        member.getMemberCity() + ", " + member.getMemberState());

    }

    public void button_getBook_onClick(View view) {
        String isbn = inputParameter.getText().toString();

        // TODO Display book information for the book with the given ISBN.

        textDisplay.setText(book.getBookID() + "\n" + book.getBookTitle() + "\n" + book.getBookAuthor() + "\n" + book.getBookISBN() + "\n" + book.getBookISBN13() + "\n" + book.getBookPublisher() + "\n" + book.getBookPublishYear());


    }

    public void button_getCheckedOut_onClick(View view) {
        String name = inputParameter.getText().toString();

        // TODO Display a list of books that the member with the given name
        //      currently has checked out, ordered by due date, with the
        //      earliest due first.




    }

}
