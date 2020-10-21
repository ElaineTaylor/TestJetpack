package com.elaine.testjetpack.network;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.elaine.testjetpack.network.http.StateBean;

public class NetworkViewModel extends ViewModel {
    public MutableLiveData<StateBean> stateBeanMutableLiveDate = new MutableLiveData<>();
}
