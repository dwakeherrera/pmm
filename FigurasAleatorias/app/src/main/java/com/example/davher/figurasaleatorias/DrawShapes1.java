package com.example.davher.figurasaleatorias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DrawShapes1 extends AppCompatActivity {
    private RandomShapeView miDrawingArea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_shapes1);
        miDrawingArea = (RandomShapeView)findViewById(R.id.drawing_area);
    }

    public void redraw(View clickedButton) {
        miDrawingArea.invalidate();
    }
}
