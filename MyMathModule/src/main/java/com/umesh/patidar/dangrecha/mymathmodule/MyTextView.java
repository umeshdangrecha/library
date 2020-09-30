package com.umesh.patidar.dangrecha.mymathmodule;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;

/**
 * Created by umesh
 * on 30-09-2020 12:26.
 * project :- Threads And Services
 */
public class MyTextView extends androidx.appcompat.widget.AppCompatTextView {
    private static final String TAG = "abcd";
    private MyTextView textView;
    private Context context;
    private int height;
    private int width;
    private float density;
    private Paint paint = new Paint();

    public MyTextView(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
    }


    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initDisplaySize();
        init();
    }

    private void initDisplaySize() {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;
        density = dm.density;
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(getLineHeight() / 10);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float startX = getPaddingLeft();
        float stopX = getWidth() - getPaddingRight();
        float offsetY = getPaddingTop() - getPaint().getFontMetrics().top + paint.getStrokeWidth() / 2;

//        for (int i = 0; i < getLineCount(); ++i) {
//            float y = offsetY + getLineHeight() * i;
//            canvas.drawLine(startX, y, stopX, y, paint);
//        }

        super.onDraw(canvas);
    }


    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {

        int h = params.height;
        int w = params.width;
        if (h != -1 && h != -2) {
            h = (int) (height * 0.01 * h / density);
            params.height = h;
        }
        if (w != -1 && w != -2) {
            w = (int) (width * 0.01 * w / density);
            params.width = w;
        }

        Log.i(TAG, "setLayoutParams: height :" + params.height);
        Log.i(TAG, "setLayoutParams: width : " + params.width);
        Log.i(TAG, "setLayoutParams: ");
        super.setLayoutParams(params);
    }

    @Override
    public void setTextSize(float size) {
        Log.i(TAG, "setTextSize: ");
        super.setTextSize(5);
    }

    @Override
    public CharSequence getText() {
        Log.i(TAG, "getText: get text called ");
        return super.getText();
    }
}
