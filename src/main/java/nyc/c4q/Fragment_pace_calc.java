package nyc.c4q;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * Created by alvin2 on 8/30/15.
 */
public class Fragment_pace_calc extends Fragment {

    EditText inputDistance;
    EditText inputTimeMin;
    EditText inputTimeSec;
    EditText inputPaceMin;
    EditText inputPaceSec;
    Button buttonCalculate;
    private double distance = 0;
    private double time = 0;
    private double pace = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pace_calculator, container, false);


        inputDistance = (EditText) root.findViewById(R.id.input_distance);
        inputTimeMin = (EditText) root.findViewById(R.id.input_time_min);
        inputTimeSec = (EditText) root.findViewById(R.id.input_time_sec);
        inputPaceMin = (EditText) root.findViewById(R.id.input_pace_min);
        inputPaceSec = (EditText) root.findViewById(R.id.input_pace_sec);
        buttonCalculate = (Button) root.findViewById(R.id.button_calculate);


        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!inputTimeMin.getText().toString().equals("") && !inputTimeSec.getText().toString().equals("")) {
                    time = (Double.parseDouble(inputTimeMin.getText().toString()) * 60) + Double.parseDouble(inputTimeSec.getText().toString());
                }

                if (!inputPaceMin.getText().toString().equals("") && !inputPaceSec.getText().toString().equals("")) {
                    pace = (Double.parseDouble(inputPaceMin.getText().toString()) * 60) + Double.parseDouble(inputPaceSec.getText().toString());
                }

                if (isNumeric(inputDistance.getText().toString()) && !inputDistance.getText().toString().equals("")) {
                        distance = Double.parseDouble(inputDistance.getText().toString());
                }


                if (time == 0 && distance == 0 && pace == 0) {

                } else if (time != 0 && distance != 0 && pace != 0) {

                } else if (time == 0) {
                    time = (distance * (pace / 60));
                    inputTimeMin.setText(String.valueOf(time));
                } else if (distance == 0) {
                    distance = (time / pace);
                    inputDistance.setText(String.valueOf(distance));
                } else if (pace == 0) {
                    pace = (time / distance);
                    long num = Math.round(pace) / 60;
                    inputPaceMin.setText(String.valueOf(num));
                    double sec = ((pace / 60) - num) * 60;
                    inputPaceSec.setText(String.valueOf(sec));
                }
            }
        });

        return root;
    }

    public static boolean isNumeric(String str)
    {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }


}
