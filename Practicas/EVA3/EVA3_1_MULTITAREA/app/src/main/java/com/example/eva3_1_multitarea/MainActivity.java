package com.example.eva3_1_multitarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //linux ---> proceso ---> tiene un hio de ejecucion principal
        for (int i = 0;i<10;i++){
            try {
                Thread.sleep(1000);//Detiene la ejecucion del hilo actual
                //con esto hacemos que el hilo principal se detenga por 10 segundos, incluso dibuar la pantalla
                Log.wtf("HILO PRINCIPAL","i = "+(i+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //hilo es secuencia de instruccions que corre nuestro programa
        }
    }
}