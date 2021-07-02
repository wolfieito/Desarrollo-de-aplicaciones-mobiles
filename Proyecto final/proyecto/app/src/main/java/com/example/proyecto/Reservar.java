package com.example.proyecto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class Reservar extends AppCompatActivity {

    Spinner spinner;
    final int mkReser = 1000;
    TextView txtVwDatos;
    Intent intent;
    ImageView imgVwLogos;
    int iCont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar);
        spinner = (Spinner) findViewById(R.id.spinner);
        txtVwDatos = findViewById(R.id.txtVwDatos);
        intent = new Intent(this,MakeReser.class);
        imgVwLogos = findViewById(R.id.imgVwLogos);
        MiClaseAsincrona miCa = new MiClaseAsincrona();
        miCa.execute(1000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.restaurantes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onClickCierr(View v){
        finish();
    }

    public void onClickMakeReser(View v){
        startActivityForResult(intent,mkReser);
    }
    public void onClickMapaReser(View v){

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case mkReser:
                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(getApplicationContext(),"Reserva exitosa",Toast.LENGTH_LONG).show();
                    txtVwDatos.setText("Restaurante: "+spinner.getSelectedItem().toString()+"\n"+"NOMBRE: "+data.getStringExtra("NOMBRE")+"\n"+
                            "Numero de personas: "+data.getStringExtra("PERSONAS")+"\n"+
                            "Dentro o fuera: "+data.getStringExtra("DENTRO"));
                }
        }
    }
    class MiClaseAsincrona extends AsyncTask<Integer,Integer,Void> {
        //1ER
        //puede interactuar con la ui
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        //puede interactuar con la ui


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            imgVwLogos.setImageResource(values[0]);
        }

        //NO SE PUEDE INTERACTUAR CON LA UI
        //2DA
        @Override
        protected Void doInBackground(Integer... integers) {//EQUIVALENET A run() en un Thread
            int sleep = integers[0];
            while (true){
                try {
                    if(iCont==0){
                        Thread.sleep((sleep));
                        publishProgress(R.drawable.f1);
                        iCont++;
                    }
                    if(iCont==1){
                        Thread.sleep((sleep));
                        publishProgress(R.drawable.f2);
                        iCont++;
                    }
                    if(iCont==2){
                        Thread.sleep((sleep));
                        publishProgress(R.drawable.f3);
                        iCont++;
                    }
                    if(iCont==3){
                        Thread.sleep((sleep));
                        publishProgress(R.drawable.f4);
                        iCont++;
                    }
                    if(iCont==4){
                        Thread.sleep((sleep));
                        publishProgress(R.drawable.f5);
                        iCont++;
                    }
                    else{
                        iCont=0;
                        Thread.sleep((sleep));
                        publishProgress(R.drawable.f3);
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
            return null;
        }
    }
}