package nyc.c4q;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PaceCalculatorFragment extends Fragment implements View.OnClickListener {

    private EditText mEditTextDistance;
    private EditText mEditTextTimeMin;
    private EditText mEditTextTimeSec;
    private EditText mEditTextPaceMin;
    private EditText mEditTextPaceSec;
    private Button mButtonCalculate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_pace_calculator, container, false);

        initializeViews(result);

        mButtonCalculate.setOnClickListener(this);

        return result;
    }

    private void initializeViews(View result) {
        mEditTextDistance = (EditText) result.findViewById(R.id.input_distance);
        mEditTextTimeMin = (EditText) result.findViewById(R.id.input_time_min);
        mEditTextTimeSec = (EditText) result.findViewById(R.id.input_time_sec);
        mEditTextPaceMin = (EditText) result.findViewById(R.id.input_pace_min);
        mEditTextPaceSec = (EditText) result.findViewById(R.id.input_pace_sec);
        mButtonCalculate = (Button) result.findViewById(R.id.button_calculate);
    }

    @Override
    public void onClick(View v) {
        calculate();
    }

    private void calculate() {

        String distance = mEditTextDistance.getText().toString();
        String timeMin = mEditTextTimeMin.getText().toString();
        String timeSec = mEditTextTimeSec.getText().toString();
        String paceMin = mEditTextPaceMin.getText().toString();
        String paceSec = mEditTextPaceSec.getText().toString();

        if (distance.length() == 0) {
            calculateDistance(timeMin, timeSec, paceMin, paceSec);
        } else if (timeMin.length() == 0 && timeSec.length() == 0) {
            calculateTime(distance, paceMin, paceSec);
        } else if (paceMin.length() == 0 && paceSec.length() == 0) {
            calculatePace(distance, timeMin, timeSec);
        }

    }

    private void calculateDistance(String timeMin, String timeSec, String paceMin, String paceSec) {
        double timeInSec;
        double paceInSec;

        if (timeMin.length() != 0) {
            timeInSec = Integer.parseInt(timeMin) * 60.0;
        } else {
            timeInSec = 0;
        }
        if (timeSec.length() != 0) {
            timeInSec += Integer.parseInt(timeSec);
        }

        if (paceMin.length() != 0) {
            paceInSec = Integer.parseInt(paceMin) * 60.0;
        } else {
            paceInSec = 0;
        }
        if (paceSec.length() != 0) {
            paceInSec += Integer.parseInt(paceSec);
        }

        double result = 0;

        if (timeInSec != 0 && paceInSec != 0) {
            result = timeInSec/paceInSec;
        }

        if (result != 0) {
            mEditTextDistance.setText(result + "");
        }
    }

    private void calculateTime(String distance, String paceMin, String paceSec) {
        double paceInSec;
        double dis = 0;

        if (paceMin.length() != 0) {
            paceInSec = Integer.parseInt(paceMin) * 60.0;
        } else {
            paceInSec = 0;
        }
        if (paceSec.length() != 0) {
            paceInSec += Integer.parseInt(paceSec);
        }

        if (distance.length() != 0 && Character.isDigit(distance.charAt(0))) {
            dis = Double.parseDouble(distance);
            double time = paceInSec * dis;
            double timeInSec = time % 60;
            double timeInMin = time / 60;

            mEditTextTimeMin.setText(timeInMin + "");
            mEditTextTimeSec.setText(timeInSec + "");
        }


    }

    private void calculatePace(String distance, String timeMin, String timeSec) {
        double timeInSec;
        double dis = 0;

        if (timeMin.length() != 0) {
            timeInSec = Integer.parseInt(timeMin) * 60.0;
        } else {
            timeInSec = 0;
        }
        if (timeSec.length() != 0) {
            timeInSec += Integer.parseInt(timeSec);
        }

        if (distance.length() != 0 && Character.isDigit(distance.charAt(0))) {
            dis = Double.parseDouble(distance);
            double pace = timeInSec / dis;
            double paceInSec = pace % 60;
            double paceInMin = pace / 60;

            mEditTextPaceMin.setText(paceInMin + "");
            mEditTextPaceSec.setText(paceInSec + "");
        }


    }
}
