package com.example.practiceapp;

import static androidx.core.content.ContextCompat.getDrawable;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    ListView listView;
    String [] movieNames = { "Spirited Away", "My Neighbor Totoro",
            "Princess Mononoke", "Howl's Moving Castle",
            "Ponyo", "Kiki's Delivery Service",
            "Castle in the Sky", "Nausicaa of the Valley of the Wind"
    };

    Dialog addMovieDialog;

    int [] movieImages = { R.drawable.spirit, R.drawable.totoro,
            R.drawable.mononoke, R.drawable.howl,
            R.drawable.ponyo, R.drawable.kiki,
            R.drawable.sky, R.drawable.nausicaa
    };

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // construct list content
        ArrayList<ImageData> data = new ArrayList<ImageData>();
        for (int i = 0; i < movieNames.length; i++) {
            data.add(new ImageData(movieNames[i], movieImages[i]));
        }

        listView = (ListView) view.findViewById(R.id.movieList);
        ListAdapter arr = new ListAdapter(getActivity(), data);
        listView.setAdapter(arr);

        addMovieDialog = new Dialog(getActivity());
        addMovieDialog.setContentView(R.layout.image_dialog);
        addMovieDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addMovieDialog.getWindow().setBackgroundDrawable(getDrawable(getActivity(), R.drawable.dialog_bg));
        addMovieDialog.setCancelable(true);

        Button submitBtn = addMovieDialog.findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMovieDialog.dismiss();
            }
        });

        ExtendedFloatingActionButton fab = view.findViewById(R.id.addBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMovieDialog.show();
            }
        });

        return view;
    }
}