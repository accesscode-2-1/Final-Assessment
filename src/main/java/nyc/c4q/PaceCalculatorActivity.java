package nyc.c4q;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class PaceCalculatorActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.Fragment paceCalculator = new PaceCalculatorFragment();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.activity_pace_calculator, paceCalculator);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
