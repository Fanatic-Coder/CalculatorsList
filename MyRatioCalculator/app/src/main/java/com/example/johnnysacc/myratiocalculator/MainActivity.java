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

        final EditText Ratio_A = findViewById(R.id.Ratio_Value_A);
        final EditText Ratio_B = findViewById(R.id.Ratio_Value_B);
        final EditText Ratio_C = findViewById(R.id.Ratio_Value_C);
        final EditText Ratio_D = findViewById(R.id.Ratio_Value_D);
        final TextView Display_Scrn = findViewById(R.id.DisplayScreen);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
        //Calculate();
        Button CalcBtn = findViewById(R.id.CalculateButton);
        CalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strValueA = Ratio_A.getText().toString();
                String strValueB = Ratio_B.getText().toString();
                String strValueC = Ratio_C.getText().toString();
                String strValueD = Ratio_D.getText().toString();

                if(strValueD.equals("") && strValueC.equals("") || strValueA.equals("") || strValueB.equals("")) {
                    Snackbar.make(view, "Please enter a number!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else if (strValueD.equals("")) {
                    float valueA = Float.parseFloat(strValueA);
                    float valueB = Float.parseFloat(strValueB);
                    float valueC = Float.parseFloat(strValueC);
                    float totalD = valueC * (valueB / valueA);
                    String display = "Answer:\n   Ratio A: " + valueA + "  Ratio B: " + valueB + "  Number A: " + valueC + "  Missing Number B: " + totalD;
                    Display_Scrn.setText(String.valueOf(display));
                } else if (strValueC.equals("")) {
                    float valueA = Float.parseFloat(strValueA);
                    float valueB = Float.parseFloat(strValueB);
                    float valueD = Float.parseFloat(strValueD);
                    float totalC = valueB * (valueA / valueB);
                    String display = "Answer:\n   Ratio A: " + valueA + "  Ratio B: " + valueB + "  Missing Number A: " + totalC + "  Number B: " + valueD;
                    Display_Scrn.setText(String.valueOf(display));
                }
            }
        });
    }

    /*private void Calculate(){
        Button CalcBtn = (Button) findViewById(R.id.CalculateButton);
        CalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valueA = Integer.parseInt(Ratio_A.getText().toString());
                int valueB = Integer.parseInt(Ratio_B.getText().toString());
                int valueC = Integer.parseInt(Ratio_C.getText().toString());
                int valueD = Integer.parseInt(Ratio_D.getText().toString());
                int totalD = valueC * (valueB / valueA);
                Display_Scrn.setText(String.valueOf(totalD));



            }
        });

    } */

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
