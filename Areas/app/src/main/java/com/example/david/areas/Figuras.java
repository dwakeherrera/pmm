package com.example.david.areas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Figuras extends AppCompatActivity {

    int ancho, alto;
    String seleccion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ancho = getIntent().getIntExtra("BASE", 0);
        alto = getIntent().getIntExtra("ALTURA", 0);
        seleccion = getIntent().getStringExtra("SELECCION");

        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView (Context context) {
            super(context);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        protected void onDraw (Canvas canvas) {
            Paint pincel = new Paint();
            pincel.setColor(Color.BLACK);
            pincel.setStrokeWidth(5);
            pincel.setStyle(Paint.Style.STROKE);

            pincel.setAntiAlias(true);

            Point center = new Point(getWidth() / 2, getHeight() / 2);

            switch (seleccion) {
                case "circle":
                    canvas.drawCircle(center.x, center.y, ancho, pincel);
                    break;
                case "rectangle":
                    int left = center.x - (ancho / 2);
                    int top = center.y - (alto / 2);
                    int right = center.x + (ancho / 2);
                    int bottom = center.y + (alto / 2);

                    canvas.drawRect(left,top, right, bottom, pincel);
                    break;
                case "triangle":
                    Path path = new Path();
                    path.moveTo(center.x - ancho / 2, center.y + alto / 2);
                    path.lineTo(center.x + ancho / 2, center.y + alto / 2);
                    path.moveTo(center.x + ancho / 2, center.y + alto / 2);
                    path.lineTo(center.x, center.y - alto / 2);
                    path.moveTo(center.x, getHeight() / 2 - alto / 2);
                    path.lineTo(center.x - ancho / 2, center.y + alto / 2);
                    path.close();

                    canvas.drawPath(path, pincel);
                    break;
                default:
                    startActivity(new Intent(Figuras.this, MainActivity.class));
                    break;
            }

        }
    }
}