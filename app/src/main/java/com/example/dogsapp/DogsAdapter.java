package com.example.dogsapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder> {
    // Store a member variable for the products
    private ArrayList<Dogs> dogsDataset;

    // Pass in the dogs array into the constructor
    public DogsAdapter(ArrayList<Dogs> dogs) {
        dogsDataset = dogs;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
// for any view that will be set as you render a row
        public TextView textViewDogName, textViewDogBreed, textViewDogWeightCategory;

        // Constructor accepts the entire item row
        public ViewHolder(View itemView) {
            super(itemView);
            textViewDogName = (TextView) itemView.findViewById(R.id.textViewDogName);
//HERE: get hold of the other two TextView’s in row_layout and assign them to corresponding the variables
            textViewDogBreed = (TextView) itemView.findViewById(R.id.textViewDogBreed);
            textViewDogWeightCategory = (TextView) itemView.findViewById(R.id.textViewDogWeightCategory);
        }
    }

    @Override
    public DogsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
// Inflate the custom layout
        View dogView = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(dogView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DogsAdapter.ViewHolder viewHolder, int position) {
// Get the data row based on position
        Dogs dog = dogsDataset.get(position);
// Set item views for the given data row
        viewHolder.textViewDogName.setText(dog.name);
//HERE: set the text of TextViews textViewDogBreed and textViewDogWeightCategory with
//the breed and wthCategory from the dog object
        viewHolder.textViewDogBreed.setText(dog.breed);
        viewHolder.textViewDogWeightCategory.setText(dog.wthCategory());
        if (dog.wthCategory() == Dogs.UNDERWEIGHT) {
            viewHolder.textViewDogWeightCategory.setTextColor(Color.rgb(200, 0, 0));
        } else if (dog.wthCategory() == Dogs.HEALTHY) {
            viewHolder.textViewDogWeightCategory.setTextColor(Color.rgb(0, 200, 0));
        } else {
            viewHolder.textViewDogWeightCategory.setTextColor(Color.rgb(0, 0, 200));
        }
    }
    @Override
    public int getItemCount() {
        return dogsDataset.size();
    }
}

