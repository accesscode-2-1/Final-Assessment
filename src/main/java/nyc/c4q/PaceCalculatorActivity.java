package nyc.c4q;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PaceCalculatorActivity extends FragmentActivity {
    EditText distance, time;
    TextView pace;
    ArrayList numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        distance = (EditText) findViewById(R.id.input_distance);
        time = (EditText) findViewById(R.id.input_time);
        pace = (TextView) findViewById(R.id.paceID);

        numbers = new ArrayList<String>();
        for (int i = 1; i < 10000; i++){
            String n = Integer.toString(i);
            numbers.add(n);
        }
    }

    public void calculate (View v){
        String dString = distance.getText().toString();
        String tString = time.getText().toString();

        if (numbers.contains(dString) && numbers.contains(tString)) {
            double d = Integer.parseInt(dString);
            double t = Integer.parseInt(tString);
            double p = d / t;
            pace.setText(p + " Miles Per Minute");
        }
        else { Toast.makeText(getApplicationContext(), "Please Enter a valid numbers between 0 - 10000",
                Toast.LENGTH_LONG).show();
        }
    }
}
