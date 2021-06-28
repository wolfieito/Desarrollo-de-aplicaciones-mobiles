package com.example.eva3_9_handler_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwMostar;
    Handler handler = new Handler();
    Thread thread;
    //TRABAJO PESADO EN SEGUNDO PLANO
    //handler ---> loop (cambio de android para manejo de ui en hilos)
    Runnable background = new Runnable() {
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
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
            txtVwMostar.append("Hola mundo \n");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMostar = findViewById(R.id.txtVwMostrar);
        thread = new Thread(background);
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}