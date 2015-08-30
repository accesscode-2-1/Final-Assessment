package nyc.c4q;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created on 8/30/15.
 */
public class FragmentCalculator extends Fragment {

    EditText distance, time_min, time_sec, pace_min, pace_sec;
    Button calculate;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pace_calculator, container, false);

        distance = (EditText)view.findViewById(R.id.input_distance);
        time_min = (EditText)view.findViewById(R.id.input_time_min);
        time_sec = (EditText)view.findViewById(R.id.input_time_sec);
        pace_min = (EditText)view.findViewById(R.id.input_pace_min);
        pace_sec = (EditText)view.findViewById(R.id.input_pace_sec);
        calculate = (Button)view.findViewById(R.id.button_calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double distan = Integer.parseInt(FragmentCalculator.this.distance.getText().toString());
                int numTimeMin = Integer.parseInt(time_min.getText().toString());
                int numTimeSec = (int) (Integer.parseInt(time_sec.getText().toString()) * 0.01);
                int numPaceMin = Integer.parseInt(pace_min.getText().toString());
                int numPaceSec = (int) (Integer.parseInt(pace_sec.getText().toString()) * 0.01);

                double time = numTimeMin + numTimeSec;
                double pace = numPaceMin + numPaceSec;

                if (time >1 && pace >1) {
                    FragmentCalculator.this.distance.setText(time / pace + "");
                }
                else if (time >1 && distan>1){
                    pace_min.setText((int)time/distan+"");
                    pace_sec.setText(((time/distan)-(int)(time/distan))+"");
                }
                else if (pace >1 && distan>1){
                    time_min.setText((int)pace*distan+"");
                    time_sec.setText((pace*distan)-(int)pace*distan+"");
                }
                else if (time==0||pace==0||distan==0||time==1||pace==1||distan==1){
                    distance.setText("");
                    time_min.setText("");
                    time_sec.setText("");
                    pace_min.setText("");
                    pace_sec.setText("");
                }
                else {
                    distance.setText("");
                    time_min.setText("");
                    time_sec.setText("");
                    pace_min.setText("");
                    pace_sec.setText("");
                }
            }
        });


        return view;
    }
}
