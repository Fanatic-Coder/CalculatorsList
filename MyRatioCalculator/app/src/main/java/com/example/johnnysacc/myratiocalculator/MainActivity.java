package com.example.johnnysacc.myratiocalculator;

import android.os.Bundle;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private boolean changeText = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calculate();
    }

    private void Calculate(){
        final EditText Ratio_A = findViewById(R.id.Ratio_Value_A);
        final EditText Ratio_B = findViewById(R.id.Ratio_Value_B);
        final EditText Number_A = findViewById(R.id.Number_Value_A);
        final EditText Number_B = findViewById(R.id.Number_Value_B);
        //final TextView Display_Scrn = findViewById(R.id.DisplayScreen);


        /* Just a code for reference when needed
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */

        numberAListener(Number_A, Number_B, Ratio_A, Ratio_B);
        numberBListener(Number_A, Number_B, Ratio_A, Ratio_B);
    }

    private void numberAListener (final EditText Number_A, final EditText Number_B, final EditText Ratio_A, final EditText Ratio_B) {


        Number_A.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() > 0) {
                    float RatioA = Float.valueOf(Ratio_A.getText().toString());
                    float RatioB = Float.valueOf(Ratio_B.getText().toString());
                    float NumberA = Float.valueOf(Number_A.getText().toString());
                    float totalNumB = NumberA * (RatioB / RatioA);
                    if(changeText) {
                        changeText = false;
                        Number_B.setText(String.valueOf(totalNumB));
                    }
                    else {
                        changeText = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void numberBListener (final EditText Number_A, final EditText Number_B, final EditText Ratio_A, final EditText Ratio_B) {
        Number_B.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() > 0) {
                    float RatioA = Float.valueOf(Ratio_A.getText().toString());
                    float RatioB = Float.valueOf(Ratio_B.getText().toString());
                    float NumberB = Float.valueOf(Number_B.getText().toString());
                    float totalNumA = NumberB * (RatioA / RatioB);
                    if (changeText) {
                        changeText = false;
                        Number_A.setText(String.valueOf(totalNumA));
                    } else {
                        changeText = true;
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
