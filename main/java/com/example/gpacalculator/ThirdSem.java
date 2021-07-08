package com.example.gpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ThirdSem extends AppCompatActivity {

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("sub_n_credit.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_sem);

        int branch=MainActivity.getbCode();
        Button calc;

        try
        {
            JSONObject jsonObject=new JSONObject(loadJSONFromAsset());
            JSONObject sel= jsonObject.getJSONArray("thirdSem").getJSONObject(branch);
            JSONArray subJSON=sel.getJSONArray("subjects");
            JSONArray credJSON=sel.getJSONArray("credits");
            String[] subjects=new String[subJSON.length()];
            final int[] credit=new int[credJSON.length()];
            SubjectAdapter subjectAdapter=new SubjectAdapter(this,subjects);
            final ListView listView=findViewById(R.id.list);
            listView.setAdapter(subjectAdapter);
            for(int i = 0; i < subJSON.length(); i++)
            subjects[i] = subJSON.getString(i);
            for(int i = 0; i < credJSON.length(); i++)
                credit[i] = credJSON.getInt(i);
            calc=findViewById(R.id.calc);
            calc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int[] marks=new int[listView.getAdapter().getCount()];

                    for (int i = 0; i < listView.getAdapter().getCount(); i++) {
                        View viewSubject = listView.getChildAt(i);
                        EditText box = viewSubject.findViewById(R.id.box);
                        marks[i]=SGPA.toInt(box);
                    }

                    SGPA sgpa=new SGPA(credit,marks);
                    Log.i("SGPA:",String.valueOf(sgpa.calculate()));
                    Intent intent=new Intent(ThirdSem.this,ResultPage.class);
                    intent.putExtra("res", String.valueOf(sgpa.calculate()));
                    startActivity(intent);
                }

            });
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }


    }
}