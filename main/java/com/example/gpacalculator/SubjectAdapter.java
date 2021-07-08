package com.example.gpacalculator;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SubjectAdapter extends ArrayAdapter<String> {
    public SubjectAdapter(Activity context,String[] subjects){
        super(context,0,subjects);
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        View listItemView=convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listview, parent, false);
        }
        String subject=getItem(position);
        TextView sub_text=listItemView.findViewById(R.id.subject);
        sub_text.setText(subject);
        return listItemView;
    }
}
