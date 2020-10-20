package com.elaine.testjetpack.main;

import android.content.Intent;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.elaine.testjetpack.R;
import com.elaine.testjetpack.base.BaseActivity;
import com.elaine.testjetpack.basic.BasicViewModel;
import com.elaine.testjetpack.databinding.ActivityMainBinding;
import com.elaine.testjetpack.basic.BasicActivity;
import com.elaine.testjetpack.dialog.DialogActivity;
import com.elaine.testjetpack.list.ListActivity;

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
            switch (intentKey) {
                case 1:
                    startActivity(new Intent(MainActivity.this, BasicActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(MainActivity.this, DialogActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(MainActivity.this, ListActivity.class));
                    break;
                default:
                    break;
            }
        });
    }

}