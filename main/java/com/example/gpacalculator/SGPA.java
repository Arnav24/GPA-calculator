package com.example.gpacalculator;

import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SGPA {
    public int[] credit;
    public int[] marks;

    public SGPA(int[] credit, int[] marks) {
        this.credit = credit;
        this.marks = marks;
    }

    private int toPoint(int marks){
        if(marks ==0)
            return 0;
        else if(marks==100)
            return 10;
        return (marks/10)+1;
    }

    public float calculate() {
        float ans=0,sum=0;
        for(int i=0;i<credit.length;i++)
        {
            ans+=credit[i]*toPoint(marks[i]);
            sum+=credit[i];
        }
        return ans/sum;
    }
    public static int toInt(EditText sub){
        int out=0;
        if (sub.getText().toString().equals("")) {
            //Text is empty do nothing
        } else {
            //parse your value
            out = Integer.parseInt(sub.getText().toString());
        }
        return out;
    }
}
