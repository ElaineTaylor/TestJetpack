package com.elaine.testjetpack.main;

import androidx.lifecycle.ViewModelProvider;

import com.elaine.testjetpack.R;
import com.elaine.testjetpack.base.BaseActivity;
import com.elaine.testjetpack.databinding.ActivityMainBinding;
import com.elaine.testjetpack.manager.GotoManager;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private MainViewModel mainViewModel;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        initViewModel();
        initObserve();
    }

    private void initViewModel() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mBinding.setViewModel(mainViewModel);
        mBinding.setLifecycleOwner(this);
    }

    private void initObserve() {
        mainViewModel.intentKey.observe(this, intentKey -> {
            GotoManager.toActivity(intentKey, this);
        });
    }

}