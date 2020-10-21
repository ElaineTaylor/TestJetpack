package com.elaine.testjetpack.network;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.elaine.testjetpack.network.bean.ArticleBean;
import com.elaine.testjetpack.network.http.HttpService;
import com.elaine.testjetpack.network.http.NetStateBean;
import com.elaine.testjetpack.network.http.RetrofitUtil;

import java.util.List;


public class NetworkViewModel extends ViewModel {
    public MutableLiveData<NetStateBean> stateBeanMutableLiveDate = new MutableLiveData<>();

    public void getData(){

    }
}
