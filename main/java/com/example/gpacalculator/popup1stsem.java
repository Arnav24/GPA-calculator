package com.example.gpacalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class popup1stsem extends Activity
{
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(popup1stsem.this, semester.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(popup1stsem.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(popup1stsem.this, c_cycle.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(popup1stsem.this, pcycle.class);
                startActivity(intent);
            }
        });
    }
}