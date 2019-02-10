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


public class peliculasPorVer extends Fragment {
    int usuario;

    ListView peliculasPorVerList;

    DatabaseHelper dbHelper;

    ArrayList<String> peliculaUsuario;

    static peliculasPorVer newInstance() {
        peliculasPorVer f = new peliculasPorVer();
        return f;
    }

    static peliculasPorVer newInstance(int usuario) {
        peliculasPorVer f = new peliculasPorVer();
        Bundle args = new Bundle();
        args.putSerializable("USUARIO", usuario);
        f.setArguments(args);
        return f;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.fragment_peliculas_por_ver, container, false);

        if (getArguments() != null) {
            usuario = getArguments().getInt("USUARIO", 0);
            peliculasPorVerList = (ListView) view.findViewById(R.id.peliculasPorVerUsuario);

            dbHelper = new DatabaseHelper(getActivity());
            dbHelper.open();

            peliculaUsuario = new ArrayList();


            Cursor cursor = dbHelper.getItems(
                    Globals.TABLE_PELICULA_USUARIO_REL + ", " + Globals.TABLE_PELICULA,
                    new String[] {Globals.TABLE_PELICULA + "." + Globals.TABLE_PELICULA_NOMBRE},
                    Globals.TABLE_PELICULA_USUARIO_REL_PELICULA_ID + " = " +
                            Globals.TABLE_PELICULA + "." +
                            Globals.TABLE_PELICULA_ID + " AND " +
                            Globals.TABLE_PELICULA_USUARIO_REL_PORVER + " = ? AND usuario_id = ?",
                    new String[] {String.valueOf(1), String.valueOf(usuario)},
                    Globals.TABLE_PELICULA_USUARIO_REL + "." +
                            Globals.TABLE_PELICULA_USUARIO_REL_ID);

            if (cursor.getCount() != 0)
                while (cursor.moveToNext())
                    peliculaUsuario.add(cursor.getString(0));

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, peliculaUsuario);

            peliculasPorVerList.setAdapter(adapter);

            dbHelper.close();
        }
        return view;

    }
}