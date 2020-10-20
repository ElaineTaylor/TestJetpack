package com.elaine.testjetpack.dialog;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DialogViewModel extends ViewModel {
    public MutableLiveData<Boolean> isShowDialog = new MutableLiveData<>();

    public void showDialog(){
        isShowDialog.setValue(true);
    }

}
