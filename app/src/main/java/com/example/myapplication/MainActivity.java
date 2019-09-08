package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button IMC;
    private Button curconv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IMC = (Button) findViewById(R.id.IMC);

        IMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain2Activity();
            }
        });

        curconv = (Button) findViewById(R.id.curconv);
        curconv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencurrencyconv();
            }
        });
    }

    public void openMain2Activity() {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    public void opencurrencyconv() {
        Intent intent = new Intent(this,currencyconv.class);
        startActivity(intent);
    }

}
