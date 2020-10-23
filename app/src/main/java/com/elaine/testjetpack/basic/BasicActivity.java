package com.elaine.testjetpack.basic;

import androidx.lifecycle.ViewModelProvider;

import com.elaine.testjetpack.R;
import com.elaine.testjetpack.base.BaseActivity;
import com.elaine.testjetpack.databinding.ActivityViewModelBinding;

public class BasicActivity extends BaseActivity<ActivityViewModelBinding> {

    @Override
    public int getLayout() {
        return R.layout.activity_view_model;
    }

    @Override
    public void init() {
        initViewModel();
    }

    private void initViewModel() {
        BasicViewModel basicViewModel = new ViewModelProvider(this).get(BasicViewModel.class);
        mBinding.setViewModel(basicViewModel);
        mBinding.setLifecycleOwner(this);
    }



}