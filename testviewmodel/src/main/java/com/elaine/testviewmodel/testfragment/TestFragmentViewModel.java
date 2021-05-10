package com.elaine.testviewmodel.testfragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * BottomFragment和UpFragment公有的ViewModel
 * author: elaine
 * date: 2021/5/10
 */
public class TestFragmentViewModel extends ViewModel {
    private MutableLiveData<Boolean> isOpen;

    public MutableLiveData<Boolean> getIsOpen() {
        if (isOpen == null) {
            isOpen = new MutableLiveData<>();
            isOpen.setValue(false);
        }
        return isOpen;
    }
}
