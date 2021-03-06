package com.example.davher.ejemplomenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class MiDibujo extends View {
    private ShapeDrawable miDrawable;
    public MiDibujo(Context c) {
        super(c);
    }
    public MiDibujo(Context c, AttributeSet a) {
        super(c, a);
    }
    @Override
    protected void onDraw(Canvas lienzo) {
        Paint miPincel = new Paint();
        miPincel.setColor(Color.RED);
        miPincel.setStyle(Paint.Style.STROKE);
        lienzo.drawCircle(720, 1056, 600, miPincel); //x y lo sacamos de ancho y alto dividido entre 2

        int ancho = getWidth();
        int alto = getHeight();

        //Otra forma de dibujo usando ShapeDrawable
        super.onDraw(lienzo);
        int radius = 100;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        paint.setColor(Color.parseColor("#000000"));

        //lienzo.drawRect(50, 50, 200, 200, paint);

        int x = getWidth()/2;
        int y = getHeight()/2;
        ancho = 300;
        alto = 200;
        lienzo.drawRect(getLeft()+(getRight()-getLeft())/3,
                getTop()+(getBottom()-getTop())/3,
                getRight()-(getRight()-getLeft())/3,
                getBottom()-(getBottom()-getTop())/3,paint);
    }
}
