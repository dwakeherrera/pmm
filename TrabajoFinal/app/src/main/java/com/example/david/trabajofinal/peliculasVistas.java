package com.example.david.trabajofinal;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class peliculasVistas extends Fragment {
    int usuario;

    ListView peliculasVistasList;

    DatabaseHelper dbHelper;

    ArrayList<String> peliculasUsuario;

    static peliculasVistas newInstance() {
        peliculasVistas f = new peliculasVistas();
        return f;
    }

    static peliculasVistas newInstance(int usuario) {
        peliculasVistas f = new peliculasVistas();
        Bundle args = new Bundle();
        args.putSerializable("USUARIO", usuario);
        f.setArguments(args);
        return f;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.fragment_peliculas_vistas, container, false);

        if (getArguments() != null) {
            usuario = getArguments().getInt("USUARIO", 0);
            peliculasVistasList = (ListView) view.findViewById(R.id.peliculasVistasUsuario);

            dbHelper = new DatabaseHelper(getActivity());
            dbHelper.open();

            peliculasUsuario = new ArrayList();

            Cursor cursor = dbHelper.getItems(
                    Globals.TABLE_PELICULA_USUARIO_REL + ", " + Globals.TABLE_PELICULA,
                    new String[] {Globals.TABLE_PELICULA + "." + Globals.TABLE_PELICULA_NOMBRE},
                    Globals.TABLE_PELICULA_USUARIO_REL_PELICULA_ID + " = " +
                            Globals.TABLE_PELICULA + "." +
                            Globals.TABLE_PELICULA_ID + " AND " +
                            Globals.TABLE_PELICULA_USUARIO_REL_VISTA + " = ? AND usuario_id = ?",
                    new String[] {String.valueOf(1), String.valueOf(usuario)},
                    Globals.TABLE_PELICULA_USUARIO_REL + "." +
                            Globals.TABLE_PELICULA_USUARIO_REL_ID);

            if (cursor.getCount() != 0)
                while (cursor.moveToNext())
                    peliculasUsuario.add(cursor.getString(0));

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1, peliculasUsuario);

            peliculasVistasList.setAdapter(adapter);

            dbHelper.close();
        }
        return view;

    }
}