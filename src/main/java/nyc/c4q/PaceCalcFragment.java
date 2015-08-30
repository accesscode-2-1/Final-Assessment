package nyc.c4q;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by c4q-rosmary on 8/30/15.
 */
public class PaceCalcFragment extends Fragment {

    static EditText distanceEt;
    static EditText timeMinEt;
    static EditText timeSecEt;
    static EditText paceMinEt;
    static EditText paceSecEt;

    Button calculateBtn;

    View paceCalcView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        // Inflate the layout for this fragment
        paceCalcView = inflater.inflate(R.layout.fragment_pace_calculator, container, false);

        initializeViews();


        return paceCalcView;
    }


    public void initializeViews () {
        distanceEt = (EditText) paceCalcView.findViewById(R.id.input_distance);

        timeMinEt = (EditText) paceCalcView.findViewById(R.id.input_time_min);
        timeSecEt = (EditText) paceCalcView.findViewById(R.id.input_time_sec);

        paceMinEt = (EditText) paceCalcView.findViewById(R.id.input_pace_min);
        paceSecEt = (EditText) paceCalcView.findViewById(R.id.input_pace_sec);

        calculateBtn = (Button) paceCalcView.findViewById(R.id.button_calculate);
    }



}
