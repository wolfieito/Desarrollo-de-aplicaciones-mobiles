package com.example.eva3_11_load_image_post;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    Bitmap bitmap;
    ImageView imgVwLoad;
    Handler handler = new Handler();
    Thread thread;
    //TRABAJO PESADO EN SEGUNDO PLANO
    //handler ---> loop (cambio de android para manejo de ui en hilos)
    Runnable background = new Runnable() {
        @Override
        public void run() {
            while (true){
                    bitmap = descargarImagen("https://static.zerochan.net/Makise.Kurisu.full.1368198.jpg");
                    handler.post(foreground);
            }
        }
    };
    //TRABAJO CON LA UI
    Runnable foreground = new Runnable() {
        @Override
        public void run() {
            imgVwLoad.setImageBitmap(bitmap);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwLoad = findViewById(R.id.imgVwLoad);
        thread = new Thread(background);
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }

    private Bitmap descargarImagen(String url){
        try {
            InputStream inputStream = (InputStream) new URL(url).getContent();//nos da la imagen sin formato, se debe hacer la conversion
            bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}