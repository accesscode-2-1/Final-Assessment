package nyc.c4q;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by c4q-anthonyf on 8/30/15.
 */
public class PaceCalculatorFragment extends Fragment {

    EditText distanceET, timeMinET, timeSecET, paceMinET, paceSecET;
    Button calculateButton;

    double timeMin, timeSec, paceMin, paceSec, distance;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pace_calculator, container, false);

        distanceET = (EditText) root.findViewById(R.id.input_distance);
        timeMinET = (EditText) root.findViewById(R.id.input_time_min);
        timeSecET = (EditText) root.findViewById(R.id.input_time_sec);
        paceMinET = (EditText) root.findViewById(R.id.input_pace_min);
        paceSecET = (EditText) root.findViewById(R.id.input_pace_sec);

        distance = timeMin = timeSec = paceMin = paceSec = 0;

        calculateButton = (Button) root.findViewById(R.id.button_calculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrieveDataFromViews();
                if(distance == 0
                        && (timeMin > 0 || timeSec > 0)
                        && (paceMin > 0 || paceSec > 0)){
                    distance = ((timeMin * 60) + timeSec)/((paceMin * 60) + paceSec);
                    distanceET.setText(distance + "");
                }else if(paceMin == 0
                        && paceSec == 0
                        && distance > 0
                        && (timeMin > 0 || timeSec > 0)){
                    paceSec = ((timeMin * 60) + timeSec)/distance;
                    paceMin = paceSec/60;
                    paceSec = paceSec - ((int)paceMin * 60);

                    paceMinET.setText(paceMin + "");
                    paceSecET.setText(paceSec + "");
                }else if(timeMin == 0 && timeSec == 0
                        && distance > 0
                        && (paceMin > 0 || paceSec > 0)){
                    timeSec = ((paceMin * 60) + paceSec) * distance;
                    timeMin = timeSec/60;
                    timeSec = timeSec - ((int)timeMin * 60);

                    timeMinET.setText(timeMin + "");
                    timeSecET.setText(timeSec + "");
                }
            }
        });


        return root;

    }

    private void retrieveDataFromViews() {
        if(!distanceET.getText().toString().isEmpty()) {
            try {
                distance = Double.parseDouble(distanceET.getText().toString());
            }catch(NumberFormatException e){
                distance = 0;
            }
        }
        if(!timeMinET.getText().toString().isEmpty()) {
            try{
                timeMin = Integer.parseInt(timeMinET.getText().toString());
            }catch(NumberFormatException e){
                timeMin = 0;
        }
        }
        if(!timeSecET.getText().toString().isEmpty()) {
            try {
                timeSec = Integer.parseInt(timeSecET.getText().toString());
            }catch(NumberFormatException e){
                timeSec = 0;
            }
        }
        if(!paceMinET.getText().toString().isEmpty()) {
            try{
                paceMin = Integer.parseInt(paceMinET.getText().toString());
            }catch(NumberFormatException e){
                paceMin = 0;
            }
        }
        if(!paceSecET.getText().toString().isEmpty()) {
            try{
                paceSec = Integer.parseInt(paceSecET.getText().toString());
            }catch(NumberFormatException e){
                paceSec = 0;
            }
        }
    }


}
