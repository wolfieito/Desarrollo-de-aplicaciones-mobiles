package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil2);
        TextView usearNameView = findViewById(R.id.nombreUsuario);
        TextView completo = findViewById(R.id.nombreUsuartioTxt);
        TextView id = findViewById(R.id.idUsuartioTxt);
        TextView tel = findViewById(R.id.telUsuartioTxt);

        usearNameView.setText(ClientData.nombres);
        completo.setText(ClientData.nombres + "\n" + ClientData.apellidos);
        id.setText(ClientData.id);
        tel.setText(ClientData.numero);

    }
    public void onClickC3(View v){
        finish();
    }
}