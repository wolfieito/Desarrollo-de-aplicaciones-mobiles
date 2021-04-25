package com.example.eva1_examen_principiante_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView txtVwType, txtVwTitulo, txtVwDate, txtVwText;
        txtVwType = findViewById(R.id.txtVwType);
        txtVwTitulo = findViewById(R.id.txtVwTitulo);
        txtVwDate = findViewById(R.id.txtVwDate);
        txtVwText = findViewById(R.id.txtVwText);
        txtVwType.setText("SCIENCE/TECHNOLOGY");
        txtVwTitulo.setText("SPACE SHUTTLE");
        txtVwDate.setText("September 27, 2017");

        txtVwText.setText("The Space Shuttle was a partially reusable low" +
                " Earth orbital spacecraft system operated by the" +
                " U.S. National Aeronautics and Space" +
                " Administration (NASA), as part of the Space" +
                " Shuttle program. Its official program name was" +
                " Space Transportation System (STS), taken from a" +
                " 1969 plan for a system of reusable spacecraft of" +
                " which it was the only item funded for" +
                " development");
    }
}