package nyc.c4q;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PaceCalculatorFragment extends Fragment implements View.OnClickListener {

    private EditText input_distance, input_time_min, input_time_sec, input_pace_min, input_pace_sec;
    private Button button_calculate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pace_calculator, container, false);
        input_distance = (EditText) view.findViewById(R.id.input_distance);
        input_time_min = (EditText) view.findViewById(R.id.input_time_min);
        input_time_sec = (EditText) view.findViewById(R.id.input_time_sec);
        input_pace_min = (EditText) view.findViewById(R.id.input_pace_min);
        input_pace_sec = (EditText) view.findViewById(R.id.input_pace_sec);
        button_calculate = (Button) view.findViewById(R.id.button_calculate);
        button_calculate.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_calculate:
                boolean distanceEmpty;
                boolean timeMinEmpty;
                boolean timeSecEmpty;
                boolean paceMinEmpty;
                boolean paceSecEmpty;

                String distance = input_distance.getText().toString();
                String time_min = input_time_min.getText().toString();
                String time_sec = input_time_sec.getText().toString();
                String pace_min = input_pace_min.getText().toString();
                String pace_sec = input_pace_sec.getText().toString();

                int d;
                int time;
                int tm;
                int ts;
                int pace;
                int pm;
                int ps;

                if (distance.isEmpty()) {
                    distanceEmpty = true;
                    input_distance.setText("0");
                    d = 0;
                } else {
                    distanceEmpty = false;
                    d = Integer.parseInt(distance);
                }

                if (time_min.isEmpty()) {
                    timeMinEmpty = true;
                    input_time_min.setText("0");
                    tm = 0;
                } else {
                    timeMinEmpty = false;
                    tm = Integer.parseInt(time_min);
                }

                if (time_sec.isEmpty()) {
                    timeSecEmpty = true;
                    input_time_sec.setText("0");
                    ts = 0;
                } else {
                    timeSecEmpty = false;
                    ts = Integer.parseInt(time_sec);
                }

                if (pace_min.isEmpty()) {
                    paceMinEmpty = true;
                    input_pace_min.setText("0");
                    pm = 0;
                } else {
                    paceMinEmpty = false;
                    pm = Integer.parseInt(pace_min);
                }

                if (pace_sec.isEmpty()) {
                    paceSecEmpty = true;
                    input_pace_sec.setText("0");
                    ps = 0;
                } else {
                    paceSecEmpty = false;
                    ps = Integer.parseInt(pace_sec);
                }

                time = (tm * 60) + ts;
                pace = (pm * 60) + ps;

                if (distanceEmpty && (!timeMinEmpty || !timeSecEmpty) && (!paceMinEmpty || !paceSecEmpty)) {
                    //distance is empty but user input time and pace
                    input_distance.setText(time / pace);
                } else if (!distanceEmpty && (timeMinEmpty || timeSecEmpty) && (!paceMinEmpty || !paceSecEmpty)) {
                    //time is empty but user input distance and pace
                    input_time_min.setText(d * pace);
                } else if (!distanceEmpty && (!timeMinEmpty || !timeSecEmpty) && (paceMinEmpty || paceSecEmpty)) {
                    //pace is empty but user input distance and time
                    input_pace_min.setText(time / d);
                } else {
                    //do nothing
                }
        }
    }
}
