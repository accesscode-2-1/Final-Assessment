package nyc.c4q;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by c4q-marbella on 8/30/15.
 */
public class PaceCalFragment extends Fragment {

    EditText inputDistance;
    EditText inputTimeMin;
    EditText inputTimeSec;
    EditText inputPaceMin;
    EditText inputPaceSec;
    Button buttonCalculate;


    public static PaceCalFragment newInstance(int page, String title) {
        PaceCalFragment paceCalFragment = new PaceCalFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title",title);
        paceCalFragment.setArguments(args);
        return paceCalFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int fragPage = getArguments().getInt("paceCalPage", 0);
        String fragTitle = getArguments().getString("paceTitle", "paceCalc");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pace_calculator, container, false);

        inputDistance   = (EditText) view.findViewById(R.id.input_distance);
        inputTimeMin =(EditText) view.findViewById(R.id.input_time_min);
        inputTimeSec = (EditText) view.findViewById(R.id.input_time_sec);
        inputPaceMin = (EditText) view.findViewById(R.id.input_pace_min);
        inputPaceSec = (EditText) view.findViewById(R.id.input_pace_sec);
        buttonCalculate = (Button) view.findViewById(R.id.button_calculate);

        return view;
    }
}
