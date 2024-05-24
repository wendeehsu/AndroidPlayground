package com.example.practiceapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    LabFragment labFragment = new LabFragment();
    GameFragment gameFragment = new GameFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.navFrame, homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.navFrame, homeFragment).commit();
                } else if (id == R.id.lab) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.navFrame, labFragment).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.navFrame, gameFragment).commit();
                }
                return true;
            }
        });

    }
}