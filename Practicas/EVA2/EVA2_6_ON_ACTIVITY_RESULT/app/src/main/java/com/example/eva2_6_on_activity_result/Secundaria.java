package com.example.eva2_6_on_activity_result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Secundaria extends AppCompatActivity {

    Button btnEnviar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        //intent = new Intent();
        intent = getIntent();
        Toast.makeText(this,intent.getStringExtra("DATOS"),Toast.LENGTH_LONG).show();
    }

    public void Onclick(View v) {
        //setResult(); es el que lanza el evento y va a permitir que el evento sea invocadoñ
        //puedes solo ejecutarla o ejecutarla y mandar valores
        intent.putExtra("VALOR", "Hola mundo");
        setResult(Activity.RESULT_OK, intent);//primer argumento es result code
        //el segundo valor son los datos
        finish();
    }

    public void onclickCalcel(View v){
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}