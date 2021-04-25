package com.example.eva1_examen_intermedio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtVwPoints, txtVwScore, txtVwAprobe;
    private SeekBar skBrPoints, skBrScore;
    private int score=0,points=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        txtVwPoints = findViewById(R.id.txtVwPoints);
        txtVwScore = findViewById(R.id.txtVwScore);
        txtVwAprobe = findViewById(R.id.txtVwAprobe);
        skBrPoints = findViewById(R.id.skBrPoints);
        skBrScore = findViewById(R.id.skBrScore);
        txtVwPoints.setText("Puntos para acreditar: " + skBrPoints.getProgress());
        txtVwScore.setText("Calificacion: " + skBrScore.getProgress());

        skBrPoints.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtVwPoints.setText("Puntos para acreditar: " + progress);
                points=progress;
                if(score>=points)
                    txtVwAprobe.setText("ACREDITADO");
                else
                    txtVwAprobe.setText("NO ACREDITADO");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        skBrScore.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtVwScore.setText("Calificacion: "+progress);
                score=progress;
                if(score>=points)
                    txtVwAprobe.setText("ACREDITADO");
                else
                    txtVwAprobe.setText("NO ACREDITADO");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}