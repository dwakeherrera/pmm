package com.example.davher.myapplication;

import android.content.*;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class Pantalla1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        final EditText nombre= (EditText)findViewById(R.id.miTxt);
        final Button darSaludo= (Button)findViewById(R.id.miBtn);
        final TextView saludo= (TextView)findViewById(R.id.miLbl);

        darSaludo.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                String mensajePaso= "Te saludo " + nombre.getText();
                saludo.setText(mensajePaso);
                Intent mio= new Intent(Pantalla1.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("TEXTO", mensajePaso);
                mio.putExtras(miBundle);
                startActivity(mio);
            }
        });

        Toast.makeText(this, " esto es un TOAST", Toast.LENGTH_SHORT).show();
        //dialog
        new AlertDialog.Builder(this).setMessage("el texto").setPositiveButton(android.R.string.ok, null).show();
    }
}
