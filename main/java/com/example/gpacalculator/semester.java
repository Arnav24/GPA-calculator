package com.example.gpacalculator;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class semester extends AppCompatActivity {
    public Button button;
    public TextView nameField;
    public Button popupbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);
        nameField=findViewById(R.id.nameField);

        String name=MainActivity.name;
        nameField.setText("Welcome "+name+" !");

        button = (Button) findViewById(R.id.home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(semester.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(semester.this, popup1stsem.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(semester.this, MainActivity4.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(semester.this, ThirdSem.class);
                intent.putExtra("Branch",1);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(semester.this, MainActivity6.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(semester.this, MainActivity7.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(semester.this, MainActivity8.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(semester.this, MainActivity9.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(semester.this, MainActivity10.class);
                startActivity(intent);
            }
        });
        }
    }
