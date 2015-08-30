package nyc.c4q;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class PaceCalculatorActivity extends FragmentActivity {

    PaceCalFragment mPaceCalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        mPaceCalFragment = PaceCalFragment.newInstance(0, "PaceCalc");
        ft.replace(R.id.activity_pace_calculator, mPaceCalFragment);
        ft.commit();

    }

}


