package com.example.david.trabajofinal;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Anyadir extends AppCompatActivity {

    int USUARIO;
    int porVerValue, vistaValue;

    DatabaseHelper dbHelper;

    ArrayList<String> countries;

    Spinner listaPelicula;
    Button insertar;
    RadioButton porVer, vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyadir);

        dbHelper = new DatabaseHelper(this);
        dbHelper.open();

        countries = new ArrayList();

        final Cursor cursor2 = dbHelper.getItems(
                Globals.TABLE_PELICULA,
                new String[] {
                        Globals.TABLE_PELICULA_ID,
                        Globals.TABLE_PELICULA_NOMBRE},
                null,
                null,
                Globals.TABLE_PELICULA_ID);

        while (cursor2.moveToNext())
            countries.add(cursor2.getString(1));

        listaPelicula = (Spinner) findViewById(R.id.listaPeliculas);
        insertar = (Button)findViewById(R.id.insertar);
        porVer = (RadioButton) findViewById(R.id.peliculasPorVer);
        vista = (RadioButton) findViewById(R.id.peliculasVistas);

        USUARIO = getIntent().getIntExtra("USUARIO", 0);

        listaPelicula.setAdapter(new PeliculaAdapter(getApplicationContext(), countries));


        insertar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (porVer.isChecked()) {
                    porVerValue = 1;
                    vistaValue = 0;
                } else if (vista.isChecked()) {
                    porVerValue = 0;
                    vistaValue = 1;
                }

                int itemPosition = listaPelicula.getSelectedItemPosition() + 1;

                dbHelper.insertItem(
                        String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (%s, %s, %s, %s)",
                                Globals.TABLE_PELICULA_USUARIO_REL,
                                Globals.TABLE_PELICULA_USUARIO_REL_USUARIO_ID,
                                Globals.TABLE_PELICULA_USUARIO_REL_PELICULA_ID,
                                Globals.TABLE_PELICULA_USUARIO_REL_PORVER,
                                Globals.TABLE_PELICULA_USUARIO_REL_VISTA,
                                USUARIO,
                                itemPosition,
                                porVerValue,
                                vistaValue
                        ));
                Toast.makeText(getApplicationContext(), "Película añadida", Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected void onStop () {
        super.onStop();
        dbHelper.close();
    }

    protected void onPause () {
        super.onPause();
        dbHelper.close();
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);

        super.onBackPressed();
    }
}

class PeliculaAdapter extends ArrayAdapter {

    public PeliculaAdapter(Context context, ArrayList<String> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.linear_pelicula_spinner, parent, false
            );
        }

        TextView nombre = convertView.findViewById(R.id.nombre);

        String currentItem = (String) getItem(position);

        if (currentItem != null) {
            nombre.setText(currentItem);
        }

        return convertView;
    }
}