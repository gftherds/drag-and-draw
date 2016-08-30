package com.example.therdsak.draganddraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Therdsak on 8/30/2016.
 */
public class PointFingerView extends View {

    private static final String TAG = "PointFingerView";
    private Paint mBoxPaint;
    private Paint mBackgroundPaint;
    private List<PointF> mCircleCList = new ArrayList<>();


    public PointFingerView(Context context) {
        super(context, null);
    }

    public PointFingerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mBoxPaint = new Paint();
        mBoxPaint.setColor(0x33669900);

        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(0xFF66FFe0);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(mBackgroundPaint);


        for(PointF p  : mCircleCList){
            canvas.drawCircle(p.x,p.y,150,mBoxPaint);
       }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = MotionEventCompat.getActionMasked(event);
        int index = MotionEventCompat.getActionIndex(event);
        int touchCount = event.getPointerCount();


       switch (action){
           case MotionEvent.ACTION_DOWN:
               mCircleCList.add( new PointF(event.getX(),event.getY()));
               break;

           case MotionEvent.ACTION_MOVE:
              for(int i = 0 ; i < touchCount; i++){
               mCircleCList.get(i).x = event.getX(i);
               mCircleCList.get(i).y = event.getY(i);
           }

               break;

           case MotionEvent.ACTION_UP:
           case MotionEvent.ACTION_CANCEL:
               mCircleCList.clear();
               break;

           case MotionEvent.ACTION_POINTER_DOWN :
               mCircleCList.add( new PointF(event.getX(index),event.getY(index)));
               break;

           case MotionEvent.ACTION_POINTER_UP:
               mCircleCList.remove(index);
               break;

       }
        invalidate();
        return true;

    }

    public static String actionToString(int action) {
        switch (action) {

            case MotionEvent.ACTION_DOWN: return "Down";
            case MotionEvent.ACTION_MOVE: return "Move";
            case MotionEvent.ACTION_POINTER_DOWN: return "Pointer Down";
            case MotionEvent.ACTION_UP: return "Up";
            case MotionEvent.ACTION_POINTER_UP: return "Pointer Up";
            case MotionEvent.ACTION_OUTSIDE: return "Outside";
            case MotionEvent.ACTION_CANCEL: return "Cancel";
        }
        return "";
    }
}
