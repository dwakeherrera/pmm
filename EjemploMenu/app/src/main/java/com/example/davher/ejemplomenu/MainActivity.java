package com.example.davher.ejemplomenu;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView lblMensaje;
    private ImageView miImagen;
    private View vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblMensaje = (TextView)findViewById(R.id.LblMensaje);
        miImagen = (ImageView)findViewById(R.id.miImagen);
        vista = (View)findViewById(R.id.drawing_area);

        registerForContextMenu(vista);
        registerForContextMenu(miImagen);
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu_principal,menu);
        return true;
    }

    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    public boolean onContextItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MenuOpc1:
                lblMensaje.setText("Opción 1 pulasada");
                return true;
            case R.id.MenuOpc2:
                lblMensaje.setText("Opción 2 pulasada");
                return true;
            case R.id.MenuOpc3:
                lblMensaje.setText("Opción 3 pulasada");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
