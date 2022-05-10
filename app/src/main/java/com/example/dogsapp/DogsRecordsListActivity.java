package com.example.dogsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class DogsRecordsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs_records_list);
        Intent DogsListIntent = getIntent();
        Bundle args = DogsListIntent.getBundleExtra("dogsData");
        ArrayList<Dogs> dogs = (ArrayList<Dogs>) args.getSerializable("dogsArrayList");
        RecyclerView rv = (RecyclerView) findViewById(R.id.dogslist);

        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(decoration);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        DogsAdapter adapter = new DogsAdapter(dogs);
        rv.setAdapter(adapter);
    }
}