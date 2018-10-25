package com.example.davher.unirdibujos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UnirDibujos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }

    class MiDibujo extends View {
        private ShapeDrawable miDrawable;
        public MiDibujo(Context c) {
            super(c);
        }
        @Override
        protected void onDraw(Canvas lienzo) {
            Paint miPincel = new Paint();
            miPincel.setColor(Color.RED);
            miPincel.setStyle(Paint.Style.STROKE);
            lienzo.drawCircle(720, 1056, 600, miPincel); //x y lo sacamos de ancho y alto dividido entre 2

            miPincel.setTextSize(60);
            miPincel.setTextAlign(Paint.Align.CENTER);
            lienzo.drawText("MI CIRCULO", 720, 1056, miPincel);
            String mensaje= "Ancho: " + getWidth()+ " Alto:" + getHeight();
            lienzo.drawText(mensaje,720,1056,miPincel);
            Toast.makeText(getApplicationContext(), "más dibujos", Toast.LENGTH_SHORT).show();

            int ancho = getWidth();
            int alto = getHeight();

            //Otra forma de dibujo usando ShapeDrawable
            int x = 500;
            int y = 1300;
            miDrawable = new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x, y, x + ancho, y + alto);

            miDrawable.draw(lienzo);
        }
    }
}
