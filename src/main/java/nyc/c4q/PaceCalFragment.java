package nyc.c4q;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by c4q-marbella on 8/30/15.
 */
public class PaceCalFragment extends Fragment {

    EditText inputDistance;
    EditText inputTimeMin;
    EditText inputTimeSec;
    EditText inputPaceMin;
    EditText inputPaceSec;
    Button buttonCalculate;

    double timeSec;
    double timeMin;
    double paceSec;
    double paceMin;
    double distance;

    String tSec;
    String tMin;
    String pSec;
    String pMin;
    String dist;


    public static PaceCalFragment newInstance(int page, String title) {
        PaceCalFragment paceCalFragment = new PaceCalFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title", title);
        paceCalFragment.setArguments(args);
        return paceCalFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int fragPage = getArguments().getInt("paceCalPage", 0);
        String fragTitle = getArguments().getString("paceTitle", "paceCalc");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pace_calculator, container, false);

        inputDistance = (EditText) view.findViewById(R.id.input_distance);
        inputTimeMin = (EditText) view.findViewById(R.id.input_time_min);
        inputTimeSec = (EditText) view.findViewById(R.id.input_time_sec);
        inputPaceMin = (EditText) view.findViewById(R.id.input_pace_min);
        inputPaceSec = (EditText) view.findViewById(R.id.input_pace_sec);
        buttonCalculate = (Button) view.findViewById(R.id.button_calculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateInputs();
            }
        });

        return view;
    }

    public void validateInputs() {

        dist = inputDistance.getText().toString();
        tMin = inputTimeMin.getText().toString();
        tSec = inputTimeSec.getText().toString();
        pMin = inputPaceMin.getText().toString();
        pSec = inputPaceSec.getText().toString();

        if (dist.isEmpty() && tMin.isEmpty() && tSec.isEmpty() && pSec.isEmpty() && pMin.isEmpty()) {
            Toast.makeText(getActivity(), "Enter values for two variables", Toast.LENGTH_SHORT).show();
        } else if (dist.isEmpty()) {
            inputDistance.setText("" + calculateDistance(tMin, tSec, pSec, pMin));
        } else if (tMin.isEmpty() && tSec.isEmpty()) {
            inputTimeMin.setText("" + calculateTime(pSec, pMin,dist));
            //inputTimeSec.setText("" + calculateTimeSec());
        } else if (pMin.isEmpty() && pSec.isEmpty()) {
            inputPaceMin.setText(calculatePaceInMin(dist,tMin,tSec) + "");
            // inputPaceSec.setText("" + calculatePaceInSec());
        } else if (dist.contains("[a-zA-Z]+")) {
            Toast.makeText(getActivity(), "Enter values for two variables", Toast.LENGTH_SHORT).show();
        }

    }

    public double calculateDistance(String tMin, String tSec, String pSec, String pMin) {

        timeMin = Long.parseLong(tMin);
        timeSec = Long.parseLong(tSec);
        paceMin = Long.parseLong(pMin);
        paceSec = Long.parseLong(pSec);

        distance = ((paceMin + paceSec / 60) / (timeMin + timeSec / 60));

        return distance;
    }

    public double calculateTime(String pSec, String pMin, String dist) {

        paceMin = Long.parseLong(pMin);
        paceSec = Long.parseLong(pSec);
        distance = Long.parseLong(dist);

        timeMin = distance / (paceSec / 60 + paceMin);

        return timeMin;
    }

//    public double calculatePaceInSec(String dist,String tMin, String tSec){
//
//        distance= Long.parseLong(dist);
//        timeMin= Long.parseLong(tMin);
//        timeSec= Long.parseLong(tSec);
//
//        paceSec = (timeMin + timeSec/60) / distance;
//
//        return paceSec;
//    }

    public double calculatePaceInMin(String dist,String tMin, String tSec) {
        distance = Long.parseLong(dist);
        timeMin = Long.parseLong(tMin);
        timeSec = Long.parseLong(tSec);

        paceMin = (timeMin + timeSec / 60) / distance;

        return paceMin;
    }


}