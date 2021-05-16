package com.example.eva1_2_clima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Clima[] aClimaCd = {
            new Clima(R.drawable.sunny,"Chihuahua",28,"Despejado con viento"),
            new Clima(R.drawable.atmospher,"Delicias",38,"Vientos juertes"),
            new Clima(R.drawable.cloudy,"Cuauhtemoc",45,"No se ve el sol"),
            new Clima(R.drawable.light_rain,"Parral",12,"Lloviendo poquito"),
            new Clima(R.drawable.rainy,"Casas grandes",32,"Lloviendo juerte"),
            new Clima(R.drawable.snow,"Camargo",15,"Nevando bonito"),
            new Clima(R.drawable.thunderstorm,"Madera",2,"Tormenta electrica"),
            new Clima(R.drawable.tornado,"Guerrero",21,"Sharknado"),
            new Clima(R.drawable.sunny,"Creel",16,"Ta' bonito el dia"),
            new Clima(R.drawable.light_rain,"Ahumada",14,"Llueve poco"),
    };

    ListView lstVwClima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lstVwClima = findViewById(R.id.lstVwClima);
        lstVwClima.setAdapter(new ClimaAdaptador(this,R.layout.mi_lista_clima,aClimaCd));
    }
}