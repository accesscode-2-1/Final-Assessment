package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by s3a on 8/30/15.
 */
public class CalcActivity extends Activity {

    public EditText inputDistance;
    public EditText inputTimeMin;
    public EditText inputTimeSec;
    public EditText inputPaceMin;
    public EditText inputPaceSec;
    public Button buttonCalculate;
    public String timeSecs;
    public String paceSecs;
    public Double resultInSecs;
    public Double distance;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pace_calculator);


        inputDistance = (EditText) findViewById(R.id.input_distance);
        inputTimeMin    = (EditText) findViewById(R.id.input_time_min);
        inputTimeSec    = (EditText) findViewById(R.id.input_time_sec);
        inputPaceMin    = (EditText) findViewById(R.id.input_pace_min);
        inputPaceSec    = (EditText) findViewById(R.id.input_pace_sec);
        buttonCalculate = (Button) findViewById(R.id.button_calculate);

        //Mile per minute is 26.8224s
        //Miles per second is 1 609.344 m / s
        //Convert minutes to seconds
        //Divide miles /seconds 

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timeSecs = inputTimeMin.getText().toString();
                paceSecs = inputPaceMin.getText().toString();



                resultInSecs = Double.parseDouble(timeSecs) + Double.parseDouble(paceSecs);
                //distance
//                distance =

            }


        });

    }
}