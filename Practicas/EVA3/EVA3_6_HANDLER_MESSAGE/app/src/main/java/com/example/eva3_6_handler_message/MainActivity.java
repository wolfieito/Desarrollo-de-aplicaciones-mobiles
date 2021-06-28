package com.example.eva3_6_handler_message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwMensaje;
    Thread thread;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //AQUI PODEMOS MODIFICAR LA INTERFAZ GRAFICA
            //TRABAJO LIGERO --> UNA TAREA INTENSA VA A TRABAR LA INTERFAZ GRAFICA (UI)
            String cade = (String)msg.obj;
            int what = msg.what;
            txtVwMensaje.append("El hilo = "+what+" imprime: "+cade+"\n");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMensaje = findViewById(R.id.txtVwMensaje);
        //txtVwMensaje.setText("HOLA MUNDO!!");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(true){
                    try {
                        Thread.sleep(1000);//Para que no sea tan pesado
                        String cade = "i = " + i;
                        i++;
                        //SOLICITAMOS UN MENSAJE
                        //PONER INFO EN EL MENSAJE
                        Message message = handler.obtainMessage(1000, cade);//se le puede poner datos o no
                        //DEVOLVER EL MENSAJE
                        handler.sendMessage(message);
                        Log.wtf("runnable: ", cade);
                    }
                        catch (InterruptedException e) {
                        break;
                    }
                }
            }
        };
        thread = new Thread(runnable);//hilo con el runnable para poder correrlo
        thread.start();//correr el hilo
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}
//el handler es un objeto del hilo principal que se encarga de manejar la fila de mensajes
//podemos pedirle un mensaje, ponerle informacion y mandarselo otra vez
//tiene un metodo especial que recibe el mensaje y su encarga de la interfaz grafica