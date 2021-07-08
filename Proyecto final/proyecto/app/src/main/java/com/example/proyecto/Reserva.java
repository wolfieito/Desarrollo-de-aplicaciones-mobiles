package com.example.proyecto;

import java.sql.Time;
import java.util.Date;

public class Reserva {
    private int imagen;
    private String restaurante;
    private String fecha;
    private String hora;
    private int personas;
    private String dentro;

    public Reserva() {
        this.imagen = R.drawable.f1;
        this.restaurante = "Burger king";
        this.fecha = "11/02/2021";
        this.hora = "10:20";
        this.personas = 9;
        this.dentro = "Dentro";
    }
    public Reserva(int imagen, String restaurante, String fecha,String hora,int personas, String dentro) {
        this.imagen = imagen;
        this.restaurante = restaurante;
        this.fecha = fecha;
        this.hora = hora;
        this.personas = personas;
        this.dentro = dentro;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String Restaurante) {
        this.restaurante = restaurante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora(){return hora;}

    public void setHora(String hora){
        this.hora = hora;
    }

    public int getPersonas(){return personas;}

    public void setPersonas(int personas){this.personas = personas; }

    public String getDentro() {
        return dentro;
    }

    public void setDentro(String dentro) {
        this.dentro = dentro;
    }
}