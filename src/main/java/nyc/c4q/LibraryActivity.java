package nyc.c4q;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LibraryActivity extends Activity {

    public EditText inputParameter;
    private TextView display;
    private Button buttonMemberInfo;
    private Button buttonBookInfo;
    private Button buttonCheckedOut;


    private static final String TAG = LibraryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        inputParameter = (EditText) findViewById(R.id.input_parameter);
        display = (TextView) findViewById(R.id.text_display);
        buttonMemberInfo = (Button) findViewById(R.id.button_getMember);
        buttonBookInfo = (Button) findViewById(R.id.button_getBook);
        buttonCheckedOut = (Button) findViewById(R.id.button_getCheckedOut);

//   //  MemberInfo memberInfo = JSONHelperVerison.loadStaticMemberJsonRawUsingGson(this, R.raw.members);
//     // Log.d(TAG, "membersJSON:\n" + memberInfo);
//
//     String memberResponse = JSONHelperVerison.convertToJsonUsingGson(memberInfo);
//      Log.d(TAG, "membersjson:" + memberResponse);
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
    }

    public void button_getBook_onClick(View view) {
        String isbn = inputParameter.getText().toString();

        // TODO Display book information for the book with the given ISBN.
    }

    public void button_getCheckedOut_onClick(View view) {
        String name = inputParameter.getText().toString();

        // TODO Display a list of books that the member with the given name
        //      currently has checked out, ordered by due date, with the
        //      earliest due first.
    }









}
