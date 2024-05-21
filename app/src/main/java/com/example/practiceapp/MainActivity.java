package com.example.practiceapp;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    LabFragment labFragment = new LabFragment();
    GameFragment gameFragment = new GameFragment();

    public int num = 0;


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
                return false;
            }
        });
    }

    public void updateImage(View v) {
        Log.d("click", "updateImage: clicked");
        ImageButton btn = (ImageButton) v;
        if (num == 1) {
            btn.setImageResource(R.drawable.calcifer);
            num = 0;
//                updateText("Cat");
        } else {
            btn.setImageResource(R.drawable.catbus);
            num = 1;
//                updateText("Calcifer");
        }
        btn.setBackgroundColor(Color.TRANSPARENT);
        v.setEnabled(false);
    }
//        protected void updateText(String turn) {
//            txt.setText("Next for : "+turn);
//        }
}