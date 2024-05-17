package com.example.practiceapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView txt;

    protected int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.text1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void updateImage(View v) {
        ImageButton btn = (ImageButton) v;
        if (num == 1) {
            btn.setImageResource(R.drawable.calcifer);
            num = 0;
            updateText("Cat");
        } else {
            btn.setImageResource(R.drawable.catbus);
            num = 1;
            updateText("Calcifer");
        }
        btn.setBackgroundColor(Color.TRANSPARENT);
        v.setEnabled(false);
    }
    protected void updateText(String turn) {
         txt.setText("Next for : "+turn);
    }
}