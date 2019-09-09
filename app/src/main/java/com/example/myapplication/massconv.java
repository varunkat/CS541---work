package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class massconv extends AppCompatActivity {
    Spinner fromspinner1;
    TextView from1;
    Spinner tospinner1;
    TextView to1;
    TextView fromtv1;
    TextView totv1;
    EditText entval1;
    EditText result1;
    int Hold1;
    int cold1;

    String[] fromoptions1 = {"grams", "ounces", "Kilograms", "pounds"};
    String[] tooptions1 = {"grams", "ounces", "Kilograms", "pounds"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massconv);

        fromspinner1 = findViewById(R.id.fromspinner1);
        tospinner1 = findViewById(R.id.tospinner1);
        entval1 = findViewById(R.id.entval1);

        fromtv1 = findViewById(R.id.fromtv1);
        totv1 = findViewById(R.id.totv1);

        //from array adapter
        ArrayAdapter From1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, fromoptions1);
        From1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fromspinner1.setAdapter(From1);

        fromspinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

                fromtv1.setText(parent.getItemAtPosition(position).toString());
                Hold1 = fromspinner1.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    //to array adapter
    ArrayAdapter To1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tooptions1);
        To1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tospinner1.setAdapter(To1);
        tospinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long k) {

            totv1.setText(parent.getItemAtPosition(pos).toString());
            cold1 = tospinner1.getSelectedItemPosition();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });
    }
    public void disp1(android.view.View view) {
        if (entval1.getText().length() == 0) {
            entval1.setError("please enter a value");
        } else {

            double val2 = new Double(entval1.getText().toString());
            if (Hold1 == 0 && cold1 == 0 || Hold1 == 1 && cold1 == 1 || Hold1 == 2 && cold1 == 2 || Hold1 == 3 && cold1 == 3)
                val2 = val2;
//cms constant
            if (Hold1 == 0 && cold1 == 1)
                val2 = val2*0.035;
            if (Hold1 == 0 && cold1 == 2)
                val2 = val2 / 1000;
            if (Hold1 == 0 && cold1 == 3)
                val2 = val2*0.0022;

// meters constant
            if (Hold1 == 1 && cold1 == 0)
                val2 = val2/0.035;
            if (Hold1 == 1 && cold1 == 2)
                val2 = val2*0.028;
            if (Hold1 == 1 && cold1 == 3)
                val2 = val2*0.062;

            // kms constant
            if (Hold1 == 2 && cold1 == 0)
                val2 = val2 * 1000;
            if (Hold1 == 2 && cold1 == 1)
                val2 = val2/0.028;
            if (Hold1 == 2 && cold1 == 3)
                val2 = val2*2.20;

            //inches constant
            if (Hold1 == 3 && cold1 == 0)
                val2 = val2 / 0.0022;
            if (Hold1 == 3 && cold1 == 1)
                val2 = val2 / 0.062;
            if (Hold1 == 3 && cold1 == 2)
                val2 = val2 / 2.20;


            entval1.setText(new Double(val2).toString());
            //  result.setText(new Double(val2).toString());

        }
    }

}

