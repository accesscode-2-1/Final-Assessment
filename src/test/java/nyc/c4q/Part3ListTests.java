package nyc.c4q;

import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class Part3ListTests {

    private ListActivity activity;
    private ListView list;
    private Adapter adapter;
    private Button buttonName;
    private Button buttonColor;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(ListActivity.class).setup().get();
        
        list = (ListView) Helpers.findViewByIdString(activity, "list");
        adapter = list.getAdapter();
        assertThat(adapter, notNullValue());

        buttonName  = (Button) Helpers.findViewByIdString(activity, "button_name");
        buttonColor = (Button) Helpers.findViewByIdString(activity, "button_color");
    }

    @Test
    public void test11CheckListCount() {
        assertThat(adapter.getCount(), equalTo(28));
    }

    @Test
    public void test12CheckOrderLastFirst() {
        assertThat(buttonName.getText(), equalTo("Last, First"));
        
        assertThat(0,  equalTo("Abbott, Hannah"));
        assertThat(5,  equalTo("Chang, Cho"));
        assertThat(12, equalTo("Granger, Hermione"));
        assertThat(16, equalTo("Lovegood, Luna"));
        assertThat(26, equalTo("Weasley, Ginny"));
    }

    @Test
    public void test13CheckOrderFirstLast() {
        buttonName.callOnClick();
        assertThat(buttonName.getText(), equalTo("First Last"));
        
        assertThat(0,  equalTo("Alicia Spinnet"));
        assertThat(9,  equalTo("Ginny Weasley"));
        assertThat(14,  equalTo("Katie Bell"));
        assertThat(21,  equalTo("Padma Patil"));
        assertThat(25,  equalTo("Susan Bones"));
    }
}
