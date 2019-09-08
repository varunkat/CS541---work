package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class lenconv extends AppCompatActivity {



    Spinner fromspinner;
    TextView from;
    Spinner tospinner;
    TextView to;
    TextView fromtv;
    TextView totv;
    EditText entval;
    EditText result;
    int Hold;
    int cold;

    String[] fromoptions = {"centimeter", "meter", "kilometer", "inches"};
    String[] tooptions = {"centimeter", "meter", "kilometer", "inches"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenconv);

        fromspinner = findViewById(R.id.fromspinner);
        tospinner = findViewById(R.id.tospinner);
        entval = findViewById(R.id.entval);

        fromtv = findViewById(R.id.fromtv);
        totv = findViewById(R.id.totv);

        //from array adapter
        ArrayAdapter From = new ArrayAdapter(this, android.R.layout.simple_spinner_item, fromoptions);
        From.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fromspinner.setAdapter(From);

        fromspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

                fromtv.setText(parent.getItemAtPosition(position).toString());
                Hold = fromspinner.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //to array adapter
        ArrayAdapter To = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tooptions);
        From.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tospinner.setAdapter(To);
        tospinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long k) {

                totv.setText(parent.getItemAtPosition(pos).toString());
                cold = tospinner.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void disp(android.view.View view) {
        if (entval.getText().length() == 0) {
            entval.setError("please enter a value");
        } else {

            double val1 = new Double(entval.getText().toString());
            if (Hold == 0 && cold == 0 || Hold == 1 && cold == 1 || Hold == 2 && cold == 2 || Hold == 3 && cold == 3)
                val1 = val1;
//cms constant
            if (Hold == 0 && cold == 1)
                val1 = val1 / 100;
            if (Hold == 0 && cold == 2)
                val1 = val1 / 100000;
            if (Hold == 0 && cold == 3)
                val1 = val1 * 0.39;

// meters constant
            if (Hold == 1 && cold == 0)
                val1 = val1 * 100;
            if (Hold == 1 && cold == 2)
                val1 = val1 / 1000;
            if (Hold == 1 && cold == 3)
                val1 = val1 * 39.3;

            // kms constant
            if (Hold == 2 && cold == 0)
                val1 = val1 * 100000;
            if (Hold == 2 && cold == 1)
                val1 = val1 * 1000;
            if (Hold == 2 && cold == 3)
                val1 = val1 * 39370.1;

            //inches constant
            if (Hold == 3 && cold == 0)
                val1 = val1 / 0.39;
            if (Hold == 3 && cold == 1)
                val1 = val1 / 39.3;
            if (Hold == 3 && cold == 2)
                val1 = val1 / 39370.1;


            entval.setText(new Double(val1).toString());
            //  result.setText(new Double(val2).toString());

        }
    }
}
