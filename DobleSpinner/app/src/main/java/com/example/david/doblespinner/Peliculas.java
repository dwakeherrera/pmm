package com.example.david.doblespinner;

import java.io.Serializable;

public class Peliculas implements Serializable {
    private int id;
    private String titulo;
    private int anyo;
    private int imagen;
    private String descripcion;

    public Peliculas(int id, String titulo, int anyo, int imagen, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.anyo = anyo;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnyo() {
        return anyo;
    }

    public int getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }
}