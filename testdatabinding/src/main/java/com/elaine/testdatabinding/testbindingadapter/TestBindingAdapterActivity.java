package com.elaine.testdatabinding.testbindingadapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.elaine.testdatabinding.R;
import com.elaine.testdatabinding.databinding.ActivityTestBindingAdapterBinding;

public class TestBindingAdapterActivity extends AppCompatActivity {

    private ActivityTestBindingAdapterBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_binding_adapter);
        mBinding.setMyImageRes(R.mipmap.ic_launcher_round);
        mBinding.setContent("正式数据");
        mBinding.setDefaultContent("默认数据");
    }
}