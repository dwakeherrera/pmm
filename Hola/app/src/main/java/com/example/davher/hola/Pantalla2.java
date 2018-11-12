package com.example.davher.hola;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final ImageView modeloCoche = (ImageView) findViewById(R.id.image);
        final TextView modelo = (TextView) findViewById(R.id.zona);
        final TextView marca = (TextView) findViewById(R.id.tarifa);
        final TextView peso = (TextView) findViewById(R.id.peso);
        final TextView deco = (TextView) findViewById(R.id.deco);
        final TextView total = (TextView) findViewById(R.id.total);

        Coches coches = (Coches) getIntent().getSerializableExtra("TODO");
        if (coches.getModelo().equals("Megane"))
            modeloCoche.setImageDrawable(getDrawable(R.drawable.megan1));
        if (coches.getModelo().equals("X-11"))
            modeloCoche.setImageDrawable(getDrawable(R.drawable.ferrari1));
        if (coches.getModelo().equals("Leon"))
            modeloCoche.setImageDrawable(getDrawable(R.drawable.leon2));
        if (coches.getModelo().equals("Fiesta"))
            modeloCoche.setImageDrawable(getDrawable(R.drawable.fiesta2));
        modelo.setText(coches.getModelo());
        marca.setText("Tarifa: " + getIntent().getStringExtra("TARIFA"));
        peso.setText("Peso: " + getIntent().getDoubleExtra("PESO", 0));
        deco.setText("Decoración: " + getIntent().getStringExtra("DECO"));
        total.setText("Precio total del envío: " + String.valueOf(getIntent().getDoubleExtra("PRECIO", 0)) + "€");

        registerForContextMenu(modeloCoche);
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        return true;
    }

    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
    }

}
