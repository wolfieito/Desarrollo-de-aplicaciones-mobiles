package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservas extends AppCompatActivity {

    private String changeFormat(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMM/yyyy");
        return simpleDateFormat.format(date);
    }

    private String changeFormatT(Date date ){
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm");
        return simpleDateFormat1.format(date);
    }

    Reserva[] aReservasCd = {
                new Reserva(R.drawable.f1,"BurgerKing", changeFormat(new Date((2021-1900),05,20)), changeFormatT(new Date(2021,5,20,10,20,02)),9,"dentro"),
            new Reserva(R.drawable.f2,"Dominos", changeFormat(new Date((2021-1900),07,8)), changeFormatT(new Date(11,4,02,9,30,25)),2,"Fuera"),
            new Reserva(R.drawable.f3,"CarlsJr", changeFormat(new Date((2021-1900),9,10)), changeFormatT(new Date(2021,8,25,5,20,02)),5,"dentro"),
            new Reserva(R.drawable.f4,"KFC", changeFormat(new Date((2021-1900),8,13)), changeFormatT(new Date(2021,8,13,9,00,02)),7,"dentro")
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);
    }
    ListView lstVwReservas;
    @Override
    protected void onStart() {
        super.onStart();
        lstVwReservas = findViewById(R.id.lstVwReservas);
        lstVwReservas.setAdapter(new ReservaAdaptador(this,R.layout.mi_lista_reservas,aReservasCd));
    }
    public void onClickC2(View v){
        finish();
    }
}