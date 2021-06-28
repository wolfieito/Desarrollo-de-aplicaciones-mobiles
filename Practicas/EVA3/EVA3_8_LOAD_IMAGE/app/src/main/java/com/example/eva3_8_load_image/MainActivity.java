package com.example.eva3_8_load_image;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwLoad;
    Bitmap bitmap;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //AQUI CAMBIAMOS LA IMAGEN
            //3-hacemos lo que queremos
            imgVwLoad.setImageBitmap(bitmap);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwLoad = findViewById(R.id.imgVwLoad);
        //METER ESTA LINEA EN UN HILO DE EJECUCION
        //cuando hacemos un proceso de conexion a un servidor externo no puede ser tan directamente, de a fuerzas debe meterse en hilos de ejecucion
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                //AQUI HACEMOS UNA CONEXION
                //la descarga en un hilo
                bitmap = descargarImagen("https://static.zerochan.net/Makise.Kurisu.full.1368198.jpg");
                Message msg = handler.obtainMessage();//1-se obtiene el mensaje
                handler.sendMessage(msg);//2-se envia el mensaje, si no le pones nada solo le notificas algo
            }
        };
        thread.start();
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