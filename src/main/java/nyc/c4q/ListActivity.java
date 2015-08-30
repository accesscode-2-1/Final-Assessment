package nyc.c4q;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class ListActivity extends Activity {
    private Button flip;
    private ListView list;
    private ArrayAdapter<String> adapter;

    ArrayList names;
    ArrayList names2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = (ListView) findViewById(R.id.list);
        flip = (Button) findViewById(R.id.flipID);

        SharedPreferences settings;
        settings = ListActivity.this.getSharedPreferences("PREFS_NAME", 0);
        String name = settings.getString("flipText","");
        //button.setVisibility(View.VISIBLE);
        if (! name.equals("")){
            flip.setText(name);
        }

        names = new ArrayList<String>();
        names.add("Hannah Abbott");
        names.add("Katie Bell");
        names.add("Susan Bones");
        names.add("Terry Boot");
        names.add("Lavender Brown");
        names.add("Cho Chang");
        names.add("Michael Corner");
        names.add("Colin Creevey");
        names.add("Marietta Edgecombe");
        names.add("Justin Finch-Fletchley");
        names.add("Seamus Finnigan");
        names.add("Anthony Goldstein");
        names.add("Hermione Granger");
        names.add("Angelina Johnson");
        names.add("Lee Jordan");
        names.add("Neville Longbottom");
        names.add("Luna Lovegood");
        names.add("Ernin Macmillan");
        names.add("Parvati Patil");
        names.add("Padma Patil");
        names.add("Harry Potter");
        names.add("Zacharias Smith");
        names.add("Alicia Spinnet");
        names.add("Dean Thomas");
        names.add("Fred Weasley");
        names.add("George Weasley");
        names.add("Ginny Weasley");
        names.add("Ron Weasley");

        names2 = new ArrayList<String>();
        names2.add("Abbott, Hannah");
        names2.add("Bell, Katie");
        names2.add("Bones, Susan");
        names2.add("Boot, Terry");
        names2.add("Brown, Lavender");
        names2.add("Chang, Cho");
        names2.add("Corner, Michael");
        names2.add("Creevey, Colin");
        names2.add("Edgecombe, Marietta");
        names2.add("Finch-Fletchley, Justin");
        names2.add("Finnigan, Seamus");
        names2.add("Goldstein, Anthony");
        names2.add("Granger, Hermione");
        names2.add("Johnson, Angelina ");
        names2.add("Jordan, Lee");
        names2.add("Longbottom, Neville");
        names2.add("Lovegood, Luna");
        names2.add("Macmillan, Ernin");
        names2.add("Patil, Parvati");
        names2.add("Patil, Padma");
        names2.add("Potter, Harry");
        names2.add("Smith, Zacharias");
        names2.add("Spinnet, Alicia");
        names2.add("Thomas, Dean");
        names2.add("Weasley, Fred");
        names2.add("Weasley, George");
        names2.add("Weasley, Ginny");
        names2.add("Weasley, Ron");

        if (flip.getText().toString().equals("Last, First")){
            adapter = new ArrayAdapter<>(ListActivity.this, android.R.layout.simple_list_item_1, names);
            list.setAdapter(adapter);
        }
        else {
            adapter = new ArrayAdapter<>(ListActivity.this, android.R.layout.simple_list_item_1, names2);
            list.setAdapter(adapter);
        }


    }
    public void flipM (View v){
        if (flip.getText().toString().equals("Last, First")){
            flip.setText("First Last");
            adapter = new ArrayAdapter<>(ListActivity.this, android.R.layout.simple_list_item_1, names2);
            list.setAdapter(adapter);
        }
        else {
            flip.setText("Last, First");
            adapter = new ArrayAdapter<>(ListActivity.this, android.R.layout.simple_list_item_1, names);
            list.setAdapter(adapter);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();

        String flipText = flip.getText().toString();

        SharedPreferences settings;
        settings = ListActivity.this.getSharedPreferences("PREFS_NAME", 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("flipText", flipText);
        editor.commit();

    }
}
