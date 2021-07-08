package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Opciones extends AppCompatActivity {

    ImageView facebook, twitter, instagram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        facebook = findViewById(R.id.facebook);
        twitter = findViewById(R.id.twitter);
        instagram = findViewById(R.id.instagram);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               gotoUrl("https://www.facebook.com/gaming/SoyLeamsiAG");
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               gotoUrl("https://twitter.com/LeamsiAG");
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/soyleamsi/");
            }
        });
    }

    private void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void onClickCierr(View v){
        finish();
    }

    public void onClickReservar(View v){
        Intent intent = new Intent(this,Reservar.class);
        startActivity(intent);
    }
    public void onClickReservas(View v){
        Intent intent = new Intent(this,Reservas.class);
        startActivity(intent);
    }
    public void onClickPerfil(View v){
        Intent intent = new Intent(this,Perfil.class);
        startActivity(intent);
    }
}