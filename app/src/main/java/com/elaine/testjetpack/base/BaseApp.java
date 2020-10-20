package com.elaine.testjetpack.base;

import android.app.Application;

public class BaseApp extends Application {
    public static BaseApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
