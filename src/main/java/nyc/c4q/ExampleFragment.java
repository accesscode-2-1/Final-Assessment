package nyc.c4q;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExampleFragment extends android.support.v4.app.Fragment {
    EditText distanceText;
    EditText timeMin;
    EditText timeSec;
    EditText paceMin;
    EditText paceSec;
    Button calculate;
    ArrayList<Integer> integerArrayList;
    int distanceInput;
    int timeMinInput ;
    int timeSecInput ;
    int paceMinInput ;
    int paceSecInput ;

    public ExampleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_pace_calculator,null);
        distanceText= (EditText) view.findViewById(R.id.input_distance);
        timeMin=(EditText) view.findViewById(R.id.input_time_min);
        timeSec= (EditText) view.findViewById(R.id.input_time_sec);
        paceMin=(EditText) view.findViewById(R.id.input_pace_min);
        paceSec=(EditText) view.findViewById(R.id.input_pace_sec);
        calculate=(Button) view.findViewById(R.id.button_calculate);
        try{
        String distanceInputString = distanceText.getText().toString();
        String timeMinInputString = timeMin.getText().toString();
        String timeSecInputString = timeSec.getText().toString();
        String paceMinInputString =paceMin.getText().toString();
        String paceSecInputString  = paceSec.getText().toString();

            timeMinInput= Integer.parseInt(timeMinInputString);
            timeSecInput= Integer.parseInt(timeSecInputString);
            paceMinInput= Integer.parseInt(paceMinInputString);
            paceSecInput= Integer.parseInt(paceSecInputString);
            distanceInput= Integer.parseInt(distanceInputString);


            String totalTimeString=timeMinInput+"."+timeSecInput;
            double totalTime= Double.parseDouble(totalTimeString);

            String totalPaceString=paceMinInput+"."+paceSecInput;
            double totalPace= Double.parseDouble(totalPaceString);

            integerArrayList=new ArrayList<>();
            integerArrayList.add(timeMinInput);
            integerArrayList.add(timeSecInput);
            integerArrayList.add(paceMinInput);
            integerArrayList.add(paceSecInput);
            integerArrayList.add(distanceInput);
            }catch(NumberFormatException ex){ // handle your exception
            Toast.makeText(getActivity(),"Invalid Input",Toast.LENGTH_LONG).show();
            }




        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numNull = 0;
                int numWithInput = 0;
                if(integerArrayList!=null) {
                    for (Integer input : integerArrayList) {
                        if (input == null) {
                            numNull++;
                        }
                        if (input != null) {
                            numWithInput++;
                        }
                    }

                    if (numWithInput == 0 || numWithInput == 1 || numWithInput == 5) {
                    }

                    if (numNull > 3) {
                    }
                }

                if (distanceText.getText() != null && timeMin.getText() != null && paceMin != null) {
                }

                if (distanceText.getText() != null && timeMin.getText() != null && paceSec.getText() != null) {
                }

                if (distanceText.getText() != null && timeSec.getText() != null && paceSec.getText() != null) {
                }

                if (distanceText.getText() != null && timeSec.getText() != null && paceMin.getText() != null) {
                }

                if (distanceText.getText() != null) {
                    if (timeMin.getText() != null || timeSec.getText() != null) {
                        calculatePace(timeMinInput, timeSecInput, distanceInput);
                    }
                    if (paceMin.getText() != null || timeSec.getText() != null) {
                        calculateTime(paceMinInput, paceSecInput, distanceInput);
                    }
                }
                if(distanceText.getText()==null) {
                    if (timeMin.getText() != null || timeSec.getText() != null) {
                        if (paceMin.getText() != null || paceSec.getText() != null) {
                            calculateDistance(timeMinInput, timeSecInput, paceMinInput, paceSecInput);
                        }
                    }
                }

            }
        });

        return view;
    }

    public void calculatePace(int timeMin, int timeSec, int distance) {

        String actualTimeString=timeMin+"."+timeSec;

        double actualTimeWithSeconds= Double.parseDouble(actualTimeString);

        double pace= distance/actualTimeWithSeconds;

        String paceString= String.valueOf(pace);

        if(paceString.contains(".")) {
            String[] splitPace = paceString.split(".");
            paceMin.setText(splitPace[0]);
            paceMin.setText(splitPace[1]);
        } else{
            paceMin.setText(String.valueOf(pace));
        }
    }

    public void calculateDistance(int timeMin, int timeSec, int paceMin, int paceSec){
        try {
            String totalTimeString=timeMin+"."+timeSec;

            double totalTime=Double.parseDouble(totalTimeString);

            String totalPaceString=paceMin+"."+paceSec;

            double totalPace=Double.parseDouble(totalPaceString);

            double distance= totalTime/totalPace;


            distanceText.setText(String.valueOf(distance));



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void calculateTime(int paceMin, int paceSec, int distance){
        String paceString=paceMin+"."+paceSec;
        double totalPace=Double.parseDouble(paceString.trim());

        double time= distance/totalPace;

        String timeString=String.valueOf(time);

        if (timeString.contains(".")) {
            String[] splitting = timeString.split(".");
            timeMin.setText(splitting[0]);
            timeSec.setText(splitting[1]);
        }
        else{
            timeMin.setText(timeString);
        }

    }
}
