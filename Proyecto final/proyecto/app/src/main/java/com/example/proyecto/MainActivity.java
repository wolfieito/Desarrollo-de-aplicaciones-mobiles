package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private String Usuario, Nombre, Apellido, Telefono;
    TextView txt;
    EditText edTxtNom,edTxtCon;
    Intent intent;
    CheckBox mostrarcontra;
    Handler handler = new Handler();
    TextView loginErrorLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTxtCon = findViewById(R.id.edTxtCon);
        edTxtNom = findViewById(R.id.edTxtNom);
        mostrarcontra = findViewById(R.id.mostrarcontra);
        intent = new Intent(this, Opciones.class);
        loginErrorLabel = findViewById(R.id.errorLogLbl);

        mostrarcontra.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    edTxtCon.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    edTxtCon.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }


    private void setErrorMessage(String error){
        handler.post(new Runnable() {
            @Override
            public void run() {
                loginErrorLabel.setText(error);
            }
        });

    }

    public void openOpc(View v){
        FetchData dataConsulter = new FetchData(this);

        JSONObject postData = new JSONObject();
        try {
            postData.put("usuario", edTxtNom.getText().toString());
            postData.put("password", edTxtCon.getText().toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Response.Listener<JSONObject>  onResponse = new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.has("error"))
                        setErrorMessage(response.getString("error"));
                    else {
                        loginErrorLabel.setText("");
                        edTxtCon.setText("");
                        edTxtNom.setText("");
                        startActivity(intent);
                        buildClientData(response);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        dataConsulter.fetch(Request.Method.POST,"log",postData,onResponse);
    }

    private void buildClientData(JSONObject response){
        try{
            ClientData.id = response.getString("_id");
            ClientData.nombres = response.getString("nombres");
            ClientData.apellidos = response.getString("apellidos");
            ClientData.numero = response.getString("num_telef");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void openRegis(View v){
        Intent intent = new Intent(this, Registrarse.class);
        loginErrorLabel.setText("");
        edTxtCon.setText("");
        edTxtNom.setText("");
        startActivity(intent);
    }
    public void hidekeyboard(View v){
        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
    }

    public String getUsuario(){
        return Usuario;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getApellido(){
        return Apellido;
    }
    public String getTelefono(){
        return Telefono;
    }
    public void onClickC2(View v){
        finish();
    }
}