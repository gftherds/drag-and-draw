package com.example.therdsak.draganddraw;

import android.graphics.PointF;

/**
 * Created by Therdsak on 8/30/2016.
 */
public class Box {
    PointF Start;
    PointF End;

    public PointF getEnd() {
        return End;
    }

    public void setEnd(PointF end) {
        this.End = end;
    }

    public PointF getStart() {
        return Start;
    }

    public void setStart(PointF start) {
        this.Start = start;
    }
}
