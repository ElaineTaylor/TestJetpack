package com.elaine.testlifecycle.service;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.elaine.testlifecycle.R;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Button btnStart = findViewById(R.id.btn_start);
        Button btnStop = findViewById(R.id.btn_stop);
        //开启服务
        btnStart.setOnClickListener(v -> startService(new Intent(ServiceActivity.this, CustomService.class)));
        //关闭服务
        btnStop.setOnClickListener(v -> stopService(new Intent(ServiceActivity.this, CustomService.class)));
    }
}