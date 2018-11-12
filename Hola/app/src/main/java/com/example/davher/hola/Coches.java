package com.example.davher.hola;

import java.io.Serializable;

public class Coches implements Serializable {
    private int id;
    private String modelo;
    private String marca;
    private String precio;
    private int imagen;

    public Coches(int id, String modelo, String marca, String precio, int imagen) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getPrecio() {
        return precio;
    }

    public int getImagen() { return imagen; }
}
