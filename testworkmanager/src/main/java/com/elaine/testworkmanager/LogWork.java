package com.elaine.testworkmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * 日志任务
 * author: elaine
 * date: 2021/7/14
 */
public class LogWork extends Worker {

    public LogWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.e("doWork", "日志任务执行了");
        return Result.success();
    }
}
