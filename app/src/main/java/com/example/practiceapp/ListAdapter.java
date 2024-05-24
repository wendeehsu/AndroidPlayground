package com.example.practiceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ImageData> {
    public ListAdapter(@NonNull Context context, ArrayList<ImageData> dataList) {
        super(context, R.layout.list_item, dataList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ImageData imageData = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = view.findViewById(R.id.listImage);
        TextView textView = view.findViewById(R.id.listText);
        imageView.setImageResource(imageData.image);
        textView.setText(imageData.name);

        return view;
    }
}
