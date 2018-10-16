package com.example.davher.diferentesformasdeeventos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Context ctx = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_main);
        Button btn = (Button) this.findViewById(R.id.cmdTres);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ctx, "Pulsado boton Tres", Toast.LENGTH_SHORT).show();
            }
        }
        );
    }

    public void cmdDos_click(View v) {
        Toast.makeText(this, "Pulsado boton Dos",
                Toast.LENGTH_SHORT).show();
    }
}
