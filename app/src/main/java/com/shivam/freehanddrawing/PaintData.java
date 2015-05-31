package com.shivam.freehanddrawing;

import android.graphics.Paint;

/**
 * Created by Shivam on 5/24/2015.
 */
public class PaintData {
    private int fgColor;
    private int bgColor;
    private int strokeWidth;

    public PaintData(int fgColor, int bgColor, int strokeWidth) {
        this.bgColor = bgColor;
        this.fgColor = fgColor;
        this.strokeWidth = strokeWidth;
    }

    public int getBgColor() {

        return bgColor;
    }

    public void setBgColor(int bgColor) {

        this.bgColor = bgColor;
    }

    public int getFgColor() {
        return fgColor;
    }

    public void setFgColor(int fgColor) {
        this.fgColor = fgColor;
    }

    public int getStrokeWidth() {

        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}
