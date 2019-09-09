package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

public class currencyconv extends AppCompatActivity {

    public static double toINR(double i){
        return (i*72);
    }
    public static double toEUR(double e) {
        return (e*1.9);
    }
    public static double toAED(double a){
            return (a*3.67);
    }
    public static double toAUD(double u) {
        return (u*1.47);
    }
    EditText temp1;
    RadioButton toINR;
    RadioButton toEUR;
    RadioButton toAED;
    RadioButton toAUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currencyconv);
        temp1 = (EditText)findViewById(R.id.editText3);
        toINR = (RadioButton)findViewById(R.id.INR);
        toEUR = (RadioButton)findViewById(R.id.EUR);
        toAED = (RadioButton)findViewById(R.id.AED);
        toAUD = (RadioButton)findViewById(R.id.AUD);
    }

    public void display(android.view.View view) {
        if (temp1.getText().length() == 0) {
            temp1.setError("please enter a value");
        }
        else
        {
        double value1 = new Double(temp1.getText().toString());
        if(toINR.isChecked())
            value1 = currencyconv.toINR(value1);
        if(toEUR.isChecked())
            value1 = currencyconv.toEUR(value1);
        if(toAED.isChecked())
            value1 = currencyconv.toAED(value1);
        else
            value1 = currencyconv.toAUD(value1);

        temp1.setText(new Double(value1).toString());
    }
}}
