package com.example.eva1_6_eventos;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MiClaseOnClick implements View.OnClickListener {
//MainActivity c;//objeto tipo MainActivity llamado c
    Context context;


    @Override
    public void onClick(View v) {
        Toast.makeText(context,"EVENTO POR CLASE",Toast.LENGTH_LONG).show();//en el contexto le pasamos el objeto tipo MainActivity c, ya que este esta igualado con m, que es un objeto tipo MainActivity que recibimos de la MainActibty
    }//get ApplicationContext es un metodo de la MainActivity, por eso no funciona asi

    public void setContext(Context context) {
        this.context = context;
    }

    //public MiClaseOnClick(MainActivity m){//constructor que recibe un objeto de tipo MainActivity de nombre
    //    c=m;//Igualamos el objeto MainActivity que ya teniamos(c) con el que recibimos(m)
    //}
}   //
