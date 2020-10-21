package com.elaine.testjetpack.network;

import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.elaine.testjetpack.R;
import com.elaine.testjetpack.base.BaseActivity;
import com.elaine.testjetpack.databinding.ActivityNetworkBinding;
import com.elaine.testjetpack.network.bean.ArticleBean;
import com.elaine.testjetpack.network.http.HttpService;
import com.elaine.testjetpack.network.http.NetBaseBean;
import com.elaine.testjetpack.network.http.NetStateBean;
import com.elaine.testjetpack.network.http.RetrofitUtil;
import com.google.gson.Gson;

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
        initData();
    }

    private void initViewModel() {
        networkViewModel = new ViewModelProvider(this).get(NetworkViewModel.class);
        mBinding.setViewModel(networkViewModel);
        mBinding.setLifecycleOwner(this);
    }

    private void initObserve() {
        networkViewModel.stateBeanMutableLiveDate.observe(this, new Observer<NetStateBean>() {
            @Override
            public void onChanged(NetStateBean netStateBean) {

            }
        });
    }

    private void initData() {
        RetrofitUtil.getInstance().createService(HttpService.class).getArticle(1).observe(this, new Observer<NetBaseBean<ArticleBean>>() {
            @Override
            public void onChanged(NetBaseBean<ArticleBean> articleBeanNetBaseBean) {
                Log.e("data======", new Gson().toJson(articleBeanNetBaseBean));
            }
        });

    }


}