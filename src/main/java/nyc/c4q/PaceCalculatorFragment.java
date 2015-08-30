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

/**
 * Created by charlynbuchanan on 8/30/15.
 */
public class PaceCalculatorFragment extends Fragment {

    EditText inputDistance;
    EditText inputTimeMin;
    EditText inputTimeSec;
    EditText inputPaceMin;
    EditText inputPaceSec;
    Button calculate;
    int timeMin;
    int timeSec;
    double distance;
    double paceMin;
    double paceSec;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pace_calculator, container, false);

        inputDistance = (EditText)view.findViewById(R.id.input_distance);
        inputTimeMin = (EditText)view.findViewById(R.id.input_time_min);
        inputTimeSec = (EditText)view.findViewById(R.id.input_time_sec);
        inputPaceMin = (EditText)view.findViewById(R.id.input_pace_min);
        inputPaceSec = (EditText)view.findViewById(R.id.input_pace_sec);
        calculate = (Button)view.findViewById(R.id.button_calculate);





        inputTimeMin.getText();



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("distance", String.valueOf(inputDistance.getText()));
                Log.i("timeMin", String.valueOf(inputTimeMin.getText()));
                Log.i("timeSec", String.valueOf(inputTimeSec.getText()));
                Log.i("paceMin", String.valueOf(inputPaceMin.getText()));
                Log.i("paceSec", String.valueOf(inputPaceSec.getText()));

                Log.i("timesec new", String.valueOf(timeSec));
//                Log.i("possible for method", String.valueOf(Integer.parseInt(inputDistance.getText().toString())));

//                timeSec = Integer.valueOf(String.valueOf(inputTimeSec.getText()));
//                timeMin = Integer.valueOf(String.valueOf(inputTimeMin.getText()));
//                distance = Double.valueOf(String.valueOf(inputDistance.getText()));
//                paceMin = Double.valueOf(String.valueOf(inputPaceMin.getText()));
//                paceSec = Double.valueOf(String.valueOf(inputPaceSec.getText()));


                if (inputDistance == null) {
                    timeSec = Integer.parseInt(inputTimeSec.getText().toString());
                    timeMin = Integer.parseInt(inputTimeMin.getText().toString());
                    paceMin = Integer.parseInt(inputPaceMin.getText().toString());
                    paceSec = Integer.parseInt(inputPaceSec.getText().toString());
                    int totalTime = ((timeMin + timeSec)/60);
                    double totalPace = ((paceMin + paceSec)/60);
                    double distance = totalTime/totalPace;

                    inputDistance.setText(String.valueOf(distance));

                } else if ((inputTimeMin == null) && (inputTimeSec == null)){
                    distance = Integer.parseInt(inputDistance.getText().toString());
                    paceMin = Integer.parseInt(inputPaceMin.getText().toString());
                    paceSec = Integer.parseInt(inputPaceSec.getText().toString());
                    double totalPace = ((paceMin + paceSec)/60);

                    double time = totalPace*distance;
                    inputTimeMin.setText(String.valueOf(time));




                } else if ((inputPaceMin == null) && (inputPaceSec == null)) {
                    timeSec = Integer.parseInt(inputTimeSec.getText().toString());
                    timeMin = Integer.parseInt(inputTimeMin.getText().toString());
                    distance = Integer.parseInt(inputDistance.getText().toString());

                    int totalTime = ((timeMin + timeSec)/60);
                    Log.d("totalTime", String.valueOf(totalTime));
                    double pace = totalTime/distance;
                    inputPaceMin.setText((String.valueOf(pace) + "minute/mile"));
                }
            }
        });

        return view;
    }


//    public double getDistance() {
//        //d=min/distance
//
//    }
//
//    public double getTime() {
//        //t=pace*distance
//    }
}
