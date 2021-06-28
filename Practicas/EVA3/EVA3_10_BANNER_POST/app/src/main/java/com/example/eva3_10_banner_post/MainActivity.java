package com.example.eva3_10_banner_post;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwBanner;
    Handler handler = new Handler();
    Thread thread;
    SeekBar skBrSleep;
    int iCont = 0, vel;
    //TRABAJO PESADO EN SEGUNDO PLANO
    //handler ---> loop (cambio de android para manejo de ui en hilos)
    Runnable background = new Runnable() {
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep((2500-vel));
                    handler.post(foreground);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    };
    //TRABAJO CON LA UI
    Runnable foreground = new Runnable() {
        @Override
        public void run() {
            if(iCont == 0){
                imgVwBanner.setImageResource(R.drawable.f1);
                iCont++;
            }else if(iCont == 1){
                imgVwBanner.setImageResource(R.drawable.f2);
                iCont++;
            }else{
                imgVwBanner.setImageResource(R.drawable.f3);
                iCont=0;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skBrSleep = (SeekBar) findViewById(R.id.skBrSleep);
        imgVwBanner = findViewById(R.id.imgVwBanner);
        thread = new Thread(background);
        thread.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        skBrSleep.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vel = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}