package com.example.eva1_7_radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rdGrpAnime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdGrpAnime=findViewById(R.id.rdGrpAnime);
        //asignar el listener, crear el listener
        //por clase anonima
        rdGrpAnime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //primero recivimos el radiogroup que genera el evento, despues es el ID del radiobutton seleccionado
                //switch (checkedId){
                  //  case R.id.radioButton5:
                    //    Toast.makeText(getApplicationContext(),"Shonen",Toast.LENGTH_SHORT).show();
                      //  break;
                    //case R.id.radioButton:
                     //   Toast.makeText(getApplicationContext(),"Comedia",Toast.LENGTH_LONG).show();
                       // break;
                    //case R.id.radioButton2:
                      //  Toast.makeText(getApplicationContext(),"Harem",Toast.LENGTH_SHORT).show();
                        //break;
                    //case R.id.radioButton3:
                      //  Toast.makeText(getApplicationContext(),"Seinen",Toast.LENGTH_SHORT).show();
                        //break;
                    //case R.id.radioButton4:
                      //  Toast.makeText(getApplicationContext(),"Shojo",Toast.LENGTH_SHORT).show();
                        //break;
                //}
                RadioButton rdBtnSel = findViewById(checkedId);//RadioButton seleccionado
                Toast.makeText(getApplicationContext(),rdBtnSel.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}