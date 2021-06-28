package com.example.eva3_14_asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView txtVwMostrar;
    //Thread: tareas de corta duracion.
    //Service: tareas de larga duracion.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMostrar = findViewById(R.id.txtVwMostrar);
        MiClaseAsincrona miCA = new MiClaseAsincrona();
        miCA.execute(10,500);
    }

    //INTERGER DE ENTRADA
    //STRING ENMEDIO
    //VOID DE SALIDA
    class MiClaseAsincrona extends AsyncTask<Integer,String,Void> {
        //1ER
        //puede interactuar con la ui
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtVwMostrar.setText("INICIANDO LA TAREA ASINCRONA \n");
        }
        //puede interactuar con la ui
        @Override
        protected void onPostExecute(Void aVoid) {//
            super.onPostExecute(aVoid);
            txtVwMostrar.append("FIN DE LA TAREA ASINCRONA");
        }
        //puede interactuar con la ui
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtVwMostrar.append(values[0]);
        }

        //NO SE PUEDE INTERACTUAR CON LA UI
        //2DA
        @Override
        protected Void doInBackground(Integer... integers) {//EQUIVALENET A run() en un Thread
            int limite = integers[0], time = integers[1];
            for(int i = 0; i < limite; i++){
                try {
                    Thread.sleep(time);
                    publishProgress("i = "+i+"\n");//para comunicarme
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}

//15 ---> BANNER_ASyNKTASK
//16 --> LOAD_IMAGE_ASYNKTASK