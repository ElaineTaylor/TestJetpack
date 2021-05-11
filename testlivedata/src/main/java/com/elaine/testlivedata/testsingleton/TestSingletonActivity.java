package com.elaine.testlivedata.testsingleton;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.elaine.testlivedata.R;

public class TestSingletonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_singleton);

        BalanceLiveData.get().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(Float aFloat) {
                Log.e("余额发生了变化===", "TestSingletonActivity" + ":" + aFloat);
            }
        });
        BalanceManager.getInstance().setBalance(100.3f);
    }
}