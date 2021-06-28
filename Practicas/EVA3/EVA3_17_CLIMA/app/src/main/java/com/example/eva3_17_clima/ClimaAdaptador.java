package com.example.eva3_17_clima;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ClimaAdaptador extends ArrayAdapter<Clima> {
    private Context context;
    private int layout;
    //private Clima[] cCiudades;
    private List<Clima> cCiudades;

    public ClimaAdaptador(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);//Recibimos en constructor y los transferimos a objetos de la calse en el constructor
        this.context = context;
        this.layout = resource;
        this.cCiudades = objects;
    }

    //

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //FILA NO EXISTA
        if (convertView==null) {//PRIMETA VEZ QUE SE MUESTRA LA LISTA, NO EXISTE
            convertView = ((Activity)context).getLayoutInflater().inflate(layout,parent,false);
        }//else {//FILA SI EXISTE Y HAY QUE LLENAR

        //}

        ImageView imgVwClima;
        TextView txtVwCd,txtVwTemp,txtVwDesc;
        //Vincularlas para poder usarlas
        //se usa convertView porque ahi estan las cosas
        imgVwClima = convertView.findViewById(R.id.imgVwClima);
        txtVwCd = convertView.findViewById(R.id.txtVwCd);
        txtVwDesc = convertView.findViewById(R.id.txtVwDesc);
        txtVwTemp = convertView.findViewById(R.id.txtVwTemp);
        //Llenar los widges con datos (arreglo cCiudades)
        Clima climaCiudad = cCiudades.get(position);
        txtVwCd.setText(climaCiudad.getCiudad());
        imgVwClima.setImageResource(climaCiudad.getImagen());
        txtVwTemp.setText(climaCiudad.getTemp()+" ° C");
        txtVwDesc.setText(climaCiudad.getDesc());
        /*imgVwClima.setImageResource(cCiudades[position].getImagen());
        txtVwCd.setText(cCiudades[position].getCiudad());
        txtVwTemp.setText(cCiudades[position].getTemp(jsonMain.getDouble("temp"))+"°C");
        txtVwDesc.setText(cCiudades[position].getDesc());*/

        return convertView;
    }
}
