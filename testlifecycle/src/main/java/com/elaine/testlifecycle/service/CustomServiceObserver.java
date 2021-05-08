package com.elaine.testlifecycle.service;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 服务生命周期观察
 *
 * author: elaine
 * date: 2021/5/7
 */
public class CustomServiceObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void startGetInternetState() {
        Log.e("网络情况=======", "开始获取");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void stopGetInternetState() {
        Log.e("网络情况=======", "结束获取");
    }

}
