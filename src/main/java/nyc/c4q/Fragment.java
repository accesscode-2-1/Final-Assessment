package nyc.c4q;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by s3a on 8/30/15.
 */
public class Fragment extends android.support.v4.app.Fragment {

    public EditText inputDistance;
    public EditText inputTimeMin;
    public EditText inputTimeSec;
    public EditText inputPaceMin;
    public EditText inputPaceSec;
    public Button buttonCalculate;
    public String timeSecs;
    public String paceSecs;
    public Double resultInSecs;
    Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pace_calculator,container,false
        );
    mContext =container.getContext();
    inputDistance = (EditText) view.findViewById(R.id.input_distance);
    inputTimeMin    = (EditText) view.findViewById(R.id.input_time_min);
    inputTimeSec    = (EditText) view.findViewById(R.id.input_time_sec);
    inputPaceMin    = (EditText) view.findViewById(R.id.input_pace_min);
    inputPaceSec    = (EditText) view.findViewById(R.id.input_pace_sec);
    buttonCalculate = (Button) view.findViewById(R.id.button_calculate);


    buttonCalculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            timeSecs=inputTimeMin.getText().toString();
            paceSecs =inputPaceMin.getText().toString();

            resultInSecs=Double.parseDouble(timeSecs)+Double.parseDouble(paceSecs);

        }


    });


    return view;
}

}
