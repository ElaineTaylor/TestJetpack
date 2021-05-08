package com.elaine.testjetpack.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public MutableLiveData<Integer> intentKey = new MutableLiveData<>();

    public void setIntentKey(int key) {
        intentKey.setValue(key);
    }


}
