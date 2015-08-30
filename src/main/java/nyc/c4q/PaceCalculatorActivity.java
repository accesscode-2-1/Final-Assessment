package nyc.c4q;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaceCalculatorActivity extends FragmentActivity {

    EditText inputDistance,inputTimeMin,inputTimeSec,inputPaceMin, inputPaceSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

    }

    public double button_calculate_onClick(View view){


        EditText inputDistance = (EditText) findViewById(R.id.input_distance);
        EditText inputTimeMin = (EditText) findViewById(R.id.input_time_min);
        EditText inputTimeSec = (EditText) findViewById(R.id.input_time_sec);
        EditText inputPaceMin = (EditText) findViewById(R.id.input_pace_min);
        EditText inputPaceSec = (EditText) findViewById(R.id.input_pace_sec);


            return 0.0;
        }

    }

