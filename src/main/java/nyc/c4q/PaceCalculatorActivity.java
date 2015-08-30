package nyc.c4q;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaceCalculatorActivity extends FragmentActivity {
    private double inputDistance;
    private int inputTimeMin;
    private int inputTimeSec;
    private int inputPaceMin;
    private int inputPaceSec;

    @Bind(R.id.input_distance)
    EditText etDistance;
    @Bind(R.id.input_time_min)
    EditText etTimeMin;
    @Bind(R.id.input_time_sec)
    EditText etTimeSec;
    @Bind(R.id.input_pace_min)
    EditText etPaceMin;
    @Bind(R.id.input_pace_sec)
    EditText etPaceSec;
    @Bind(R.id.button_calculate)
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        ButterKnife.bind(this);

        // get fragment manager
        FragmentManager fm = getFragmentManager();

        // fragment add
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_pace_calculator, new Fragment());
        ft.commit();

        // todo: fix fragment, calculate
    }

    @OnClick(R.id.button_calculate)
    public void calculate(View view) {

        // get values from edittexts
        String distanceStr = etDistance.getText().toString();
        String timeMinStr = etTimeMin.getText().toString();
        String timeSecStr = etTimeSec.getText().toString();
        String paceMinStr = etPaceMin.getText().toString();
        String paceSecStr = etPaceSec.getText().toString();

        validateInput(distanceStr, timeMinStr, timeSecStr, paceMinStr, paceSecStr);

        // if distance + time
//        if ((!distanceStr.isEmpty()) && (!timeStr.isEmpty()) {
//            // calc
//        }

        // if time + pace

        // if pace + distance

    }

    private void validateInput(String distanceStr,
                               String timeMinStr,
                               String timeSecStr,
                               String paceMinStr,
                               String paceSecStr) {

        String decimal = ".";
        String timeStr = timeMinStr += decimal += timeSecStr;
        String paceStr = paceMinStr += decimal += paceSecStr;

        checkIfInputValid(distanceStr, timeStr, paceStr);
        checkIfNoInputsEmpty(distanceStr, timeStr, paceStr);
        checkIfTwoInputsEmpty(distanceStr, timeStr, paceStr);
        checkIfAllInputsEmpty(distanceStr, timeStr, paceStr);
    }

    private void checkIfInputValid(String distanceStr, String timeStr, String paceStr) {
        ArrayList<String> input = new ArrayList<>();
        input.add(distanceStr);
        input.add(timeStr);
        input.add(paceStr);

        // iterate and verify whether input is in numeric characters only. ignore decimal.
//        for (String field : input) {
//            if (field.isNumeric) {
//                // continue
//            }
//        }
    }

    private void checkIfNoInputsEmpty(String distanceStr, String timeStr, String paceStr) {
        // if all have data specified...
        if ((!distanceStr.isEmpty()) &&
                (!timeStr.isEmpty()) &&
                (!paceStr.isEmpty())) {
            // do nothing
        }
    }

    private void checkIfTwoInputsEmpty(String distanceStr, String timeStr, String paceStr) {
        // if one has data specified...not the fastest way to check.
        if ((!distanceStr.isEmpty()) &&
                (timeStr.isEmpty()) &&
                (paceStr.isEmpty())) {
            // do nothing
        }

        if ((distanceStr.isEmpty()) &&
                (!timeStr.isEmpty()) &&
                (paceStr.isEmpty())) {
            // do nothing
        }

        if ((distanceStr.isEmpty()) &&
                (timeStr.isEmpty()) &&
                (!paceStr.isEmpty())) {
            // do nothing
        }
    }

    private void checkIfAllInputsEmpty(String distanceStr, String timeStr, String paceStr) {
        // if none have data specified...
        if ((distanceStr.isEmpty()) &&
                (timeStr.isEmpty()) &&
                (paceStr.isEmpty())) {
            // do nothing
        }
    }

}
