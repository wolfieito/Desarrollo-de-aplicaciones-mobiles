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
        for(int i=0;i<3;i++){           //CICLO ANIDADO PARA PONERLE EL ONCLICK LISTENER A TODOS LOS BOTONES Y SINCRONIZAR EL OBJETO CON EL WIDGET
            for (int j=0;j<3;j++){
                String btnId = "button"+i+j;//EL ID DEL BOTON QUE LE PONEMOS, TEXTO
                int resId = getResources().getIdentifier(btnId,"id",getPackageName()); //CONSEGUIR EL ID NUMERICO DE CADA BOTON
                buttons[i][j]=findViewById(resId);//CONECTAR EL ID CON CADA BOTON
                buttons[i][j].setOnClickListener(this);//PONER EL ONCLICK LISTENER CON CADA BOTON
            }
        }
        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {//HACER EL ONCLICK LISTENER CON EL BOTON RESET
            @Override
            public void onClick(View v) {
                for (int i=0;i<3;i++){              //FOR ANIDADO PARA PONER LOS BOTONES EN - Y VOLVERLOS A ACTIVAR.
                    for (int j=0;j<3;j++){
                        buttons[i][j].setText("-");         //PONER CADA BOTON EN -
                        buttons[i][j].setEnabled(true);     //ACTIVAR CADA BOTON
                    }
                }
                ronda=0;        //PONER LA RONDA EN CERO
                txtVwGana.setText(""); //BORRAS EL MENSAJE
                xTurn=true;     //TURNO DE X ACTIVADO
            }
        });
    }

    @Override
    public void onClick(View v) {       //ONCLICK QUE IMPLEMENTAMOS AQUI
        if(!((Button) v).getText().toString().equals("-")){ //SI EL BOTON NO TIENE - (TIENE X o O) returnea
            return;
        }
        if(xTurn){      //si es el turno de x pones el boton en x y lo desactivas
            ((Button) v).setText("X");  //pones el boton en X
            ((Button) v).setEnabled(false);     //desactivas el boton
        }
        else {      //si es el turno de o pones el boton en x y lo desactivas
            ((Button) v).setText("O");  //pones el boton en O
            ((Button) v).setEnabled(false);     //desactivas el boton
        }
        ronda++;       //icrementas en uno la ronda
        if (gana()){        //revisas si alguien ya gano
            if (xTurn){     //si es el turno de x
                xGana();    //clase gana x
            }
            else            //revisas si alguien ya gano
                oGana();    //si es el turno de x, clase gana O
        }
        else if (ronda==9){     //Si la ronda es igual a nueve
            empate();           //vas a metodo empate
        }else{                  //si no hay empate ni ha ganado nadie
            xTurn = !xTurn;     //cambias de turno
        }
    }
    private boolean gana(){     //revisar si alguien gano
        String[][] gato = new String[3][3];     //matriz 3x3 de strings
        for (int i=0;i<3;i++){          //for donde conseguimos el texto del boton y lo guardamos en los string de la matriz
            for (int j=0;j<3;j++){
                gato[i][j]=buttons[i][j].getText().toString();
            }
        }
        for (int i=0;i<3;i++){ //for donde revisamos verticalmente si alguien gano.
            if(gato[i][0].equals(gato[i][1])
                    &&gato[i][0].equals(gato[i][2])
                    &&!gato[i][0].equals("-")){
                return true;        //si alguien gano retornamos true
            }
        }
        for (int i=0;i<3;i++){          //for donde revisamos horizontalemnte si alguien gano.
            if(gato[0][i].equals(gato[1][i])
                    &&gato[1][i].equals(gato[2][i])
                    &&!gato[0][i].equals("-")){
                return true;        //si alguien gano retornamos true
            }
        }
        if(gato[0][0].equals(gato[1][1])        //if donde revisamos la diagonal de izqierda a derecha
                &&gato[0][0].equals(gato[2][2])
                &&!gato[0][0].equals("-")){
            return true;        //si alguien gano retornamos true
        }
        if(gato[0][2].equals(gato[1][1])        //if donde revisamos la diagonal de derecha a izquierda
                &&gato[0][2].equals(gato[2][0])
                &&!gato[0][2].equals("-")){
            return true;        //si alguien gano retornamos true
        }
        return false;       //si nadie gano retornamos false
    }
    private void xGana(){       //si gana x mostramos gana x y desactivamos los botones
        txtVwGana.setText("GANA X");
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                buttons[i][j].setEnabled(false);
            }
        }
    }
    private void oGana(){ //si gana o mostramos gana o y desactivamos los botones
        txtVwGana.setText("GANA O");
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                buttons[i][j].setEnabled(false);
            }
        }
    }
    private void empate(){      //si nadie gana ponemos empate
        txtVwGana.setText("EMPATE");
    }
}