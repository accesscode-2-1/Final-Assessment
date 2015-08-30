package nyc.c4q;

import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaceCalculatorActivity extends FragmentActivity {

    private EditText inputDistance;
    private EditText inputTimeMin;
    private EditText inputTimeSec;
    private EditText inputPaceMin;
    private EditText inputPaceSec;
    private Button buttonCalculate;
    float time;
    float pace;
    float distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        PaceCalculatorFragment paceFragment = (PaceCalculatorFragment) getSupportFragmentManager().findFragmentById(R.id.paceFragment);



        inputDistance = (EditText) findViewById(R.id.input_distance);
        inputTimeMin = (EditText) findViewById(R.id.input_time_min);
        inputTimeSec = (EditText) findViewById(R.id.input_time_sec);
        inputPaceMin = (EditText) findViewById(R.id.input_pace_min);
        inputPaceSec = (EditText) findViewById(R.id.input_pace_sec);
        buttonCalculate = (Button) findViewById(R.id.button_calculate);


        try {

            String distanceString = inputDistance.getText().toString();
            String timeMin = inputTimeMin.getText().toString();
            String timeSec = inputTimeSec.getText().toString();
            String paceMin = inputPaceMin.getText().toString();
            String paceSec = inputPaceSec.getText().toString();

            if (timeMin.matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+") && timeSec.matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")
                    && paceMin.matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+") && paceSec.matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")) {
                buttonCalculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        calculateDistance();
                    }
                });
            }
        } catch (NullPointerException ex) {
            Log.d("invalid", "Invalid input");
        }

    }

    public void calculateDistance() {

        String timeMin = inputTimeMin.getText().toString();
        String timeSec = inputTimeSec.getText().toString();
        String paceMin = inputPaceMin.getText().toString();
        String paceSec = inputPaceSec.getText().toString();

        time = Float.parseFloat(timeMin + "." + timeSec);
        Log.d("what", Float.toString(time));
        pace = Float.parseFloat(paceMin + "." + paceSec);
        Log.d("what2", Float.toString(pace));
        distance = time / pace;
        Log.d("what3", Float.toString(distance));

        inputDistance.setText(String.valueOf("%1f" + distance));

    }

    public void calculatePace() {

        String distanceString = inputDistance.getText().toString();
        String timeMin = inputTimeMin.getText().toString();
        String timeSec = inputTimeSec.getText().toString();
        String paceMin = inputPaceMin.getText().toString();
        String paceSec = inputPaceSec.getText().toString();

        time = Float.parseFloat(timeMin + "." + timeSec);
        distance = Float.parseFloat(distanceString);
        pace = time / distance;
    }

    public void calculateTime() {

        String distanceString = inputDistance.getText().toString();
        String timeMin = inputTimeMin.getText().toString();
        String timeSec = inputTimeSec.getText().toString();
        String paceMin = inputPaceMin.getText().toString();
        String paceSec = inputPaceSec.getText().toString();

        pace = Float.parseFloat(paceMin + "." + paceSec);
        distance = Float.parseFloat(distanceString);
        time = pace * distance;

    }

}
