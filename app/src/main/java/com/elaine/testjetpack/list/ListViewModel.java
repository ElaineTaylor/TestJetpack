package com.elaine.testjetpack.list;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.elaine.testjetpack.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {
    public MutableLiveData<List<UserBean>> userBeanListMutableLiveData = new MutableLiveData<>();
    public List<UserBean> userBeanList = new ArrayList<>();

    public void getListData(){
        List<UserBean> userBeans = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            UserBean userBean = new UserBean();
            userBean.setName("name" + i);
            userBean.setNickname("nickname" + i);
            if (i % 2 == 0) {
                userBean.setSex(1);
            } else {
                userBean.setSex(0);
            }
            userBeans.add(userBean);
        }
        userBeanListMutableLiveData.postValue(userBeans);
    }
}
