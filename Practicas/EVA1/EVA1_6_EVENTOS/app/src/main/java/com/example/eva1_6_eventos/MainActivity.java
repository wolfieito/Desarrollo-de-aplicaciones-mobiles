package com.example.eva1_6_eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener {//Interface
    Button btnListener,btnClaseAnonima,btnPorClase;
    //MainActivity c;//objeto tipo MainActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListener=findViewById(R.id.btnListener);
        btnClaseAnonima=findViewById(R.id.btnClaseAnonima);
        btnPorClase=findViewById(R.id.btnPorClase);

        btnListener.setOnClickListener(this);//el main funciona como objeto del onclick porque lo implementa
        btnClaseAnonima.setOnClickListener(new View.OnClickListener() {//inicio clase anonima, no nombre
            @Override
            public void onClick(View v) {//objeto de la clase
                Toast.makeText(getApplicationContext(),"EVENTO POR CLASE ANONIMA",Toast.LENGTH_LONG).show();
            }//context:this el this da error porque el this apunta a la clase anonima
            //para solucionar esto de manera simple poner getApplicationContext() que nos regresa un objeto de tipo context
        });
        MiClaseOnClick objClick = new MiClaseOnClick();
        objClick.setContext(this);
        btnPorClase.setOnClickListener(objClick);
        //c=this;//El objeto MainActivity es igual a ese Main Activity
        //btnPorClase.setOnClickListener(new MiClaseOnClick(c));//un ojeto de la clase MiClaseOnClick, mandamos el objeto MainActivity c con el constructor.
    }

    //USANDO LA PROPIEDAD android:onclick DEL WIDGET
    // public void NOMBREDELMETODO(view arg){}
    public void miClick(View arg) {
        //MOSTRAR UN MENSAJE (TOAST)--SON MENSAJES BREVES
        Toast.makeText(this, "EVENTO POR ONCLICK XML", Toast.LENGTH_LONG).show();
    }

    @Override//interface
    public void onClick(View v) {
        Toast.makeText(this,"EVENTO POR LISTENER",Toast.LENGTH_LONG).show();
    }
}