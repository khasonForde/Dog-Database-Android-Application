package com.example.dogsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DogsRecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs_records);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("dogsData");
        ArrayList<Dogs> dogs = (ArrayList<Dogs>) args.getSerializable("dogsArrayList");
        TextView textView = (TextView)findViewById(R.id.textView);

        textView.setText("");
        for (Dogs d: dogs){
            textView.append(d.toString());
            textView.append("\n");
        }
    }
}