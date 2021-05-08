package com.elaine.testlifecycle.widget;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.elaine.testlifecycle.R;

public class WidgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        CustomChronometer customChronometer = findViewById(R.id.cc_time);
        //组件添加监听
        getLifecycle().addObserver(customChronometer);
    }
}