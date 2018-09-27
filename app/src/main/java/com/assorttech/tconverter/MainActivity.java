package com.assorttech.tconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView showMeResult;
    private EditText enterTemp;
    private Button celBtn;
    private Button FarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMeResult = (TextView) findViewById(R.id.viewTemp);
        enterTemp = (EditText) findViewById(R.id.temp);
        celBtn = findViewById(R.id.cel);
        FarBtn = findViewById(R.id.far);

        celBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextVal = enterTemp.getText().toString();
                if(editTextVal.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please enter temprature",Toast.LENGTH_LONG).show();
                }
                else{
                    double dEditText=Double.parseDouble(editTextVal);
                    double convertedVal=convertToCel(dEditText);
                    double finalVal=Math.round(convertedVal*100.0/100.0);
                    String result=String.valueOf(convertedVal);
                    showMeResult.setText(result);

                }

            }

        });
        FarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextVal = enterTemp.getText().toString();
                if(editTextVal.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please enter temprature",Toast.LENGTH_LONG).show();
                }
                else{
                    double dEditText=Double.parseDouble(editTextVal);
                    double convertedVal=convertToFar(dEditText);
                    double finalVal=Math.round(convertedVal*100.0/100.0);
                    String result=String.valueOf(convertedVal);
                    showMeResult.setText(result);

                }

            }
        });

    }

    public double convertToCel(double farVal) {
        double resultVal=(farVal-32)*5/9;
        return resultVal;

    }
    public double convertToFar(double celVal)
    {
        double resultVal=(celVal)*9/5+32;
        return resultVal;
    }
}




