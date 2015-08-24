package nyc.c4q;

import android.widget.Adapter;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class Part3MemberTests {

    private MembersActivity activity;
    private ListView list;
    private Adapter adapter;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MembersActivity.class).setup().get();
        list = (ListView) Helpers.findViewByIdString(activity, "list");
        adapter = list.getAdapter();
    }

    @Test
    public void test12CheckUsingCursorAdapter() {
        assertThat(adapter, notNullValue());
        assertThat(adapter, instanceOf(CursorAdapter.class));
    }

    @Test
    public void test13CheckListCount() {
        assertThat(adapter, notNullValue());
        assertThat(adapter.getCount(), equalTo(44));
    }
}
