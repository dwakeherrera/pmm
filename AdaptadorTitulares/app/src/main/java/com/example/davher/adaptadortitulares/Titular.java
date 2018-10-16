package com.example.davher.adaptadortitulares;

public class Titular {
    private String titulo;
    private String subtitulo;
    private int imagen;

    public Titular(String tit, String sub, int img1) {
        titulo = tit;
        subtitulo = sub;
        imagen = img1;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public int getImagen() {
        return imagen;
    }
}