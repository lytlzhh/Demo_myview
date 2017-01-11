package com.example.administrator.demo_myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/1/11/011.
 */

public class Myview extends View {
    private float text_size;
    private String text_str;
    private Drawable text_background;
    private int text_color;

    private RelativeLayout.LayoutParams textlayoutParams;

    /**/
    private Paint mpaint;

    public Myview(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Myview);

        text_size = typedArray.getDimension(R.styleable.Myview_Text_size, 0);
        text_background = typedArray.getDrawable(R.styleable.Myview_Text_background);
        text_color = typedArray.getColor(R.styleable.Myview_Text_color, 0);
        text_str = typedArray.getString(R.styleable.Myview_Text_text);

        typedArray.recycle();

/*如果自定义的view继承与四大布局之一，则应该自己要new一个想要的控件，在把其控件加入（onDraw()）到布局中*/
      /*  TextView textView = new TextView(context);

        textView.setText(text_str);
        textView.setTextSize(text_size);
        textView.setBackground(text_background);
        textView.setTextColor(text_color);


        textlayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textlayoutParams.addRule(CENTER_IN_PARENT, TRUE);

         addView(textView, textlayoutParams);*/


    }

    /*自定义view时应该要实现onDraw方法，在经过画布，画笔来勾画自己想要的视图*/
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mpaint = new Paint();
        mpaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mpaint.setColor(Color.BLUE);

        canvas.drawCircle(300, 300, 200, mpaint);
        canvas.drawText("小慕自定义标题!!", 300, 300, mpaint);


    }
}
