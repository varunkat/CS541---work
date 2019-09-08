package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button button6;
    private Button length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        button6 = (Button) findViewById(R.id.button6);
        length = (Button) findViewById(R.id.length);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opentempconvert();
            }
        });
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlenconv();
            }
        });
    }

    public void opentempconvert() {
        Intent intent = new Intent(this,tempconvert.class);
        startActivity(intent);
    }

    public void openlenconv() {
        Intent intent = new Intent(this,lenconv.class);
        startActivity(intent);
    }

}
