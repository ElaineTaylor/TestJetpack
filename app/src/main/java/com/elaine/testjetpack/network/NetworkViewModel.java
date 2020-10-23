package com.elaine.testjetpack.network;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.elaine.testjetpack.network.bean.ArticleBean;
import com.elaine.testjetpack.network.http.NetStateBean;
import com.elaine.testjetpack.network.http.RetrofitUtil;
import com.elaine.testjetpack.network.http.wan.WanResponse;
import com.elaine.testjetpack.network.http.wan.WanService;


public class NetworkViewModel extends ViewModel {
    public MutableLiveData<NetStateBean> stateBeanMutableLiveDate = new MutableLiveData<>();

    public LiveData<WanResponse<ArticleBean>> liveDataLiveData;

    public void init(){
        liveDataLiveData= RetrofitUtil.getInstance().createService(WanService.class).getArticle(1);
    }

}
