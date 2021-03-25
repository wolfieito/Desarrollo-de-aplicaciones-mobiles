package com.example.eva_1_5_findview_2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgVwMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//obj = new class();
        //Debe ser despues del content view
        imgVwMostrar = findViewById(R.id.imgVwMostrar);
        imgVwMostrar.setImageResource(R.drawable.makise);
    }
}