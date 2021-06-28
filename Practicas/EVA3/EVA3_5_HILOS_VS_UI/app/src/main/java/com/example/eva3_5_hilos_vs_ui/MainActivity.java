package com.example.eva3_5_hilos_vs_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwMensaje;
    Thread thread;
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
                        Log.wtf("runnable: ", cade);
                        txtVwMensaje.append(cade+"\n");//append pada que no sustituya el texto, solo lo agregue
                    } catch (InterruptedException e) {
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
//cada aplicacion que se corre es un hilo de ejecución
//por eso cuando hay una tarea muy pesada se conjela la pantalla
//para interactuar con la interfaz grafica, notificamos al hilo principal para que el haga lo que pedimos dentro de su ciclo