package nyc.c4q;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class PaceCalculatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        PaceCalculatorFragment fragment = new PaceCalculatorFragment();

        getFragmentManager().beginTransaction().add(R.id.activity_pace_calculator, fragment).commit();
    }

}
