package com.example.gpacalculator;

import android.content.Intent;
import android.os.Parcelable;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public Button button;
    public static String name;
    public String USN;
    public EditText nameField;
    public EditText USNField;
    private static int bCode=-1;
    public static int getbCode()
    {
        return bCode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameField=(EditText)findViewById(R.id.nameField);
        USNField=(EditText)findViewById(R.id.USN);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=nameField.getText().toString();
                USN=USNField.getText().toString().toUpperCase();
                if (USNField.getText().toString().trim().equalsIgnoreCase("")) {
                    USNField.setError("This field can not be blank");
                    return;
                }

                if(USN.charAt(5)=='E'&&USN.charAt(6)=='C')
                {
                    bCode=2;
                }
                if(USN.charAt(5)=='C'&&USN.charAt(6)=='S')
                {
                    bCode=0;
                }
                if(USN.charAt(5)=='C'&&USN.charAt(6)=='V')
                {
                    bCode=1;
                }
                if(USN.charAt(5)=='E'&&USN.charAt(6)=='E')
                {
                    bCode=3;
                }
                if(USN.charAt(5)=='I'&&USN.charAt(6)=='S')
                {
                    bCode=4;
                }
                if(USN.charAt(5)=='E'&&USN.charAt(6)=='I')
                {
                    bCode=5;
                }
                if(USN.charAt(5)=='T'&&USN.charAt(6)=='E')
                {
                    bCode=6;
                }
                if(USN.charAt(5)=='M'&&USN.charAt(6)=='E')
                {
                    bCode=7;
                }
                if(USN.charAt(5)=='I'&&USN.charAt(6)=='M')
                {
                    bCode=8;
                }
                if (nameField.getText().toString().trim().equalsIgnoreCase("")) {
                    nameField.setError("This field can not be blank");
                    return;
                }
                if (USNField.getText().toString().length()!=10) {
                    USNField.setError("Enter valid USN");
                    if(bCode==-1)
                        USNField.setError("Your branch is not supported");
                    return;
                }
                Intent intent=new Intent(MainActivity.this,semester.class);
                startActivity(intent);
            }
        });

    }
}