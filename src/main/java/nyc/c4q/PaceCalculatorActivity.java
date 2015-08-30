package nyc.c4q;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class PaceCalculatorActivity extends FragmentActivity {
    private double inputDistance;
    private int inputTimeMin;
    private int inputTimeSec;
    private int inputPaceMin;
    private int inputPaceSec;

    private String distanceStr;
    private String timeStr;
    private String paceStr;

    private String timeMinStr;
    private String timeSecStr;
    private String paceMinStr;
    private String paceSecStr;

    private EditText etDistance;
    private EditText etTimeMin;
    private EditText etTimeSec;
    private EditText etPaceMin;
    private EditText etPaceSec;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        initViews();

        // get fragment manager
        FragmentManager fm = getFragmentManager();

        CalcFragment calcFrag = new CalcFragment();

        // fragment add
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_pace_calculator, calcFrag);
        ft.commit();

        // todo: fix fragment, calculate
    }

    private void initViews() {
        etDistance = (EditText) findViewById(R.id.input_distance);
        etTimeMin = (EditText) findViewById(R.id.input_time_min);
        etTimeSec = (EditText) findViewById(R.id.input_time_sec);
        etPaceMin = (EditText) findViewById(R.id.input_pace_min);
        etPaceSec = (EditText) findViewById(R.id.input_pace_sec);
    }

    private double calculate(String distanceStr, String timeStr, String paceStr) {
        double answer = 0;

        // if distance + time, time + pace, or pace + distance
        if ((!distanceStr.isEmpty()) && (!timeStr.isEmpty())) {
            answer = inputDistance / Integer.parseInt(timeStr);
        } else if ((!timeStr.isEmpty()) && (!paceStr.isEmpty())) {
            answer = Integer.parseInt(timeStr) * Integer.parseInt(paceStr);
        } else if ((!distanceStr.isEmpty()) && (!paceStr.isEmpty())) {
            answer = inputDistance / Integer.parseInt(paceStr);
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
        }

        // return, plug in to third field
        return answer;

    }

    private void validateInput(String distanceStr,
                               String timeMinStr,
                               String timeSecStr,
                               String paceMinStr,
                               String paceSecStr) {

        String decimal = ".";
        timeStr = timeMinStr += decimal += timeSecStr;
        paceStr = paceMinStr += decimal += paceSecStr;

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
//            if (field.charAt(i).isNumber || field.charAt(i).equals('.')) {
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
        // if only one has data specified...
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

    public class CalcFragment extends Fragment implements View.OnClickListener {
        private Button btnCalculate;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_pace_calculator, null);
            btnCalculate = (Button) findViewById(R.id.button_calculate);
            btnCalculate.setOnClickListener(this);

            return view;
        }

        @Override
        public void onClick(View v) {
            // get values from edittexts
            distanceStr = etDistance.getText().toString();
            timeMinStr = etTimeMin.getText().toString();
            timeSecStr = etTimeSec.getText().toString();
            paceMinStr = etPaceMin.getText().toString();
            paceSecStr = etPaceSec.getText().toString();

            validateInput(distanceStr, timeMinStr, timeSecStr, paceMinStr, paceSecStr);

            calculate(distanceStr, timeStr, paceStr);
        }
    }
}
