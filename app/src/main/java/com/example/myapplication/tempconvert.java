package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class tempconvert extends AppCompatActivity {
    private Object View;

    public static double celsius2farenheit(double f){
             return (f*9/5)+32;
    }
    public static double farenheit2celcius(double c) {
        return (c-32)*5/9;
    }

    EditText temp;
    RadioButton FtoC;
    RadioButton CtoF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempconvert);
        temp = (EditText)findViewById(R.id.editText);
        FtoC = (RadioButton)findViewById(R.id.radioButton);
        CtoF = (RadioButton)findViewById(R.id.radioButton2);


    }

    public void convert(android.view.View view) {
        double value = new Double(temp.getText().toString());
        if(FtoC.isChecked())
            value = tempconvert.farenheit2celcius(value);
        else
            value = tempconvert.celsius2farenheit(value);

        temp.setText(new Double(value).toString());
    }
}

