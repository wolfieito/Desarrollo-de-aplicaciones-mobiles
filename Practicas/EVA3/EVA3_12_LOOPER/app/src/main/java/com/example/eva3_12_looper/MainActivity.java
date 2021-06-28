package com.example.eva3_12_looper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwTexto;
    //looper es un ciclo que procesa los mensajes al hilo principal


    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            txtVwTexto.append((String)msg.obj+"\n");
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++){
                try {
                    Thread.sleep(1000);
                    Message message = handler.obtainMessage(100,"i = "+i);
                    handler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwTexto = findViewById(R.id.txtVwTexto);
        Thread thread = new Thread(runnable);
        thread.start();
    }


}