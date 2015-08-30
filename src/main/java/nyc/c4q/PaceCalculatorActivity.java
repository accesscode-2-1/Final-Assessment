package nyc.c4q;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class PaceCalculatorActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

//        //To have the fragment be shown in the PaceCalculatorActivity
//        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();
//        transaction.replace(R.id.fragment_pace_calculator, new PaceCalculatorFragment()).commit();



//
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.fragment_pace_calculator, new PaceCalculatorFragment())
//                    .commit();
//        }


//        //if you added fragment via layout xml
//        PaceCalculatorFragment fragment = (PaceCalculatorFragment)fm.findFragmentById(R.id.fragment_pace_calculator);
//        fragment.getView();

    }

}
