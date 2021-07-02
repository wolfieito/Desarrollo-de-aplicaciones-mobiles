package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class Registrarse extends AppCompatActivity {

    EditText edTxtUsuRegi, edTxtNomRegi, edTxtApeRegi, edTxtTelRegi, edTxtConRegi;
    Intent intent;
    CheckBox mostrarcontra;
    Handler handler = new Handler();
    TextView errorLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        edTxtUsuRegi = findViewById(R.id.edTxtUsuRegi);
        edTxtNomRegi = findViewById(R.id.edTxtNomRegi);
        edTxtApeRegi = findViewById(R.id.edTxtApeRegi);
        edTxtTelRegi = findViewById(R.id.edTxtTelRegi);
        edTxtConRegi = findViewById(R.id.edTxtConRegi);
        mostrarcontra = findViewById(R.id.mostrarcontra);
        errorLabel = findViewById(R.id.errorLabel);
        intent = new Intent(this, Opciones.class);

        mostrarcontra.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    edTxtConRegi.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    edTxtConRegi.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    private void setErrorMessage(String error){
        handler.post(new Runnable() {
            @Override
            public void run() {
                errorLabel.setText(error);

            }
        });

    }

    public void onClickRegis(View v){
            FetchData dataConsulter = new FetchData(this);

            JSONObject postData = new JSONObject();
            try {
                postData.put("usuario", edTxtUsuRegi.getText().toString());
                postData.put("nombre", edTxtNomRegi.getText().toString());
                postData.put("apellidos", edTxtApeRegi.getText().toString());
                postData.put("numTel", edTxtTelRegi.getText().toString());
                postData.put("password", edTxtConRegi.getText().toString());



            } catch (JSONException e) {
                e.printStackTrace();
            }

            Response.Listener<JSONObject>  onResponse = new Response.Listener<JSONObject>(){
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if(response.getBoolean("succ") == true) {
                            Toast.makeText(getApplicationContext(), "Registrado con exito", Toast.LENGTH_LONG).show();
                            startActivity(intent);
                            finish();
                        }
                        else {
                            setErrorMessage("Error: " + response.getString("error"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            dataConsulter.fetch(Request.Method.POST,"register",postData,onResponse);
        }
        public void onClickCncel(View v){
            finish();
        }
    public void hidekeyboard(View v){
        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
    }
    }
