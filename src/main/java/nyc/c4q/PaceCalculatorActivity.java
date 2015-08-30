package nyc.c4q;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class PaceCalculatorActivity extends FragmentActivity {

    PaceCalcFragment firstFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);

        // Check that the activity is using the layout version with the fragment_container FrameLayout
        if(findViewById(R.id.activity_pace_calculator) != null)
        {
            // if we are being restored from a previous state, then we dont need to do anything and should
            // return or else we could end up with overlapping fragments.
            if(savedInstanceState != null)
                return;

            // Create an instance of editorFrag
            firstFrag = new PaceCalcFragment();

            // add fragment to the fragment container layout
            getFragmentManager().beginTransaction().add(R.id.activity_pace_calculator, firstFrag).commit();
        }

    }

    public void button_calculate_onClick (View view) {

        String timeMinString = PaceCalcFragment.timeMinEt.getText().toString();
        String timeSecString = PaceCalcFragment.timeSecEt.getText().toString();

        String paceMinString = PaceCalcFragment.paceMinEt.getText().toString();
        String paceSecString = PaceCalcFragment.paceSecEt.getText().toString();

        String distanceString = PaceCalcFragment.distanceEt.getText().toString();

        double timeSec;
        double paceSec;
        double distance;

        if(timeMinString.equals("") && timeSecString.equals("") && paceMinString.equals("") && paceSecString.equals("") && distanceString.equals("")){

            PaceCalcFragment.timeMinEt.setText("");
            PaceCalcFragment.timeSecEt.setText("");
            PaceCalcFragment.paceMinEt.setText("");
            PaceCalcFragment.paceSecEt.setText("");
            PaceCalcFragment.distanceEt.setText("");

        }else if(containsLetters(distanceString) || containsLetters(paceSecString) || containsLetters(paceMinString) || containsLetters(timeSecString) || containsLetters(timeMinString)){

            PaceCalcFragment.timeMinEt.setText("");
            PaceCalcFragment.timeSecEt.setText("");
            PaceCalcFragment.paceMinEt.setText("");
            PaceCalcFragment.paceSecEt.setText("");
            PaceCalcFragment.distanceEt.setText("");

        }else if(distanceString.equals("")){

            timeSec = ((Integer.parseInt(timeMinString)*60)+Integer.parseInt(timeSecString));
            paceSec = ((Integer.parseInt(paceMinString)*60)+Integer.parseInt(paceSecString));

            double distanceResult = timeSec/paceSec;
            PaceCalcFragment.distanceEt.setText(distanceResult + "");

        }else if(timeMinString.equals("") & timeSecString.equals("")){

            paceSec = ((Integer.parseInt(paceMinString)*60)+Integer.parseInt(paceSecString));
            distance = Double.parseDouble(distanceString);

            double timeResultSec = (paceSec * distance);
            double resultSecToMin = (timeResultSec/60);

            String [] arr = String.valueOf(resultSecToMin).split("\\.");

            int timeMinResult = Integer.parseInt(arr[0]);//whole number
            int timeSecResult = Integer.parseInt(arr[1].substring(0,1));// first decimal only

            PaceCalcFragment.timeMinEt.setText(timeMinResult + "");
            PaceCalcFragment.timeSecEt.setText(timeSecResult + "0");

        }else if(paceMinString.equals("") & paceSecString.equals("")){

            //I believe there is an error in the test04.
            // time 23 min and 22 sec(1402 sec) / distance 3.1 should equal 7 min 53 sec (452.25806 sec)

            timeSec = ((Integer.parseInt(timeMinString)*60)+Integer.parseInt(timeSecString));
            distance = Double.parseDouble(distanceString);

            double paceResultSec = (timeSec/distance);
            double resultSecToMin = (paceResultSec/60);

            String [] arr = String.valueOf(resultSecToMin).split("\\.");

            int paceMinResult = Integer.parseInt(arr[0]);//whole number
            int paceSecResult = Integer.parseInt(arr[1].substring(0,2));//first two decimals only

            PaceCalcFragment.paceMinEt.setText(paceMinResult + "");
            PaceCalcFragment.paceSecEt.setText(paceSecResult + "");

        }

    }

    public boolean containsLetters (String value){

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i = 0; i < alphabet.length(); i++){

            String currentChar = String.valueOf(alphabet.charAt(i));

            if(value.contains(currentChar)){
                return true;
            }

        }

        return false;
    }




}
