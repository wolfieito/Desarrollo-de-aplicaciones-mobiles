package com.example.aaa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnReiniciar;
    Button btnAgregar;
    int contCards;

    boolean termino;

    int cuentaIa;
    int cuentaJugador;

    TextView ganadortxt;

    ImageView[] oponentCards;
    ImageView[] playerCards;

    private randomCardGetter cardsGetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIElements();
    }

    private void initIElements(){
        btnReiniciar = findViewById(R.id.reiniciarBtn);
        btnAgregar = findViewById(R.id.sacarBtn);
        ganadortxt = findViewById(R.id.ganadortxt);
        initCardsLayouts();
    }

    private void initCardsLayouts(){


        playerCards=new ImageView[]{
                findViewById(R.id.yo1),
                findViewById(R.id.yo2),
                findViewById(R.id.yo3),
                findViewById(R.id.yo4),
                findViewById(R.id.yo5)

        };

        oponentCards=new ImageView[]{
                findViewById(R.id.oponente1),
                findViewById(R.id.oponente2),
                findViewById(R.id.oponente3),
                findViewById(R.id.oponente4),
                findViewById(R.id.oponente5)
        };
    }

    @Override
    protected void onStart() {
        super.onStart();

        resetProps();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!termino)
                    sacadaDeCarta();
                }
        });

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reiniciar();
            }
        });

    }
    private void reiniciar(){

        resetProps();
        ganadortxt.setText("");
        resetCards(oponentCards);
        resetCards(playerCards);
    }

    private void resetProps(){
        cardsGetter = new randomCardGetter();
        termino=false;
        contCards = 0;

        cuentaIa=0;
        cuentaJugador=0;
    }

    private void resetCards(ImageView[] views){
        int defaultImageId = R.drawable.sumar;
        for(ImageView view:views)
            view.setImageResource(defaultImageId);
    }

    private void sacadaDeCarta(){
        contCards++;

        Card newCard =  cardsGetter.getRandomCard();
        oponentCards[contCards-1].setImageResource(newCard.draw);
        cuentaIa+= newCard.value;

        newCard =  cardsGetter.getRandomCard();
        playerCards[contCards-1].setImageResource(newCard.draw);
        cuentaJugador+= newCard.value;

        evaluateWinConditions();

    }



    private void showWinnerNot(String result){
        new AlertDialog.Builder(this)
                .setTitle(result)
                .setMessage("Presiona aceptar para continuar")
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

    }

    private void setWinner(String result){
        showWinnerNot(result);
        ganadortxt.setText(result);
        termino = true;
    }


    private void evaluateWinConditions(){

        if  (cuentaIa > 21  &&	cuentaJugador > 21){
            if(cuentaJugador > cuentaIa)
                setWinner("El ganador es el Oponente!");
            else
                setWinner("El ganador es el Jugador!");
        }
        else if(cuentaIa > 21)
            setWinner("El ganador es el Jugador!");
        else if(cuentaJugador > 21)
            setWinner("El ganador es el Oponente!");
        else if(cuentaIa == 21)
            setWinner("El ganador es el Oponente!");
        else if(cuentaJugador == 21)
            setWinner("El ganador es el Jugador!");
        else if( contCards == 5){
            if(cuentaJugador > cuentaIa)
                setWinner("El ganador es el Jugador!");
            else
                setWinner("El ganador es el Oponente!");
        }
    }



}