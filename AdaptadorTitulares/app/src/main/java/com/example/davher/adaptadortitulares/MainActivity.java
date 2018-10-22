package com.example.davher.adaptadortitulares;

import android.app.Activity;
import android.content.*;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private Titular[] datos = new Titular[]{
        new Titular("Título 1", "Subtítulo largo 1", R.drawable.img1),
        new Titular("Título 2", "Subtítulo largo 2", R.drawable.img2),
        new Titular("Título 3", "Subtítulo largo 3", R.drawable.img3)

    };

    Titular tit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView lstOpciones = (ListView) findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                //String mensaje = "Título: " + datos[position].getTitulo() + " Subtítulo: " + datos[position].getSubtitulo();
                //Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();

                tit = new Titular(datos[position].getTitulo(), datos[position].getSubtitulo(), datos[position].getImagen()); //recoger el objeto
                Intent mio= new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                /*miBundle.putString("TEXTO1", datos[position].getTitulo()); //recoger uno por uno
                miBundle.putString("TEXTO2", datos[position].getSubtitulo());
                miBundle.putInt("IMAGEN", datos[position].getImagen());*/
                miBundle.putSerializable("TODO", tit);
                mio.putExtras(miBundle);
                startActivity(mio);
            }
        });
    }

    static class ViewHolder {
        TextView lblTitulo;
        TextView lblSubtitulo;
        ImageView lblImagen;
    }



    class AdaptadorTitulares extends ArrayAdapter {
        Activity context;
        AdaptadorTitulares(Activity context) {
            super(context, R.layout.listitem_titular, datos);
            this.context = context;
        }
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;
            if(item == null)
            { LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_titular, null);

                holder = new ViewHolder();
                holder.lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
                holder.lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
                holder.lblImagen = (ImageView)item.findViewById(R.id.ivlimagen);

                item.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)item.getTag(); }
                holder.lblTitulo.setText(datos[position].getTitulo());
                holder.lblSubtitulo.setText(datos[position].getSubtitulo());
                holder.lblImagen.setBackground(getDrawable(datos[position].getImagen()));
                return(item);
        }
    }
}
