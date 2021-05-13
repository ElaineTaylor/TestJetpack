package com.elaine.testdatabinding.testwithlivedata;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.elaine.testdatabinding.R;
import com.elaine.testdatabinding.databinding.ActivityTestWithLiveDataBinding;

public class TestWithLiveDataActivity extends AppCompatActivity {

    private ActivityTestWithLiveDataBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_with_live_data);
        TestWithLiveDataViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(TestWithLiveDataViewModel.class);
        mBinding.setViewModel(viewModel);
        mBinding.setLifecycleOwner(this);
    }
}