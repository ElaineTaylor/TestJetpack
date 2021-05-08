package com.elaine.testlifecycle.processlifecycleowner;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

/**
 * ProcessLifecycleOwner
 * 管理Application生命周期
 * <p>
 * author: elaine
 * date: 2021/5/6
 */
public class LifecycleApp extends Application {
    //用于判断APP是否在后台
    private static boolean isRunInBackground;
    //自身
    private static LifecycleApp instance;

    /**
     * 对外开放的方法
     *
     * @return LifecycleApp
     */
    public static LifecycleApp getInstance() {
        return instance;
    }

    /**
     * 判断APP是否在后台
     * 对外开放的方法
     *
     * @return 是否在后台
     */
    public boolean getIsRunInBackground() {
        return isRunInBackground;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //ApplicationLifecycleObserver加入生命周期监听
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ApplicationLifecycleObserver());
    }

    /**
     * 监听APP进入前台或后台
     */
    private static class ApplicationLifecycleObserver implements LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        private void onAppForeground() {
            Log.e("app====", "app在前台");
            isRunInBackground = false;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        private void onAppBackground() {
            Log.e("app====", "app在后台");
            isRunInBackground = true;
        }
    }
}
