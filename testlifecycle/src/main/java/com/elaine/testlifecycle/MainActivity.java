package com.elaine.testlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.elaine.testlifecycle.processlifecycleowner.LifecycleApp;
import com.elaine.testlifecycle.service.ServiceActivity;
import com.elaine.testlifecycle.widget.WidgetActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //组件和生命周期解耦
        Button btnWidget = findViewById(R.id.btn_widget);
        btnWidget.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, WidgetActivity.class)));
        //服务和生命周期解耦
        Button btnService = findViewById(R.id.btn_service);
        btnService.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ServiceActivity.class)));
        //ProcessLifecycleOwner解耦
        if (LifecycleApp.getInstance().getIsRunInBackground()) {
            Toast.makeText(this, "在后台", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "在前台", Toast.LENGTH_SHORT).show();
        }
    }
}