package com.example.david.doblespinner;

import java.io.Serializable;
import java.util.ArrayList;

public class Studios implements Serializable {
    private int id;
    private String nombre;
    private String pais;
    private int anyoFundacion;
    private int imagen;
    private ArrayList<Peliculas> peliculas;

    public Studios(int id, String nombre, String pais, int anyoFundacion, int imagen, ArrayList<Peliculas> peliculas) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.anyoFundacion = anyoFundacion;
        this.imagen = imagen;
        this.peliculas = peliculas;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getAnyoFundacion() {
        return anyoFundacion;
    }

    public int getImagen() {
        return imagen;
    }

    public ArrayList<Peliculas> getPeliculas() {
        return peliculas;
    }
}