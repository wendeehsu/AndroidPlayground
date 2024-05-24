package com.example.practiceapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class GameFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        ConstraintLayout frame = view.findViewById(R.id.gameFrame);
        for (int i = 0; i < frame.getChildCount(); i++) {
            ImageButton btn = (ImageButton) frame.getChildAt(i);
            btn.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        // Call your updateImage method when the button is clicked
        updateImage(v);
    }
    public int num = 0;

    public void updateImage(View v) {
        ImageButton btn = (ImageButton) v;
        if (num == 1) {
            btn.setImageResource(R.drawable.calcifer);
            num = 0;
        } else {
            btn.setImageResource(R.drawable.catbus);
            num = 1;
        }
        btn.setBackgroundColor(Color.TRANSPARENT);
        v.setEnabled(false);
    }

}