package com.elaine.testjetpack.network;

import androidx.lifecycle.ViewModelProvider;

import com.elaine.testjetpack.R;
import com.elaine.testjetpack.base.BaseActivity;
import com.elaine.testjetpack.databinding.ActivityNetworkBinding;

public class NetworkActivity extends BaseActivity<ActivityNetworkBinding> {
    private NetworkViewModel networkViewModel;

    @Override
    public int getLayout() {
        return R.layout.activity_network;
    }

    @Override
    public void init() {
        initViewModel();
        initObserve();
    }

    private void initViewModel() {
        networkViewModel = new ViewModelProvider(this).get(NetworkViewModel.class);
        mBinding.setViewModel(networkViewModel);
        mBinding.setLifecycleOwner(this);
    }

    private void initObserve() {

    }

}