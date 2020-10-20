package com.elaine.testjetpack.basic;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.elaine.testjetpack.bean.UserBean;

public class BasicViewModel extends ViewModel {
    public MutableLiveData<UserBean> userBeanLiveData = new MutableLiveData<>();
    public MutableLiveData<String> tipLiveData=new MutableLiveData<>();

    public void initUserBean() {
        UserBean userBean = new UserBean();
        userBean.setName("李小斑");
        userBean.setNickname("木子喵喵");
        userBean.setSex(1);
        userBeanLiveData.setValue(userBean);
    }

    public void initTip(){
        tipLiveData.setValue("提示内容");
    }

}
