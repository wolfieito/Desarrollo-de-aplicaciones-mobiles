package com.example.eva1_examen_intermedio_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button btnCalcular;
    private EditText edTxtRadio;
    private TextView txtVwAngulo;
    private SeekBar skBrAngulo;
    private double rd,ang,vol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnCalcular = findViewById(R.id.btnCalcular);
        edTxtRadio = findViewById(R.id.edTxtRadio);
        txtVwAngulo = findViewById(R.id.txtVwAngulo);
        skBrAngulo = findViewById(R.id.skBrAngulo);
        txtVwAngulo.setText("Angulo: "+skBrAngulo.getProgress());

        skBrAngulo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ang = progress;
                txtVwAngulo.setText("Angulo: "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = 2, b = 3;
                rd = Double.parseDouble(String.valueOf(edTxtRadio.getText()));
                vol=(a/b)*((ang)*Math.pow(rd,3));
                Toast.makeText(getApplicationContext(),"El volumen es: "+vol,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void hidekeyboard(View v){
        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
    }
}