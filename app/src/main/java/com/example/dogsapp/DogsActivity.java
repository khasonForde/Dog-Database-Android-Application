package com.example.dogsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class DogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("dogsData");
        ArrayList<Dogs> dogs = (ArrayList<Dogs>) args.getSerializable("dogsArrayList");
        Random rand = new Random();
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setText("");
        for (int i = 0; i < 6; i++){
            textView2.append(dogs.get(rand.nextInt(dogs.size())).bark() + "\n");
        }
        for (int i =0; i < 6; i++){
            textView2.append(dogs.get(rand.nextInt(dogs.size())).growl() + "\n");
        }
    }
}
