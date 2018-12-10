package com.example.davher.solobicifragmento;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AcercaDe extends AppCompatActivity {
    View miFragmento;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Hacemos visible la interfaz/layout que se encuentra en acercade.xml
        setContentView(R.layout.acercade);
        miFragmento = (View)findViewById(R.id.ejemplo);
        miFragmento.setVisibility(View.VISIBLE);
    }
}
