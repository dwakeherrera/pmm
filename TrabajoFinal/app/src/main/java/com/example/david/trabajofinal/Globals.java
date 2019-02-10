package com.example.david.trabajofinal;

public final class Globals {
    //Configuración base de datos
    public static final String DATABASE_NAME = "Peliculas";

    //Tabla usuario
    public static final String TABLE_USUARIO = "Usuario";
    public static final String TABLE_USUARIO_ID = "id";
    public static final String TABLE_USUARIO_NOMBRE = "nombreUsuario";
    public static final String TABLE_USUARIO_PASSWORD = "password";

    //Tabla película
    public static final String TABLE_PELICULA = "Pelicula";
    public static final String TABLE_PELICULA_ID = "id";
    public static final String TABLE_PELICULA_NOMBRE = "nombrePelicula";

    //Tabla relación (usuario-película)
    public static final String TABLE_PELICULA_USUARIO_REL = "Pelicula_Usuario_Rel";
    public static final String TABLE_PELICULA_USUARIO_REL_ID = "id";
    public static final String TABLE_PELICULA_USUARIO_REL_USUARIO_ID = "usuario_id";
    public static final String TABLE_PELICULA_USUARIO_REL_PELICULA_ID = "pelicula_id";
    public static final String TABLE_PELICULA_USUARIO_REL_PORVER = "porVer";
    public static final String TABLE_PELICULA_USUARIO_REL_VISTA = "vista";

    //Creación tabla usuario
    public static final String CREATE_TABLE_USUARIO = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL, " +
                    "%s TEXT NOT NULL)",
            TABLE_USUARIO,
            TABLE_USUARIO_ID,
            TABLE_USUARIO_NOMBRE,
            TABLE_USUARIO_PASSWORD
    );

    //Creación tabla película
    public static final String CREATE_TABLE_PELICULA = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL)",
            TABLE_PELICULA,
            TABLE_PELICULA_ID,
            TABLE_PELICULA_NOMBRE
    );

    //Creación tabla relación
    public static final String CREATE_TABLE_RELACION = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL, " +
                    "%s INTEGER NOT NULL)",

            TABLE_PELICULA_USUARIO_REL,
            TABLE_PELICULA_USUARIO_REL_ID,
            TABLE_PELICULA_USUARIO_REL_USUARIO_ID,
            TABLE_USUARIO,
            TABLE_USUARIO_ID,
            TABLE_PELICULA_USUARIO_REL_PELICULA_ID,
            TABLE_PELICULA,
            TABLE_PELICULA_ID,
            TABLE_PELICULA_USUARIO_REL_PORVER,
            TABLE_PELICULA_USUARIO_REL_VISTA
    );

    //Rellenar tabla usuario
    public static final String FILL_USUARIO_TABLE = String.format(
            "INSERT INTO %s (nombreUsuario, password) VALUES ('%s', '%s')",
            TABLE_USUARIO,
            "admin",
            "admin"
    );

    //Rellenar tabla películas
    public static final String FILL_PELICULA_TABLE =
            "INSERT INTO Pelicula (nombrePelicula) VALUES ('Blancanieves'), ('Coco'), ('Scarface'), ('Superfumados'), " +
                    "('John Wick'), ('The equalizer'), ('Harry Potter'), ('El señor de los anillos'), ('Cómo entrenar a tu dragón')";
}