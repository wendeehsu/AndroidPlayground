package com.example.practiceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    ListView listView;
    String [] movieNames = { "Spirited Away", "My Neighbor Totoro",
            "Princess Mononoke", "Howl's Moving Castle",
            "Ponyo", "Kiki's Delivery Service",
            "Castle in the Sky", "Nausicaa of the Valley of the Wind"
    };

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
        return view;
    }
}