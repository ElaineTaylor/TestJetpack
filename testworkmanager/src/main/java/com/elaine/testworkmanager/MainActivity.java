package com.elaine.testworkmanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startLogWork();
    }

    private void startLogWork() {
        //设置触发条件
        Constraints constraints = new Constraints.Builder()
                //对网络没有要求
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .build();

        //单次工作请求
        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(LogWork.class)
                //设置触发条件
                .setConstraints(constraints)
                .build();
        //任务manager
        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest);
    }
}