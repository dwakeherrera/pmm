package com.example.david.trabajofinal;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class PantallaPeliculas extends AppCompatActivity {

    int USUARIO;

    DatabaseHelper dbHelper;

    ArrayList<String> peliculasUsuarios;

    Fragment peliculasVistasFragment, peliculasPorVerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_peliculas);

        USUARIO = getIntent().getIntExtra("USUARIO", 0);

        Bundle bundle = new Bundle();
        bundle.putInt("USUARIO", USUARIO);
        peliculasPorVerFragment = new peliculasPorVer();
        peliculasVistasFragment = new peliculasVistas();
        peliculasPorVerFragment.setArguments(bundle);
        peliculasVistasFragment.setArguments(bundle);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.peliculasPorVer, peliculasPorVerFragment).replace(R.id.peliculasVistas, peliculasVistasFragment).addToBackStack(null).commit();
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ejemplo_menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.anyadir:
                Intent intent = new Intent(this, Anyadir.class);

                Bundle bundle = new Bundle();
                bundle.putInt("USUARIO", USUARIO);

                intent.putExtras(bundle);
                startActivityForResult(intent, 0);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK){
            finish();
            startActivity(getIntent());
        }
    }

}