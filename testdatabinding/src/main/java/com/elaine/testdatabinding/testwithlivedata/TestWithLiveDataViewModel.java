package com.elaine.testdatabinding.testwithlivedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * author: elaine
 * date: 2021/5/13
 */
public class TestWithLiveDataViewModel extends ViewModel {
    private MutableLiveData<String> content;

    public MutableLiveData<String> getContent() {
        if (content == null) {
            content = new MutableLiveData<>();
            content.setValue("默认数据");
        }
        return content;
    }

    public void setContent(String con) {
        content.setValue(con);
    }
}
