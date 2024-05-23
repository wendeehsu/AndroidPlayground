package com.example.practiceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeFragment extends Fragment {

    ListView listView;
    String [] movieNames = {  "Spirited Away", "My Neighbor Totoro",
            "Princess Mononoke", "Howl's Moving Castle",
            "Ponyo", "Kiki's Delivery Service",
            "Castle in the Sky", "Nausicaa of the Valley of the Wind"
    };

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listView = (ListView) view.findViewById(R.id.movieList);
        ArrayAdapter<String> arr = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                movieNames);
        listView.setAdapter(arr);
        return view;
    }
}