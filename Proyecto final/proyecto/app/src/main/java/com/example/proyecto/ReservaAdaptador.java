package com.example.proyecto;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ReservaAdaptador extends ArrayAdapter<Reserva>{
    private Context context;
    private int layout;
    private Reserva[] cReservas;

    public ReservaAdaptador(@NonNull Context context, int resource, @NonNull Reserva[] objects) {
        super(context, resource, objects);//Recibimos en constructor y los transferimos a objetos de la calse en el constructor
        this.context = context;
        this.layout = resource;
        this.cReservas = objects;
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

        ImageView imgVwRestaurante;
        TextView txtVwRestaurante,txtVwFecha,txtVwHora,txtVwDentro,txtVwPersonas;

        imgVwRestaurante = convertView.findViewById(R.id.imgVwRestaurante);
        txtVwRestaurante = convertView.findViewById(R.id.txtVwRestaurante);
        txtVwFecha = convertView.findViewById(R.id.txtVwFecha);
        txtVwHora = convertView.findViewById(R.id.txtVwHora);
        txtVwDentro = convertView.findViewById(R.id.txtVwDentro);
        txtVwPersonas = convertView.findViewById(R.id.txtVwPersonas);

        imgVwRestaurante.setImageResource(cReservas[position].getImagen());
        txtVwRestaurante.setText(cReservas[position].getRestaurante());
        txtVwFecha.setText(cReservas[position].getFecha()+"");
        txtVwHora.setText(cReservas[position].getHora()+" am");
        txtVwPersonas.setText(cReservas[position].getPersonas()+" personas");
        txtVwDentro.setText(cReservas[position].getDentro());

        return convertView;
    }
}
