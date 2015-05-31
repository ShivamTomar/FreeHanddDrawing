package com.shivam.freehanddrawing.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

import com.shivam.freehanddrawing.PaintData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Shivam on 5/24/2015.
 */
public class DrawingView extends View{
    private float x;
    private float y;
    private PaintData paintData;
    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    private List<Queue<Pair<Float,Float>>> listPathPoints = new ArrayList<Queue<Pair<Float, Float>>>();

    public void setPaintData(PaintData paintData) {
        this.paintData = paintData;
    }

    private Queue<Pair<Float,Float>> queue;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                queue = new LinkedList<Pair<Float, Float>>();
                listPathPoints.add(queue);
                queue.add(new Pair(event.getX(),event.getY()));
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                queue.add(new Pair(event.getX(),event.getY()));
                invalidate();
                break;
            case  MotionEvent.ACTION_UP:
                break;
        }
        return  true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(paintData.getBgColor());
        canvas.drawRect(new RectF(0, 0, getWidth(), getHeight()), paint);
        paint.setColor(paintData.getFgColor());
        paint.setStrokeWidth(paintData.getStrokeWidth());
         for (Queue<Pair<Float, Float>> listPathPoint : listPathPoints) {
            drawPath(canvas,listPathPoint,paint);
        }
    }

    private void drawPath(Canvas canvas, Queue<Pair<Float,Float>> queue,Paint paint) {
        for (Pair<Float, Float> floatFloatPair : queue) {
            canvas.drawPoint(floatFloatPair.first,floatFloatPair.second,paint);
        }
    }
}






