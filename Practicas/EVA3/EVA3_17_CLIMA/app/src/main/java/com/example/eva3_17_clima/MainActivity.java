package com.example.eva3_17_clima;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*Clima[] aClimaCd = {
            new Clima(R.drawable.sunny,"Chihuahua",28,"Despejado con viento"),
            new Clima(R.drawable.atmospher,"Delicias",38,"Vientos juertes"),
            new Clima(R.drawable.cloudy,"Cuauhtemoc",45,"No se ve el sol"),
            new Clima(R.drawable.light_rain,"Parral",12,"Lloviendo poquito"),
            new Clima(R.drawable.rainy,"Casas grandes",32,"Lloviendo juerte"),
            new Clima(R.drawable.snow,"Camargo",15,"Nevando bonito"),
            new Clima(R.drawable.thunderstorm,"Madera",2,"Tormenta electrica"),
            new Clima(R.drawable.tornado,"Guerrero",21,"Sharknado"),
            new Clima(R.drawable.sunny,"Creel",16,"Ta' bonito el dia"),
            new Clima(R.drawable.light_rain,"Ahumada",14,"Llueve poco"),
    };*/


    List<Clima> lstCiudades = new ArrayList<>();

    ListView lstVwClima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lstVwClima = findViewById(R.id.lstVwClima);
        //lstVwClima.setAdapter(new ClimaAdaptador(this, R.layout.mi_lista_clima, aClimaCd));
        ConexionClima cc = new ConexionClima();
        cc.execute("https://api.openweathermap.org/data/2.5/find?lat=28.6353&lon=-106.08&cnt=30&units=metric&appid=307e50394477a196fb80ee8cf43f3967");
    }

    //URL, NADA, JSON(STRING)
    class ConexionClima extends AsyncTask<String, Void, String> {

        //AQUI VAMOS A HACER LA CONEXION (TRABAJO EN SEGUNDO PLANO)
        @Override
        protected String doInBackground(String... strings) {//los tres puntos indican un arreglo
            String sUrl = strings[0];

            String sResu = null;
            //HttpURLConnection
            try {
                URL url = new URL(sUrl);
                HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();
                //AQUI VERIFICAMOS SI LA CONEXION FUE EXITOSA
                if (httpCon.getResponseCode() == HttpURLConnection.HTTP_OK){
                    //AQUI ES COMO LEER UN ARCHIVO DE TEXTO
                    InputStreamReader isReader = new InputStreamReader(httpCon.getInputStream());
                    BufferedReader brDatos = new BufferedReader(isReader);
                    sResu = brDatos.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.wtf("URL",e);
            } catch (IOException e) {
                e.printStackTrace();
                Log.wtf("IO",e);
            }
            return sResu;
        }
        //AQUI VAMOS A LLENAR LA LISTA CON DATOS
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(!(s.equals(""))||s == null){//verificar que tengamos una respuesta
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    //RECUPERAR EL ARREGLO DE CIUDADES
                    JSONArray jsonCiudades = jsonObject.getJSONArray("list");
                    for(int i = 0; i < jsonCiudades.length(); i++){
                        JSONObject jsonCiudad = jsonCiudades.getJSONObject(i);//Recuperar una ciudad en particular
                        //LEER CADA CIUDAD
                        Clima climaCiudad = new Clima();
                        climaCiudad.setCiudad(jsonCiudad.getString("name"));
                        JSONObject jsonMain = jsonCiudad.getJSONObject("main");
                        climaCiudad.setTemp(jsonMain.getDouble("temp"));
                        JSONArray jsaWeather = jsonCiudad.getJSONArray("weather");
                        //TOMAMOS EL PRIMER ELEMENTO
                        JSONObject jsonClimaACtual = jsaWeather.getJSONObject(0);
                        climaCiudad.setDesc(jsonClimaACtual.getString("description"));
                        int id = jsonClimaACtual.getInt("id");
                        if(id < 300){//tormentas
                            climaCiudad.setImagen(R.drawable.thunderstorm);
                        }else if(id < 400){//lluvia ligera
                            climaCiudad.setImagen(R.drawable.light_rain);
                        }else if(id < 600)//lluvia
                            climaCiudad.setImagen(R.drawable.rainy);
                        else if(id < 700)//nieve
                            climaCiudad.setImagen(R.drawable.snow);
                        else if(id < 800)//Fenomeno atmosferico
                            climaCiudad.setImagen(R.drawable.atmospher);
                        else if(id < 801)//cielo despejado
                            climaCiudad.setImagen(R.drawable.sunny);
                        else if (id < 900)//Nublado
                            climaCiudad.setImagen(R.drawable.cloudy);
                        else
                            climaCiudad.setImagen(R.drawable.tornado);

                        lstCiudades.add(climaCiudad);
                    }
                    lstVwClima.setAdapter(new ClimaAdaptador(MainActivity.this,
                            R.layout.mi_lista_clima,lstCiudades));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}