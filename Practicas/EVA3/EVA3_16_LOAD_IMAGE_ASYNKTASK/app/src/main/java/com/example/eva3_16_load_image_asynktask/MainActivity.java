package com.example.eva3_16_load_image_asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwlOAD;
    Bitmap bitmap;

    //Thread: tareas de corta duracion.
    //Service: tareas de larga duracion.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwlOAD = findViewById(R.id.imgVwLoad);
        MiClaseAsincrona miCA = new MiClaseAsincrona();
        miCA.execute();
    }

    //INTERGER DE ENTRADA
    //STRING ENMEDIO
    //VOID DE SALIDA
    class MiClaseAsincrona extends AsyncTask<Bitmap, Void, Void> {

        //1ER
        //puede interactuar con la ui
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //puede interactuar con la ui
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            imgVwlOAD.setImageBitmap(bitmap);
        }

        //puede interactuar con la ui

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        //NO SE PUEDE INTERACTUAR CON LA UI
        //2DA
        @Override
        protected Void doInBackground(Bitmap... bitmaps) {
            bitmap = descargarImagen("https://static.zerochan.net/Makise.Kurisu.full.1368198.jpg");
            return null;
        }
    }

    private Bitmap descargarImagen(String url) {
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