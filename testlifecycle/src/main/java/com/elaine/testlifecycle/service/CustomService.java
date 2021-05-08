package com.elaine.testlifecycle.service;

import androidx.lifecycle.LifecycleService;

/**
 * 服务
 * 继承LifecycleService
 */
public class CustomService extends LifecycleService {

    public CustomService() {
        CustomServiceObserver customServiceObserver = new CustomServiceObserver();
        //服务的生命周期添加观察者
        getLifecycle().addObserver(customServiceObserver);
    }
}