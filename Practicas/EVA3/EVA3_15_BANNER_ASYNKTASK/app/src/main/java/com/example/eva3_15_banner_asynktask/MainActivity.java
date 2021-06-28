package com.example.eva3_15_banner_asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwBanner;
    SeekBar skBrSleep;
    int vel, iCont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBanner = findViewById(R.id.imgVwBanner);
        skBrSleep = findViewById(R.id.skBrSleep);
        MiClaseAsincrona miCA = new MiClaseAsincrona();
        miCA.execute((2500-vel));
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

    class MiClaseAsincrona extends AsyncTask<Integer,Integer,Void> {
        //1ER
        //puede interactuar con la ui
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        //puede interactuar con la ui


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            imgVwBanner.setImageResource(values[0]);
        }

        //NO SE PUEDE INTERACTUAR CON LA UI
        //2DA
        @Override
        protected Void doInBackground(Integer... integers) {//EQUIVALENET A run() en un Thread
            int sleep = integers[0];
            while (true){
                try {
                    if(iCont==0){
                        Thread.sleep((sleep));
                        publishProgress(R.drawable.f1);
                        iCont++;
                    }
                    if(iCont==1){
                        Thread.sleep((sleep));
                        publishProgress(R.drawable.f2);
                        iCont++;
                    }
                    else{
                        iCont=0;
                        Thread.sleep((sleep));
                        publishProgress(R.drawable.f3);
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
            return null;
        }
    }
}
