package nyc.c4q;

import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import org.assertj.android.api.Assertions;
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
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class Part1PaceCalculatorTests {

    private PaceCalculatorActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(PaceCalculatorActivity.class).setup().get();
    }

    @Test
    public void test01CheckChildIsLinearLayout() {
        FrameLayout frame = (FrameLayout) Helpers.findViewByIdString(
                activity, "activity_pace_calculator");

        assertThat(frame, notNullValue());
        assertThat(frame.getChildCount(), equalTo(1));
        assertThat(frame.getChildAt(0), instanceOf(LinearLayout.class));
    }

    @Test
    public void test02CheckDistanceCalculation() {
        EditText inputDistance   = (EditText) Helpers.findViewByIdString(activity, "input_distance");
        EditText inputTimeMin    = (EditText) Helpers.findViewByIdString(activity, "input_time_min");
        EditText inputTimeSec    = (EditText) Helpers.findViewByIdString(activity, "input_time_sec");
        EditText inputPaceMin    = (EditText) Helpers.findViewByIdString(activity, "input_pace_min");
        EditText inputPaceSec    = (EditText) Helpers.findViewByIdString(activity, "input_pace_sec");
        Button   buttonCalculate = (Button)   Helpers.findViewByIdString(activity, "button_calculate");

        assertThat(inputDistance,   notNullValue());
        assertThat(inputTimeMin,    notNullValue());
        assertThat(inputTimeSec,    notNullValue());
        assertThat(inputPaceMin,    notNullValue());
        assertThat(inputPaceSec,    notNullValue());
        assertThat(buttonCalculate, notNullValue());

        inputTimeMin.setText("40");
        inputTimeSec.setText("00");
        inputPaceMin.setText("8");
        inputPaceSec.setText("20");

        buttonCalculate.callOnClick();

        Assertions.assertThat(inputDistance).containsText("4.8");
    }

    @Test
    public void test03CheckTimeCalculation() {
        EditText inputDistance   = (EditText) Helpers.findViewByIdString(activity, "input_distance");
        EditText inputTimeMin    = (EditText) Helpers.findViewByIdString(activity, "input_time_min");
        EditText inputTimeSec    = (EditText) Helpers.findViewByIdString(activity, "input_time_sec");
        EditText inputPaceMin    = (EditText) Helpers.findViewByIdString(activity, "input_pace_min");
        EditText inputPaceSec    = (EditText) Helpers.findViewByIdString(activity, "input_pace_sec");
        Button   buttonCalculate = (Button)   Helpers.findViewByIdString(activity, "button_calculate");

        assertThat(inputDistance,   notNullValue());
        assertThat(inputTimeMin,    notNullValue());
        assertThat(inputTimeSec,    notNullValue());
        assertThat(inputPaceMin,    notNullValue());
        assertThat(inputPaceSec,    notNullValue());
        assertThat(buttonCalculate, notNullValue());

        inputDistance.setText("13.1");
        inputPaceMin.setText("8");
        inputPaceSec.setText("20");

        buttonCalculate.callOnClick();

        Assertions.assertThat(inputTimeMin).containsText("109");
        Assertions.assertThat(inputTimeMin).containsText("10");
    }

    @Test
    public void test04CheckPaceCalculation() {
        EditText inputDistance   = (EditText) Helpers.findViewByIdString(activity, "input_distance");
        EditText inputTimeMin    = (EditText) Helpers.findViewByIdString(activity, "input_time_min");
        EditText inputTimeSec    = (EditText) Helpers.findViewByIdString(activity, "input_time_sec");
        EditText inputPaceMin    = (EditText) Helpers.findViewByIdString(activity, "input_pace_min");
        EditText inputPaceSec    = (EditText) Helpers.findViewByIdString(activity, "input_pace_sec");
        Button   buttonCalculate = (Button)   Helpers.findViewByIdString(activity, "button_calculate");

        assertThat(inputDistance,   notNullValue());
        assertThat(inputTimeMin,    notNullValue());
        assertThat(inputTimeSec,    notNullValue());
        assertThat(inputPaceMin,    notNullValue());
        assertThat(inputPaceSec,    notNullValue());
        assertThat(buttonCalculate, notNullValue());

        inputDistance.setText("3.1");
        inputTimeMin.setText("23");
        inputTimeSec.setText("22");

        buttonCalculate.callOnClick();

        Assertions.assertThat(inputPaceMin).containsText("7");
        Assertions.assertThat(inputPaceSec).containsText("32");
    }

    @Test
    public void test05CheckInvalidDistance() {
        EditText inputDistance   = (EditText) Helpers.findViewByIdString(activity, "input_distance");
        EditText inputTimeMin    = (EditText) Helpers.findViewByIdString(activity, "input_time_min");
        EditText inputTimeSec    = (EditText) Helpers.findViewByIdString(activity, "input_time_sec");
        EditText inputPaceMin    = (EditText) Helpers.findViewByIdString(activity, "input_pace_min");
        EditText inputPaceSec    = (EditText) Helpers.findViewByIdString(activity, "input_pace_sec");
        Button   buttonCalculate = (Button)   Helpers.findViewByIdString(activity, "button_calculate");

        assertThat(inputDistance,   notNullValue());
        assertThat(inputTimeMin,    notNullValue());
        assertThat(inputTimeSec,    notNullValue());
        assertThat(inputPaceMin,    notNullValue());
        assertThat(inputPaceSec,    notNullValue());
        assertThat(buttonCalculate, notNullValue());

        inputDistance.setText("LOL");
        inputTimeMin.setText("23");
        inputTimeSec.setText("22");

        buttonCalculate.callOnClick();

        Assertions.assertThat(inputPaceMin).containsText("");
        Assertions.assertThat(inputPaceSec).containsText("");
    }

    @Test
    public void test06CheckNoInput() {
        EditText inputDistance   = (EditText) Helpers.findViewByIdString(activity, "input_distance");
        EditText inputTimeMin    = (EditText) Helpers.findViewByIdString(activity, "input_time_min");
        EditText inputTimeSec    = (EditText) Helpers.findViewByIdString(activity, "input_time_sec");
        EditText inputPaceMin    = (EditText) Helpers.findViewByIdString(activity, "input_pace_min");
        EditText inputPaceSec    = (EditText) Helpers.findViewByIdString(activity, "input_pace_sec");
        Button   buttonCalculate = (Button)   Helpers.findViewByIdString(activity, "button_calculate");

        assertThat(inputDistance,   notNullValue());
        assertThat(inputTimeMin,    notNullValue());
        assertThat(inputTimeSec,    notNullValue());
        assertThat(inputPaceMin,    notNullValue());
        assertThat(inputPaceSec,    notNullValue());
        assertThat(buttonCalculate, notNullValue());

        buttonCalculate.callOnClick();

        Assertions.assertThat(inputDistance).containsText("");
        Assertions.assertThat(inputTimeMin).containsText("");
        Assertions.assertThat(inputTimeSec).containsText("");
        Assertions.assertThat(inputPaceMin).containsText("");
        Assertions.assertThat(inputPaceSec).containsText("");
    }
}
