package com.elaine.testlifecycle.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 计时器
 * 页面显示则计时，若不显示则停止计时
 * author: elaine
 * date: 2021/5/7
 */
public class CustomChronometer extends Chronometer implements LifecycleObserver {
    //退出的时间
    private long exitTime;

    public CustomChronometer(Context context) {
        super(context);
    }

    public CustomChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomChronometer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void startTime() {
        setBase(SystemClock.elapsedRealtime() - exitTime);
        start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void stopTime() {
        exitTime = SystemClock.elapsedRealtime() - getBase();
        stop();
    }
}
