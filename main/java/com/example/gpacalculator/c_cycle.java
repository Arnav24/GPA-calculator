package com.example.gpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

public class c_cycle extends AppCompatActivity {
    public int toInt(EditText sub){
        int out=0;
        if (sub.getText().toString().equals("")) {
            //Text is empty do nothing
        } else {
            //parse your value
            out = Integer.parseInt(sub.getText().toString());
        }
        return out;
    }
    Button calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_cycle);
        String[] subjects={"Calculus and Linear Algebra","Engineering Chemistry","C Programming for Problem Solving",
        "Basic Electronics","Elements of Mechanical Engineering","Engineering Chemistry Lab","C Programming Lab","Technical English"};
        SubjectAdapter subjectAdapter=new SubjectAdapter(this,subjects);

        final ListView listView=findViewById(R.id.list);
        listView.setAdapter(subjectAdapter);
        calc=findViewById(R.id.calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] marks=new int[listView.getAdapter().getCount()];

                for (int i = 0; i < listView.getAdapter().getCount(); i++) {
                    View viewSubject = listView.getChildAt(i);
                    EditText box = viewSubject.findViewById(R.id.box);
                    marks[i]=toInt(box);
                }
                int[] credit={4,4,3,3,3,1,1,1};
                SGPA sgpa=new SGPA(credit,marks);
                Log.i("SGPA:",String.valueOf(sgpa.calculate()));
                Intent intent=new Intent(c_cycle.this,ResultPage.class);
                intent.putExtra("res", String.valueOf(sgpa.calculate()));
                startActivity(intent);
            }
        });

    }
}