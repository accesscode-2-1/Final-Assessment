package nyc.c4q;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaceCalculatorActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        FragmentCalculator fragmentCalculator = (FragmentCalculator) getSupportFragmentManager().findFragmentById(R.id.fragment_pace_calculator);
    }

}
