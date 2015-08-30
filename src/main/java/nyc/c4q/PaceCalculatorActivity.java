package nyc.c4q;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class PaceCalculatorActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();

        ExampleFragment fragment = new ExampleFragment();
        ft.add(R.id.activity_pace_calculator, fragment);
        ft.commit();
    }

}