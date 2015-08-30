package nyc.c4q;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.math.BigDecimal;

public class PaceCalculatorActivity extends FragmentActivity {

    EditText inputDistance;
    EditText inputTimeMin;
    EditText inputTimeSec;
    EditText inputPaceMin;
    EditText inputPaceSec;
    Button buttonCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pace_calculator);

        inputDistance = (EditText) findViewById(R.id.input_distance);
        inputTimeMin = (EditText) findViewById(R.id.input_time_min);
        inputTimeSec = (EditText) findViewById(R.id.input_time_sec);
        inputPaceMin = (EditText) findViewById(R.id.input_pace_min);
        inputPaceSec = (EditText) findViewById(R.id.input_pace_sec);
        buttonCalculate = (Button) findViewById(R.id.button_calculate);





        buttonCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                    if ((inputPaceMin.getText().toString().trim().length() == 0) && (inputPaceSec.getText().toString().trim().length() == 0)) {

                    int timeMin;
                    int timeSec;
                    double distance;
                    double result;

                    timeMin = Integer.parseInt(inputTimeMin.getText().toString());
                    timeSec = Integer.parseInt(inputTimeSec.getText().toString());
                    distance = Double.valueOf(inputDistance.getText().toString());

                    result = ((timeMin + (timeSec / 60.0)) / distance);
                    int finalPaceMin = (int) result;
                    inputPaceMin.setText(finalPaceMin + "");
                    int finalPaceSec = (int) ((result - finalPaceMin) * 60);
                    inputPaceSec.setText( finalPaceSec + "");

                } else if ((inputTimeMin.getText().toString().trim().length() == 0) && (inputTimeSec.getText().toString().trim().length() == 0)) {

                        int paceMin;
                        int paceSec;
                        double distance;
                        double result;

                distance = Double.valueOf(inputDistance.getText().toString());
                paceMin = Integer.parseInt(inputPaceMin.getText().toString());
                paceSec = Integer.parseInt(inputPaceSec.getText().toString());

                result = distance * (paceMin + (paceSec / 60.0));
                int finalres = (int) result;
                inputTimeMin.setText(finalres + "");
                int finalSec = (int) ((result - finalres) * 60);
                inputTimeSec.setText(finalSec + "");
                 }else {

                        int paceMin;
                        int paceSec;
                        int timeMin;
                        int timeSec;
                        double result;

                    timeMin = Integer.parseInt(inputTimeMin.getText().toString());
                    timeSec = Integer.parseInt(inputTimeSec.getText().toString());
                    paceMin = Integer.parseInt(inputPaceMin.getText().toString());
                    paceSec = Integer.parseInt((inputPaceSec.getText().toString()));

                    result = ((timeMin + (timeSec / 60.0)) / (paceMin + (paceSec / 60.0)));
                    inputDistance.setText(result + " ");
                }
            }

        });

    }

}
