package nyc.c4q;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class Part2ListTests {

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
    public void test06CheckListCount() {
        assertThat(adapter.getCount(), equalTo(28));
    }

    @Test
    public void test07CheckOrderLastFirst() {
        assertThat(buttonName.getText().toString(), equalTo("Last, First"));

        TextView textName  = (TextView) Helpers.findViewInList(activity, list, 0, "text_name");
        TextView textHouse = (TextView) Helpers.findViewInList(activity, list, 0, "text_house");
        assertThat(textName.getText().toString(),  equalTo("Abbott, Hannah"));
        assertThat(textHouse.getText().toString(), equalTo("Hufflepuff"));

        textName  = (TextView) Helpers.findViewInList(activity, list, 5, "text_name");
        textHouse = (TextView) Helpers.findViewInList(activity, list, 5, "text_house");
        assertThat(textName.getText().toString(),  equalTo("Chang, Cho"));
        assertThat(textHouse.getText().toString(), equalTo("Ravenclaw"));

        textName  = (TextView) Helpers.findViewInList(activity, list, 12, "text_name");
        textHouse = (TextView) Helpers.findViewInList(activity, list, 12, "text_house");
        assertThat(textName.getText().toString(), equalTo("Granger, Hermione"));
        assertThat(textHouse.getText().toString(), equalTo("Gryffindor"));

        textName  = (TextView) Helpers.findViewInList(activity, list, 16, "text_name");
        textHouse = (TextView) Helpers.findViewInList(activity, list, 16, "text_house");
        assertThat(textName.getText().toString(), equalTo("Lovegood, Luna"));
        assertThat(textHouse.getText().toString(), equalTo("Ravenclaw"));

        textName  = (TextView) Helpers.findViewInList(activity, list, 26, "text_name");
        textHouse = (TextView) Helpers.findViewInList(activity, list, 26, "text_house");
        assertThat(textName.getText().toString(), equalTo("Weasley, Ginny"));
        assertThat(textHouse.getText().toString(), equalTo("Gryffindor"));
    }

    @Test
    public void test08CheckOrderFirstLast() {
        buttonName.callOnClick();
        assertThat(buttonName.getText().toString(), equalTo("First Last"));

        TextView textName  = (TextView) Helpers.findViewInList(activity, list, 0, "text_name");
        TextView textHouse = (TextView) Helpers.findViewInList(activity, list, 0, "text_house");
        assertThat(textName.getText().toString(),  equalTo("Alicia Spinnet"));
        assertThat(textHouse.getText().toString(), equalTo("Gryffindor"));

        textName  = (TextView) Helpers.findViewInList(activity, list, 9, "text_name");
        textHouse = (TextView) Helpers.findViewInList(activity, list, 9, "text_house");
        assertThat(textName.getText().toString(),  equalTo("Ginny Weasley"));
        assertThat(textHouse.getText().toString(), equalTo("Gryffindor"));

        textName  = (TextView) Helpers.findViewInList(activity, list, 14, "text_name");
        textHouse = (TextView) Helpers.findViewInList(activity, list, 14, "text_house");
        assertThat(textName.getText().toString(),  equalTo("Katie Bell"));
        assertThat(textHouse.getText().toString(), equalTo("Gryffindor"));

        textName  = (TextView) Helpers.findViewInList(activity, list, 21, "text_name");
        textHouse = (TextView) Helpers.findViewInList(activity, list, 21, "text_house");
        assertThat(textName.getText().toString(),  equalTo("Padma Patil"));
        assertThat(textHouse.getText().toString(), equalTo("Ravenclaw"));

        textName  = (TextView) Helpers.findViewInList(activity, list, 25, "text_name");
        textHouse = (TextView) Helpers.findViewInList(activity, list, 25, "text_house");
        assertThat(textName.getText().toString(),  equalTo("Susan Bones"));
        assertThat(textHouse.getText().toString(), equalTo("Hufflepuff"));
    }

    /*
    @Test
    public void test09CheckColorHidden() {
        assertThat(buttonColor.getText().toString(), equalTo("Show Color"));

        View view = Helpers.getViewInList(list, 0);
        assertThat(view.getBackground(), instanceOf(ColorDrawable.class));
        assertThat(((ColorDrawable) view.getBackground()).getColor(),
                equalTo(activity.getResources().getColor(R.color.gryffindor_red)));
    }
    */

    @Test
    public void test10CheckColorShown() {
        buttonColor.callOnClick();
        assertThat(buttonColor.getText().toString(), equalTo("Hide Color"));

        final Map<String, Integer> HOUSE_COLORS = new TreeMap<>();
        HOUSE_COLORS.put("Gryffindor", R.color.gryffindor_red);
        HOUSE_COLORS.put("Ravenclaw",  R.color.ravenclaw_blue);
        HOUSE_COLORS.put("Hufflepuff", R.color.hufflepuff_yellow);
        HOUSE_COLORS.put("Slytherin",  R.color.slytherin_green);

        for (int i = 0, length = list.getAdapter().getCount(); i < length; ++i) {
            View view = Helpers.getViewInList(list, i);
            String house = ((TextView) Helpers.findViewInList(activity, list, i, "text_house"))
                    .getText().toString();
            assertThat(view.getBackground(), instanceOf(ColorDrawable.class));
            assertThat(((ColorDrawable) view.getBackground()).getColor(),
                    equalTo(activity.getResources().getColor(HOUSE_COLORS.get(house))));
        }
    }

}
