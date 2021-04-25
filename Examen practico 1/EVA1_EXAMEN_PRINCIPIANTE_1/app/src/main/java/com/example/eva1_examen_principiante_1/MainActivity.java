package com.example.eva1_examen_principiante_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView txtVw1,txtVw2,txtVw3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        txtVw1 = findViewById(R.id.txtVw1);
        txtVw2 = findViewById(R.id.txtVw2);
        txtVw3 = findViewById(R.id.txtVw3);
        txtVw1.setText("APLICACIONES I");
        txtVw2.setText("EXAMEN PRÁCTICO");
        txtVw3.setText("1RA EVALUACIÓN PARCIAL");
    }
}