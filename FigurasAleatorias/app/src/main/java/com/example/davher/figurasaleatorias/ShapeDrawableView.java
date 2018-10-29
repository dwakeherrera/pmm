package com.example.davher.figurasaleatorias;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.graphics.drawable.shapes.*;
import android.util.*;
import android.view.*;
import java.util.*;

public class ShapeDrawableView extends View {
    private List<ShapeDrawable> shapes = new ArrayList<ShapeDrawable>();
    private Integer[] mColors =
            { Color.BLACK, Color.BLUE, Color.GREEN, Color.RED };

    public ShapeDrawableView(Context context) {
        super(context);    }

    public ShapeDrawableView(Context context, AttributeSet attrs) {
        super(context, attrs);    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(ShapeDrawable shape: shapes) {  shape.draw(canvas);  }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int)event.getX(); // Use getX(int) for multi-finger gestures
            int y = (int)event.getY();
            if (!isDeletingExistingShape(x, y)) {
                shapes.add(makeShapeDrawable(x, y));
            }
            invalidate();
            return (true);  // Handled touch event
        } else {
            return (false); // Did not handle touch event
        }
    }

    private boolean isDeletingExistingShape(int x, int y) {
        for(ShapeDrawable shape: shapes) {
            Rect bounds = shape.getBounds();
            if (bounds.contains(x, y)) {
                shapes.remove(shape);
                return(true);
            }
        }
        return(false);
    }

    private ShapeDrawable makeShapeDrawable(int x, int y) {
        int maxWidth = getWidth()/10;
        int maxHeight = getHeight()/10;
        Shape shape;
        if (Math.random() < 0.5) {
            shape = new OvalShape();
        } else {
            shape = new RectShape();
        }
        ShapeDrawable shapeD = new ShapeDrawable(shape);
        int width = RandomUtils.randomInt(maxWidth)+5;
        int height = RandomUtils.randomInt(maxHeight)+5;
        shapeD.setBounds(x-width/2, y-height/2, x+width/2, y+height/2);
        shapeD.getPaint().setColor(RandomUtils.randomElement(mColors));
        return(shapeD);
    }
}
