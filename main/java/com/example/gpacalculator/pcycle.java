package com.example.gpacalculator;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class pcycle extends AppCompatActivity {
    public EditText phy,math,eee,civ,caed,eeel,phyl,eng;
     public Button calc;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcycle);
        calc=findViewById(R.id.calc);
        phy=findViewById(R.id.phy);
        math=findViewById(R.id.math);
        eee=findViewById(R.id.eee);
        civ=findViewById(R.id.civ);
        caed=findViewById(R.id.caed);
        eeel=findViewById(R.id.eeeLab);
        phyl=findViewById(R.id.phyLab);
        eng=findViewById(R.id.eng);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] credit={4,4,3,3,3,1,1,1};
                int[] marks={toInt(phy),toInt(math),toInt(eee),toInt(civ),toInt(caed),toInt(eeel),toInt(phyl),toInt(eng)};
                SGPA sgpa=new SGPA(credit,marks);
                Log.i("SGPA:",String.valueOf(sgpa.calculate()));
//                Intent intent=new Intent(pcycle.this,ResultPage.class);
//                intent.putExtra("res", String.valueOf(sgpa.calculate()));
//                startActivity(intent);
                LinearLayout ll=findViewById(R.id.nameOfSub);
                TextView textView=new TextView(pcycle.this);
                LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                textView.setText("Text");
                textView.setTypeface(null, Typeface.BOLD);
                textView.setTextColor(Color.BLACK);
                textView.setGravity(Gravity.CENTER);
                p.setMargins(10,10,10,10);
                ll.addView(textView);

                LinearLayout m=findViewById(R.id.marks);
                EditText editText=new EditText(pcycle.this);
                editText.setHint("Hello");
                editText.setBackgroundColor(Color.parseColor("#11000000"));
                m.addView(editText);
            }
        });

    }
}