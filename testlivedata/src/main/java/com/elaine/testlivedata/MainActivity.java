package com.elaine.testlivedata;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class MainActivity extends AppCompatActivity {
    private MutableLiveData<String> userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("activity===", "onCreate");
        testLiveData();
    }

    private void testLiveData() {
        userName = new MutableLiveData<>();
        userName.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("change----", s);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("activity===", "onStart");
        userName.setValue("onStart:username==eeee");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("activity===", "onResume");
        userName.setValue("onResume:username==aaaa");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("activity===", "onRestart");
        userName.setValue("onRestart:username==ffff");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("activity===", "onPause");
        userName.setValue("onPause:username==bbbb");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("activity===", "onStop");
        userName.setValue("onStop:username==cccc");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("activity===", "onDestroy");
        userName.setValue("onDestroy:username==dddd");
    }
}