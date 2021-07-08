package com.example.gpacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {
    TextView ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        ans=findViewById(R.id.result);
        ans.setText(getIntent().getStringExtra("res"));
    }
}