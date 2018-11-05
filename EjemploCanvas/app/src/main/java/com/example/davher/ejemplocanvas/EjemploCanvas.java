package com.example.davher.ejemplocanvas;

import android.content.*;
import android.graphics.*;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.view.*;

public class EjemploCanvas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto) {
            super(contexto);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            Paint pincel1 = new Paint();
            pincel1.setColor(Color.RED);
            pincel1.setStyle(Paint.Style.STROKE);
            Paint pincel2 = new Paint();
            pincel2.setColor(Color.BLUE);
            pincel1.setStrokeWidth(20);
            pincel2.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(500, 500, 300, pincel1);
            canvas.drawText("MI CIRCULO", 500, 900, pincel1);

            int anchura = getWidth();
            int altura = getHeight();

            String mensaje = "("+ anchura +"," + altura + ")";

            canvas.drawText("mensaje", 500, 1000, pincel2);
        }
    }
}
