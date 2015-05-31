package com.shivam.freehanddrawing;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.shivam.freehanddrawing.views.DrawingView;

public class DrawingActivity extends Activity implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {


    private RadioGroup rbGroup;

    private Spinner spinnerFgColor;
    private Spinner spinnerBgColor;
    private PaintData paintData;
    private DrawingView drawingView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        rbGroup = (RadioGroup) findViewById(R.id.rbg_width);
        spinnerBgColor = (Spinner) findViewById(R.id.spineer_bg_color);
        spinnerFgColor = (Spinner) findViewById(R.id.spineer_fg_color);
        spinnerBgColor.setAdapter(new ColorChooserAdapter(this));
        spinnerFgColor.setAdapter(new ColorChooserAdapter(this));
        paintData = new PaintData(getResources().getColor(C.COLORS[0]), getResources().getColor(C.COLORS[1]), C.STROKE_WIDTH[1]);
        spinnerBgColor.setOnItemSelectedListener(this);
        spinnerFgColor.setOnItemSelectedListener(this);
        rbGroup.setOnCheckedChangeListener(this);
        drawingView = (DrawingView) findViewById(R.id.id_drawing_view);
        drawingView.setPaintData(paintData);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_drawing, menu);
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_large:
                paintData.setStrokeWidth(C.STROKE_WIDTH[2]);
                break;
            case R.id.rb_medium:
                paintData.setStrokeWidth(C.STROKE_WIDTH[1]);
                break;
            case R.id.rb_small:

                paintData.setStrokeWidth(C.STROKE_WIDTH[0]);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.equals(spinnerFgColor)) {
            paintData.setFgColor(getResources().getColor(C.COLORS[i]));
        } else {
            paintData.setBgColor(getResources().getColor(C.COLORS[i]));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


