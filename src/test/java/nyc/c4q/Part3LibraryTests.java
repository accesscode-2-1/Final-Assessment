package nyc.c4q;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class Part3LibraryTests {

    private LibraryActivity activity;
    private EditText input;
    private TextView display;
    private Button buttonMemberInfo;
    private Button buttonBookInfo;
    private Button buttonCheckedOut;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(LibraryActivity.class).setup().get();

        input   = (EditText) Helpers.findViewByIdString(activity, "input_parameter");
        display = (TextView) Helpers.findViewByIdString(activity, "text_display");

        buttonMemberInfo = (Button) Helpers.findViewByIdString(activity, "button_getMember");
        buttonBookInfo   = (Button) Helpers.findViewByIdString(activity, "button_getBook");
        buttonCheckedOut = (Button) Helpers.findViewByIdString(activity, "button_getCheckedOut");
    }

    @Test
    public void test11CheckMemberInfoQuery() {
        assertThat(input, notNullValue());
        assertThat(display, notNullValue());
        assertThat(buttonMemberInfo, notNullValue());

        input.setText("Richard Nixon");
        buttonMemberInfo.callOnClick();

        Assertions.assertThat(display).containsText(
            "id: 36\n" +
            "name: Richard Nixon\n" +
            "dob: 1/9/1913\n" +
            "location: Yorba Linda, California"
        );
    }

    @Test
    public void test12CheckBookInfoQuery() {
        assertThat(input, notNullValue());
        assertThat(display, notNullValue());
        assertThat(buttonBookInfo, notNullValue());

        input.setText("1554681723");
        buttonBookInfo.callOnClick();

        Assertions.assertThat(display).containsText(
            "id: 54\n" +
            "title: The Art of Racing in the Rain\n" +
            "author: Garth Stein\n" +
            "isbn: 1554681723\n" +
            "isbn13: 9781554681723\n" +
            "publisher: Harper Collins\n" +
            "publication year: 2008"
        );
    }

    @Test
    public void test13CheckCheckedOutQuery() {
        assertThat(input, notNullValue());
        assertThat(display, notNullValue());
        assertThat(buttonCheckedOut, notNullValue());

        input.setText("Millard Fillmore");
        buttonCheckedOut.callOnClick();

        Assertions.assertThat(display).containsText(
            "name: Millard Fillmore\n" +
            "-----\n" +
            "title: The Tiger's Wife\n" +
            "author: Téa Obreht\n" +
            "checkout date: 8/11/2015\n" +
            "due date: 8/25/2015\n" +
            "-----\n" +
            "title: Shadows in Flight (Ender's Shadow, #5)\n" +
            "author: Orson Scott Card\n" +
            "checkout date: 8/19/2015\n" +
            "due date: 9/2/2015"
        );
    }

    @Test
    public void test14CheckCheckoutFunctionality() {
        activity.checkOut(43, 17);

        assertThat(input, notNullValue());
        assertThat(display, notNullValue());
        assertThat(buttonCheckedOut, notNullValue());

        input.setText("Barack Obama");
        buttonCheckedOut.callOnClick();

        SimpleDateFormat format = new SimpleDateFormat("M/d/y");
        Calendar calendar = Calendar.getInstance();
        String today = format.format(calendar.getTime());
        calendar.add(Calendar.DATE, 14);
        String dueDate = format.format(calendar.getTime());

        Assertions.assertThat(display).containsText(
            "name: Barack Obama\n" +
            "-----\n" +
            "title: Gone Girl\n" +
            "author: Gillian Flynn\n" +
            "checkout date: " + today + "\n" +
            "due date: " + dueDate
        );
    }

    @Test
    public void test15CheckCheckinFunctionality() {
        activity.checkIn(43, 17);

        assertThat(input, notNullValue());
        assertThat(display, notNullValue());
        assertThat(buttonCheckedOut, notNullValue());

        input.setText("Barack Obama");
        buttonCheckedOut.callOnClick();

        Assertions.assertThat(display).containsText(
            "name: Barack Obama"
        );
    }

}
