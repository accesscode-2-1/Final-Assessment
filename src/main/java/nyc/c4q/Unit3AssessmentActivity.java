package nyc.c4q;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Unit3AssessmentActivity extends Activity {

    public static final String TAG = "Unit2Assessment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3assessment);

        Button buttonPaceCalculator = (Button) findViewById(R.id.activity_pace_calculator);
        Button buttonLibrary        = (Button) findViewById(R.id.activity_library);
        Button buttonMembers        = (Button) findViewById(R.id.activity_members);

        buttonPaceCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Unit3AssessmentActivity.this, PaceCalculatorActivity.class);
                Unit3AssessmentActivity.this.startActivity(intent);
            }
        });

        buttonLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Unit3AssessmentActivity.this, LibraryActivity.class);
                Unit3AssessmentActivity.this.startActivity(intent);
            }
        });

        buttonMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Unit3AssessmentActivity.this, ListActivity.class);
                Unit3AssessmentActivity.this.startActivity(intent);
            }
        });

    }
}