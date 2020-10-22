package com.elaine.testjetpack.network;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.elaine.testjetpack.network.http.NetStateBean;


public class NetworkViewModel extends ViewModel {
    public MutableLiveData<NetStateBean> stateBeanMutableLiveDate = new MutableLiveData<>();

}
