package com.example.dogsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    ArrayList<Dogs> dogs = new ArrayList<Dogs>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scanner inFile = new Scanner(this.getResources().openRawResource(R.raw.dogs));
        String name, breed;
        int age;
        float weight, height;
        while (inFile.hasNext( ) )
        {
            name = inFile.next();
            age = inFile.nextInt();
            //HERE: continue reading the rest of the data about the dog
            breed = inFile.next();
            weight = inFile.nextFloat();
            height = inFile.nextFloat();

            //HERE: create a dog object with all the values just read
            Dogs dog= new Dogs(name, age, breed, weight, height);
            //HERE: add the object to the ArrayList "dogs"
            dogs.add(dog);
        }
    }

    public void DogsRecordsButton(View v) {
        Intent i = new Intent(this, DogsRecordsListActivity.class);
        Bundle dogsData = new Bundle();
        dogsData.putSerializable("dogsArrayList", (Serializable) dogs);
        i.putExtra("dogsData", dogsData);
        startActivity(i);
    }

        public void DogsActivityButton(View v) {
            Intent DogsActivtityIntent = new Intent(this, DogsActivity.class);
            Bundle dogsData = new Bundle();
            dogsData.putSerializable("dogsArrayList", (Serializable) dogs);
            DogsActivtityIntent.putExtra("dogsData", dogsData);
            startActivity(DogsActivtityIntent);
    }
}