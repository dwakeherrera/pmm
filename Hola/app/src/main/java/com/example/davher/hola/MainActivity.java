package com.example.davher.hola;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int precioCoches;
    private static double precioHora;
    private static EditText numeroDeHoras;
    private static RadioButton sinSeguro;
    private static RadioButton seguroTodoRiesgo;
    private static TextView eleccion;
    private static CheckBox aireAcondicionado;
    private static CheckBox gps;
    private static CheckBox radioDvd;
    private double total;
    private Coches cochazos;

    private Coches[] datos = new Coches[] {
            new Coches(0, "Megane", "Renault", "20€", R.drawable.megan1),
            new Coches(1, "X-11", "Ferrari", "100€", R.drawable.ferrari1),
            new Coches(2, "Leon", "Seat", "30€", R.drawable.leon2),
            new Coches(2, "Fiesta", "Ford", "40€", R.drawable.fiesta2)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Alquiler de Coches");

        AdaptadorZonas adaptador = new AdaptadorZonas(this);
        ListView lstOpciones = (ListView) findViewById(R.id.aElegirCoche);
        lstOpciones.setAdapter(adaptador);
        eleccion = (TextView) findViewById(R.id.eleccion);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick (AdapterView arg0, View arg1, int position, long id) {
                if (position == 0) precioCoches = 30;
                if (position == 1) precioCoches = 100;
                if (position == 2) precioCoches = 30;
                if (position == 3) precioCoches = 40;

                eleccion.setText(datos[position].getMarca() + " " + datos[position].getModelo());
                cochazos = new Coches(datos[position].getId(), datos[position].getModelo(), datos[position].getMarca(), datos[position].getPrecio(), datos[position].getImagen());
            }
        });

        numeroDeHoras = (EditText) findViewById(R.id.numeroDeHoras);

        sinSeguro = (RadioButton) findViewById(R.id.sinSeguro);
        sinSeguro.toggle();

        seguroTodoRiesgo = (RadioButton) findViewById(R.id.seguroTodoRiesgo);

        aireAcondicionado = (CheckBox) findViewById(R.id.aireAcondicionado);

        gps = (CheckBox) findViewById(R.id.gps);

        radioDvd = (CheckBox) findViewById(R.id.radioDvd);
    }

    public void calcular (View view) {
        Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);

        if (Double.valueOf(numeroDeHoras.getText().toString()) < 5)
            precioHora = Double.valueOf(numeroDeHoras.getText().toString());
        if (Double.valueOf(numeroDeHoras.getText().toString()) > 6 && Float.valueOf(numeroDeHoras.getText().toString()) < 10)
            precioHora = Double.valueOf(numeroDeHoras.getText().toString()) * 1.5;
        if (Double.valueOf(numeroDeHoras.getText().toString()) > 10)
            precioHora = Double.valueOf(numeroDeHoras.getText().toString()) * 2;

        total = precioHora + precioCoches;

        if (seguroTodoRiesgo.isChecked())
            total *= 1.3;

        Bundle miBundle = new Bundle();
        miBundle.putSerializable("TODO", cochazos);
        if (!seguroTodoRiesgo.isChecked())
            miBundle.putString("TARIFA", "Normal");
        else
            miBundle.putString("TARIFA", "Urgente");
        miBundle.putDouble("PESO", Double.valueOf(numeroDeHoras.getText().toString()));

        if (aireAcondicionado.isChecked() && !gps.isChecked())
            miBundle.putString("DECO", "Caja Regalo");
        else if (!aireAcondicionado.isChecked() && gps.isChecked())
            miBundle.putString("DECO", "Tarjeta Dedicada");
        else if (aireAcondicionado.isChecked() && gps.isChecked())
            miBundle.putString("DECO", "Caja Regalo Y Tarjeta Dedicada");

        miBundle.putDouble("PRECIO", total);
        miIntent.putExtras(miBundle);
        startActivity(miIntent);
    }

    static class ViewHolder {
        TextView modelo;
        TextView marca;
        TextView precio;
        ImageView imagen;
    }

    class AdaptadorZonas extends ArrayAdapter {
        Activity context;

        AdaptadorZonas(Activity context) {
            super(context, R.layout.linear_text_view, datos);
            this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView (int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;

            if (item == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.linear_text_view, null);
                holder = new ViewHolder();
                holder.modelo = (TextView) item.findViewById(R.id.modelo);
                holder.marca = (TextView) item.findViewById(R.id.marca);
                holder.precio = (TextView) item.findViewById(R.id.precio);
                holder.imagen = (ImageView) item.findViewById(R.id.imagen);

                item.setTag(holder);
            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.modelo.setText(datos[position].getModelo());

            holder.marca.setText(datos[position].getMarca());

            holder.precio.setText(datos[position].getPrecio());

            holder.imagen.setBackground(getDrawable(datos[position].getImagen()));

            return (item);
        }
    }
}
