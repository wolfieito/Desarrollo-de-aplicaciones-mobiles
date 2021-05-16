package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    EditText edTxtNom, edTxtApe, edTxtEdad, edTxtSue;
    CheckBox chBxInfo;
    //RadioButton rdBtnSol,rdBtnDiv,rdBtnCas,rdBtnNoIn;
    RadioGroup rdGrpEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MainActivity2.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        edTxtNom = findViewById(R.id.edTxtNom);
        edTxtApe = findViewById(R.id.edTxtApe);
        edTxtEdad = findViewById(R.id.edTxtEdad);
        edTxtSue = findViewById(R.id.edTxtSueldo);
        chBxInfo = findViewById(R.id.chkBxInfo);
        //rdBtnCas = findViewById(R.id.rdBtnCas);
        //rdBtnDiv = findViewById(R.id.rdBtnDiv);
        //rdBtnNoIn = findViewById(R.id.rdBtnNoIn);
        //rdBtnSol = findViewById(R.id.rdBtnSol);
        rdGrpEstado = findViewById(R.id.rdGrpEstadoCivil);
    }

    public void onClicl(View v) {
        intent.putExtra("NOMBRE", edTxtNom.getText().toString());
        intent.putExtra("APELLIDO", edTxtApe.getText().toString());
        int ed;
        ed = Integer.parseInt(edTxtEdad.getText().toString());
        intent.putExtra("EDAD", ed);
        Double dSalario = 0.0;
        dSalario = Double.parseDouble(edTxtSue.getText().toString());
        intent.putExtra("SALARIO", dSalario);
        intent.putExtra("INFO", chBxInfo.isChecked());
        intent.putExtra("ESTADO_CIVIL", rdGrpEstado.getCheckedRadioButtonId());
        startActivity(intent);
    }
}