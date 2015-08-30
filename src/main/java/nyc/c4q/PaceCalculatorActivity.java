package nyc.c4q;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class PaceCalculatorActivity extends FragmentActivity {

    FrameLayout frameLayout;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        Fragment fragment = new Fragment_pace_calc();

        frameLayout = (FrameLayout) findViewById(R.id.activity_pace_calculator);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);


        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.linear_layout, fragment).commit();


    }

}
