package com.example.eva3_7_handler_banner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imVwBanner;
    Thread tBanner;
    int iCont = 0;
    //A TRAVES DE UN HANDLER ( METODO HANDLERMESSAJE) INTERACTUAR CON LA UI
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //INTERACTUAMOS CON LA UI

            if(iCont == 0){
                imVwBanner.setImageResource(R.drawable.f1);
                iCont++;
            }else if(iCont == 1){
                imVwBanner.setImageResource(R.drawable.f2);
                iCont++;
            }else{
                imVwBanner.setImageResource(R.drawable.f3);
                iCont=0;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imVwBanner = findViewById(R.id.imVwBanner);

        tBanner = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        Thread.sleep(1000);
                        //Esto solo notifica al handler, no queremos datos
                        //SOLICITAR EL MENSAJE
                        //solo debemos notificar que queremos el cambio, entonces se envia sin datos
                        Message message = handler.obtainMessage();
                        //ENVIAR EM MENSAJE
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        };
        tBanner.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tBanner.interrupt();
    }
}