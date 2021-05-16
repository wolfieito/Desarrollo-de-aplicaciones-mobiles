package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intent = getIntent();//Consigue la actividad de la actividad primaria
        String sNom = intent.getStringExtra("NOMBRE");
        Double dSal = intent.getDoubleExtra("SALARIO", 0.0);//NOS PIDE VALOR DEFAULT
        Boolean bInfo = intent.getBooleanExtra("INFO", false);
        int iEstado = intent.getIntExtra("ESTADO_CIVIL", 0);
        TextView txVwDatos;
        txVwDatos = findViewById(R.id.txtVwDatos);
        txVwDatos.append("Nombre: \n");
        txVwDatos.append(sNom + "\n");
        txVwDatos.append("Salario: \n");
        txVwDatos.append(dSal + "\n");
        txVwDatos.append("Informacion: \n");
        if (bInfo)
            txVwDatos.append("Con informacion" + "\n");
        else
            txVwDatos.append("Sin informacion" + "\n");
        //RadioButton rdTemp = findViewById(R.id.iEstado);
        txVwDatos.append("Estado civil: \n");
        txVwDatos.append(iEstado + "\n");
    }

    public void onClicl(View v) {
        finish();
    }
}