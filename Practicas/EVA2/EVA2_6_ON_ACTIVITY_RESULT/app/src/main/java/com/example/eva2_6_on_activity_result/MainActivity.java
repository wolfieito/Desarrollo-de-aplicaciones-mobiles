package com.example.eva2_6_on_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnIniSecun;
    Intent intent, intentCont, intentImg;
    final int CODIGO_SECUN = 1000;
    final int CODIGO_CONTACTOS = 2000;
    final int CODIGO_img = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, Secundaria.class);
        intentCont = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
        intentImg = new Intent(Intent.ACTION_PICK, Uri.parse("content://media/external/images/media")/*MediaStore.Images.Media.EXTERNAL_CONTENT_URI*/);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnIniSecun = findViewById(R.id.btnIniSecun);
        btnIniSecun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("DATOS","Información enviada desde principal");
                startActivityForResult(intent, CODIGO_SECUN);//Segundo es un codigo para identificar la actividad de la que esperemos un resultado, para distinguir que actividad nos da la respuesta
                //el codigo no termina en startActivityForResult
            }
        });
    }

    public void onClickCont(View v) {//Con el v podemos ver que boton se presiona
        if (v.getId() == R.id.btnImg)
            startActivityForResult(intentImg,CODIGO_img);
        else if(v.getId() == R.id.btnCont)
            startActivityForResult(intentCont, CODIGO_CONTACTOS);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);//se va a lanzar este evento cuando la otra actividad nos da el resultado, escucha todos los eventos relacionados con resultados
            //result code es okay o cancelar la accion
        //AQUI PRCESAMOS LA RESPUESTA DE LA ACTIVIDAD
        //IDENTIFICAR LA ACTIVIDAD QUE DEVOLVIO EL RESULTADO
        //IDENTIFICAR SI SE DEVOLVIO UN VALOR O NO
        //LEER LOS DATOS (intent)
        switch (requestCode){
            case CODIGO_SECUN://un case para cada actividad
                    if(resultCode == Activity.RESULT_OK){//si me devolvio un valor
                        //leer los datos
                        Toast.makeText(this,data.getStringExtra("VALOR"),Toast.LENGTH_LONG).show();
                    }
                break;
            case CODIGO_CONTACTOS://un case para cada actividad
                if(resultCode == Activity.RESULT_OK){//si me devolvio un valor
                    //leer los datos
                    String returnedData = data.getDataString();
                    Toast.makeText(this,returnedData,Toast.LENGTH_LONG).show();
                }
                break;
            case CODIGO_img://un case para cada actividad
                if(resultCode == Activity.RESULT_OK){
                    String returnedData = data.getDataString();
                    Toast.makeText(this,returnedData,Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }
    }
}