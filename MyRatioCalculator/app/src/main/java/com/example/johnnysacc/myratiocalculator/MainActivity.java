package com.example.johnnysacc.myratiocalculator;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
        final TextView Display_Scrn = findViewById(R.id.DisplayScreen);

        /* Just a code for reference when needed
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */

        Button CalcBtn = findViewById(R.id.CalculateButton);
        CalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strRatioA = Ratio_A.getText().toString();
                String strRatioB = Ratio_B.getText().toString();
                String strNumberA = Number_A.getText().toString();
                String strNumberB = Number_B.getText().toString();

                if(strNumberB.equals("") && strNumberA.equals("") || strRatioA.equals("") || strRatioB.equals("")) {
                    Snackbar.make(view, "Please enter a number!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else if (strNumberB.equals("") || strNumberB.equals("0")) {
                    float RatioA = Float.parseFloat(strRatioA);
                    float RatioB = Float.parseFloat(strRatioB);
                    float NumberA = Float.parseFloat(strNumberA);
                    float totalNumB = NumberA * (RatioB / RatioA);
                    String display = "Answer:\n   Ratio A: " + RatioA + "  Ratio B: " + RatioB + "  \n   Number A: " + NumberA + "  Missing Number B: " + totalNumB;
                    Display_Scrn.setText(String.valueOf(display));
                } else if (strNumberA.equals("") || strNumberA.equals("0")) {
                    float RatioA = Float.parseFloat(strRatioA);
                    float RatioB = Float.parseFloat(strRatioB);
                    float NumberB = Float.parseFloat(strNumberB);
                    float totalNumA = NumberB * (RatioA / RatioB);
                    String display = "Answer:\n   Ratio A: " + RatioA + "  Ratio B: " + RatioB + "  \n   Missing Number A: " + totalNumA + "  Number B: " + NumberB;
                    Display_Scrn.setText(String.valueOf(display));
                }
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
