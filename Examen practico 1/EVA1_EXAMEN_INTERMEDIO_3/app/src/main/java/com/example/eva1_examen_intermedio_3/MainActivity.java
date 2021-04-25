package com.example.eva1_examen_intermedio_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[3][3];
    private boolean xTurn = true;
    private int ronda=0;
    private TextView txtVwGana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwGana = findViewById(R.id.txtVwGana);
        txtVwGana.setText("");
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                String btnId = "button"+i+j;
                int resId = getResources().getIdentifier(btnId,"id",getPackageName());
                buttons[i][j]=findViewById(resId);
                buttons[i][j].setOnClickListener(this);
            }
        }
        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<3;i++){
                    for (int j=0;j<3;j++){
                        buttons[i][j].setText("-");
                        buttons[i][j].setEnabled(true);
                    }
                }
                ronda=0;
                txtVwGana.setText("");
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(!((Button) v).getText().toString().equals("-")){
            return;
        }
        if(xTurn){
            ((Button) v).setText("X");
            ((Button) v).setEnabled(false);
        }
        else {
            ((Button) v).setText("O");
            ((Button) v).setEnabled(false);
        }
        ronda++;
        if (gana()){
            if (xTurn){
                xGana();
            }
            else
                oGana();
        }
        else if (ronda==9){
            empate();
        }else{
            xTurn = !xTurn;
        }
    }
    private boolean gana(){
        String[][] gato = new String[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                gato[i][j]=buttons[i][j].getText().toString();
            }
        }
        for (int i=0;i<3;i++){
            if(gato[i][0].equals(gato[i][1])
                    &&gato[i][0].equals(gato[i][2])
                    &&!gato[i][0].equals("-")){
                return true;
            }
        }
        for (int i=0;i<3;i++){
            if(gato[0][i].equals(gato[1][i])
                    &&gato[1][i].equals(gato[2][i])
                    &&!gato[0][i].equals("-")){
                return true;
            }
        }
        if(gato[0][0].equals(gato[1][1])
                &&gato[0][0].equals(gato[2][2])
                &&!gato[0][0].equals("-")){
            return true;
        }
        if(gato[0][2].equals(gato[1][1])
                &&gato[0][2].equals(gato[2][0])
                &&!gato[0][2].equals("-")){
            return true;
        }
        return false;
    }
    private void xGana(){
        txtVwGana.setText("GANA X");
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                buttons[i][j].setEnabled(false);
            }
        }
        xTurn=true;
    }
    private void oGana(){
        txtVwGana.setText("GANA O");
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                buttons[i][j].setEnabled(false);
            }
        }
        xTurn=true;
    }
    private void empate(){
        txtVwGana.setText("EMPATE");
        xTurn=true;
    }
}