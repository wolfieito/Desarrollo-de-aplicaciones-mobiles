package com.example.eva3_3_runnable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Runnable miRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<10;i++){
                    try {
                        Thread.sleep(1000);
                        Log.wtf("Runnable miRunnable","i = "+(i+1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };//no es una clase, por lo que tenemos que crear una,
        // ya sea anonima o crear una clase que implemente la interfaz,
        // y sobreescribir el metodo runnable
        //Runnable solo tiene el metodo run, no tiene start
        //Ejecutan la tarea, pero no la controlan
        //A fuerzas necesitamos un objeto de tipo Thread
        Thread thread = new Thread(miRunnable);
        //recibe un runnable y lo ejecuta en un hilo de ejecucion
        thread.start();
        MiClaseRun miClaseRun = new MiClaseRun();
        Thread thread1 = new Thread(miClaseRun);
        thread1.start();
    }
}
    //existe thread y runnable porque java solo puede heredar de una clase
    //solo se puede hacer extends a una clase, por eso se usa runnable
    //thread se usa cuando sea posible heredar de thread, y runnable cuando ya se herede de una clase

class MiClaseRun implements Runnable{

    @Override
    public void run() {
        for (int i = 0;i<10;i++){
            try {
                Thread.sleep(1000);
                Log.wtf("Runnable miClaseRun","i = "+(i+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}