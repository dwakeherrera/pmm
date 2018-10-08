package com.example.davher.miaplicacion;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.support.v7.app.AlertDialog;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    public MediaPlayer miMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText miTexto= (EditText)findViewById(R.id.miTxt);
        final Button miBoton= (Button)findViewById(R.id.miBtn);
        final TextView elSaludo= (TextView)findViewById(R.id.miLbl);

        miMusica = MediaPlayer.create(getApplicationContext(), R.raw.quack);
        miMusica.start();

        miBoton.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                String mensajePaso= "Te saludo " + miTexto.getText();
                elSaludo.setText(mensajePaso);
                Intent mio= new Intent(MainActivity.this, Main2Activity.class);
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

    @Override protected void onStart() {
        super.onStart();
        Toast.makeText(this, "A1: onStart", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onResume() {
        super.onResume();
        Toast.makeText(this, "A1: onResume", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onPause() {
        Toast.makeText(this, "A1: onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
        miMusica.stop();
    }

    @Override protected void onStop() {
        super.onStop();
        Toast.makeText(this, "A1: onStop", Toast.LENGTH_SHORT).show();
    }
}
