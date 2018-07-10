package com.example.kobe.ProgressBar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.SeekBar;

/**
 * Author by kobe, Email 995270893@qq.com, Date on 2018/7/10.
 */
public class MySeekbar extends android.support.v7.widget.AppCompatSeekBar {
    private static final String TAG = "MySeekbar";
    private ThumbClickListener thumbClick;

    public MySeekbar(Context context) {
        super(context);
    }

    public MySeekbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySeekbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                if (isClickThumb(event,getThumb().getBounds())) {
                    thumbClick.onThumbClick();
                }
                break;
        }

        return true;
    }

    /**
     * 设置点击事件只在thumb上有效
     * @param event 点击事件
     * @param rect thumb
     */

    private boolean isClickThumb(MotionEvent event,Rect rect) {
        float x = event.getX();
        float y = event.getY();
        //根据左边距和thumb偏移量来确定thumb位置
        float left = rect.left + getPaddingLeft() - getThumbOffset();
        float right = left + rect.width();
        if (x >= left && x <= right
                && y >= rect.top && y <= rect.bottom)
            return true;
        return false;
    }


    public void setThumbClick(ThumbClickListener thumbClick) {
        this.thumbClick = thumbClick;
    }

    interface ThumbClickListener {
        void onThumbClick();
    }
}
