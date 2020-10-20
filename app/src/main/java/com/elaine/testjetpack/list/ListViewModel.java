package com.elaine.testjetpack.list;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.elaine.testjetpack.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {
    public MutableLiveData<List<UserBean>> userBeanListMutableLiveData = new MutableLiveData<>();
    public List<UserBean> userBeanList = new ArrayList<>();

    public void initListData() {
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
        userBeanListMutableLiveData.setValue(userBeans);
    }

    public void refreshListData() {
        if (userBeanListMutableLiveData.getValue() != null) {
            List<UserBean> userBeans = userBeanListMutableLiveData.getValue();
            for (int i = 0; i < userBeans.size(); i++) {
                userBeans.get(i).setName("数据更新了后的name");
                userBeans.get(i).setNickname("数据更新了后的nickname");
            }
            userBeanListMutableLiveData.setValue(userBeans);
        } else {
            initListData();
        }
    }

    public void addListData() {
        if (userBeanListMutableLiveData.getValue() != null) {
            List<UserBean> userBeans = userBeanListMutableLiveData.getValue();
            UserBean userBean = new UserBean();
            userBean.setName("新的数据name");
            userBean.setNickname("新的数据nickname");
            userBean.setSex(0);
            userBeans.add(userBean);
            userBeanListMutableLiveData.setValue(userBeans);
        } else {
            initListData();
        }
    }
}
