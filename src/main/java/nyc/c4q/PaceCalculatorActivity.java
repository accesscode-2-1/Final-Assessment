package nyc.c4q;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class PaceCalculatorActivity extends FragmentActivity {
    EditText inputDistance,inputTimeMin,inputTimeSec,inputPaceMin,inputPaceSec;
    Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        inputDistance = (EditText) findViewById(R.id.input_distance);
        inputTimeMin = (EditText) findViewById(R.id.input_time_min);
        inputTimeSec = (EditText) findViewById(R.id.input_time_sec);
        inputPaceMin = (EditText) findViewById(R.id.input_pace_min);
        inputPaceSec = (EditText) findViewById(R.id.input_pace_sec);
        buttonCalculate = (Button) findViewById(R.id.button_calculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputDistance != null
                        && inputTimeMin != null
                        && inputTimeSec != null
                        && inputPaceMin != null
                        && inputPaceSec != null){
                    //DO NOTHING
                }else if(inputDistance == null
                        && inputTimeMin == null
                        && inputTimeSec == null
                        && inputPaceSec == null
                        && inputPaceSec == null){
                    //DO NOTHING
                } else if(inputDistance != null
                        && inputTimeMin != null
                        && inputTimeSec != null
                        && inputPaceMin == null
                        && inputPaceSec == null){
                }
            }
        });
    }




}
