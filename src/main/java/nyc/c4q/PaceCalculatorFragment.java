package nyc.c4q;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PaceCalculatorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PaceCalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaceCalculatorFragment extends android.support.v4.app.Fragment {
    //created the variables
    private Button btn;
    private EditText inputDistance;
    private EditText inputTimeMin;
    private EditText inputTimeSec;
    private EditText inputPaceMin;
    private EditText inputPaceSec;
    private TextView tvResult;
    private int count = 0;   //0 because it hasn't been clicked yet


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PaceCalculatorFragment newInstance(String param1, String param2) {
        PaceCalculatorFragment fragment = new PaceCalculatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public PaceCalculatorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View result = inflater.inflate(R.layout.fragment_pace_calculator, container, false);

            inputDistance   = (EditText) result.findViewById(R.id.input_distance);
            inputTimeMin    = (EditText) result.findViewById(R.id.input_time_min);
            inputTimeSec    = (EditText) result.findViewById(R.id.input_time_sec);
            inputPaceMin    = (EditText) result.findViewById(R.id.input_pace_min);
            inputPaceSec    = (EditText) result.findViewById(R.id.input_pace_sec);
            btn = (Button) result.findViewById(R.id.button_calculate);


            //to create a button
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //the idea for this part is to calculate the pace which means pace is equal to minutes/miles (time/distance)
                    //if the fields where all there, then the calculation should work
                    if(inputDistance == null) {
                        //the logic is that the number used in the Edit Text should give the integers and provide this operation
                        //converting editText to Integers
                        String stringInputTimeMinTextFromET = inputTimeMin.getText().toString();
                        int numberInputTimeMinIntFromET = new Integer(stringInputTimeMinTextFromET).intValue();

                        String stringInputPaceMinTextFromET = inputPaceMin.getText().toString();
                        int numberInputPaceMinIntFromET = new Integer(stringInputPaceMinTextFromET).intValue();

                        String stringInputDistanceTextFromET = inputDistance.getText().toString();
                        int numberInputDistanceIntFromET = new Integer(stringInputDistanceTextFromET).intValue();

                        numberInputDistanceIntFromET = numberInputTimeMinIntFromET / numberInputPaceMinIntFromET;

                        tvResult.setText(String.valueOf(numberInputDistanceIntFromET));

                    }
                    else if (inputTimeMin == null) {
                        String stringInputTimeMinTextFromET = inputTimeMin.getText().toString();
                        int numberInputTimeMinIntFromET = new Integer(stringInputTimeMinTextFromET).intValue();

                        String stringInputPaceMinTextFromET = inputPaceMin.getText().toString();
                        int numberInputPaceMinIntFromET = new Integer(stringInputPaceMinTextFromET).intValue();

                        String stringInputDistanceTextFromET = inputDistance.getText().toString();
                        int numberInputDistanceIntFromET = new Integer(stringInputDistanceTextFromET).intValue();

                        numberInputTimeMinIntFromET = numberInputPaceMinIntFromET * numberInputDistanceIntFromET;

                        tvResult.setText(String.valueOf(numberInputTimeMinIntFromET));

                    }

                    else if (inputPaceMin == null) {
                        String stringInputTimeMinTextFromET = inputTimeMin.getText().toString();
                        int numberInputTimeMinIntFromET = new Integer(stringInputTimeMinTextFromET).intValue();

                        String stringInputPaceMinTextFromET = inputPaceMin.getText().toString();
                        int numberInputPaceMinIntFromET = new Integer(stringInputPaceMinTextFromET).intValue();

                        String stringInputDistanceTextFromET = inputDistance.getText().toString();
                        int numberInputDistanceIntFromET = new Integer(stringInputDistanceTextFromET).intValue();

                        numberInputPaceMinIntFromET = numberInputTimeMinIntFromET / numberInputDistanceIntFromET;

                        tvResult.setText(String.valueOf(numberInputPaceMinIntFromET));
                    }

                    else{
                        //do nothing
                        return ;
                    }

                    //if one of the fields is missing, then the other parts should be calculated in order to find the missing part
                    //if time is not there, then pace and distance should be multiplied
                    //if pace is not there, then time should divide by distance
                    //if distance is not there, then time should divide by p
                    count++;  //incrementing by 1

                }
            });
            return result;
        }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
