package com.example.eva1_8_eventos_recursos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements RadioGroup.OnCheckedChangeListener {
    TextView txtVwNom, txtVwApe;
    EditText edtTxtNom, edtTxtApe;
    RadioButton rdBtnEs,rdBtnEn;
    RadioGroup rdGrpIdioma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwNom = findViewById(R.id.txtVwNom);
        txtVwApe = findViewById(R.id.txtVwApe);
        edtTxtNom = findViewById(R.id.edtTxtNom);
        edtTxtApe = findViewById(R.id.edtTxtApe);
        rdGrpIdioma = findViewById(R.id.rdGrpIdioma);
        rdBtnEn=findViewById(R.id.rdBtnIEn);
        rdBtnEs=findViewById(R.id.rdBtnEs);
        rdGrpIdioma.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.rdBtnEs){
            txtVwApe.setText(R.string.txt_vw_ape);
            txtVwNom.setText(R.string.txt_vw_nom);
            edtTxtNom.setHint(R.string.edt_txt_nom);
            edtTxtApe.setHint(R.string.edt_txt_ape);
            rdBtnEs.setText(R.string.rd_btn_es);
            rdBtnEn.setText(R.string.rd_btn_en);
        }else{
            txtVwApe.setText(R.string.txt_vw_ape_en);
            txtVwNom.setText(R.string.txt_vw_nom_en);
            edtTxtNom.setHint(R.string.edt_txt_nom_en);
            edtTxtApe.setHint(R.string.edt_txt_ape_en);
            rdBtnEs.setText(R.string.rd_btn_es_en);
            rdBtnEn.setText(R.string.rd_btn_en_en);
        }
    }
}