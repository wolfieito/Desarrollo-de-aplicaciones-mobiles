package com.example.eva3_2_multitarea_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //THREAD ---> CLASE PARA HILOS(JAVA)
        //Clase Thread()---> metodo run es generico
        //Creas propia clase que hereda de Thread
        //Crear clase anonima
        //sobreescribir el metodo run(){}
        Thread miHilo = new Thread(){
            //AQUI VAN LAS TAREAS EN SEGUNDO PLANO
            @Override
            public void run() {
                super.run();
                for (int i = 0;i<10;i++){
                    try {
                        Thread.sleep(1000);
                        Log.wtf("miHilo","i = "+(i+1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        miHilo.start();//INICIAMOS EL HILO DE EJCUCION
        MiHilote miHilote = new MiHilote();
        //miHilote.run();//diferencia entre start y run
        // la instruccion .start(); tiene las instrucciones para que se ejecute a la vez
        //para que se ejecute como otro programa a la vez.
        //el .run(); solo lo ejecuta, no como un programa por separado a la vez.
        //.run es una llamada a funcion dentro del hilo principal
        //el ciclo de vida del ciclo de ejecucion depende del run
        miHilote.start();
    }
}

class MiHilote extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0;i<10;i++){
            try {
                Thread.sleep(1000);
                Log.wtf("MiHilote","x = "+(i+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}