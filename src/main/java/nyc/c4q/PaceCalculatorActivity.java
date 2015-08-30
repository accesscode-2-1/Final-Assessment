package nyc.c4q;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PaceCalculatorActivity extends FragmentActivity {
//  public EditText inputDistance;
//    public EditText inputTimeMin;
//    public EditText inputTimeSec;
//    public EditText inputPaceMin;
//    public EditText inputPaceSec;
//    public Button buttonCalculate;
//    public String timeSecs;
//    public String paceSecs;
//    public Double resultInSecs;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);


//      //I know this is one method
//      FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//// Replace the contents of the container with the new fragment
//      ft.replace(R.id.fragment_pace_calculator, new nyc.c4q.Fragment());
//// or ft.add(R.id.your_placeholder, new FooFragment());
//// Complete the changes added above
//      ft.commit();



    }



////    @Nullable
////    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
////        View view = inflater.inflate(R.layout.fragment_pace_calculator,container,false
////        );
//
//  inputDistance = (EditText) view.findViewById(R.id.input_distance);
//        inputTimeMin    = (EditText) view.findViewById(R.id.input_time_min);
//         inputTimeSec    = (EditText) view.findViewById(R.id.input_time_sec);
//       inputPaceMin    = (EditText) view.findViewById(R.id.input_pace_min);
//      inputPaceSec    = (EditText) view.findViewById(R.id.input_pace_sec);
//       buttonCalculate = (Button) view.findViewById(R.id.button_calculate);
//
//
//        buttonCalculate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                timeSecs=inputTimeMin.getText().toString();
//                paceSecs =inputPaceMin.getText().toString();
//
//                resultInSecs=Double.parseDouble(timeSecs)+Double.parseDouble(paceSecs);
//
//            }
//
//
//        });
//
//
//        return view;
//    }


    }


