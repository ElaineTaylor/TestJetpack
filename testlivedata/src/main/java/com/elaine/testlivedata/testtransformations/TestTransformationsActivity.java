package com.elaine.testlivedata.testtransformations;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

import com.elaine.testlivedata.R;

public class TestTransformationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_transformations);
        use();
        useTwo();
        useThree();
    }

    /**
     * 把用户的UserId转为字符串，前面加上"用户ID："，用于UI填充
     */
    private void use() {
        MutableLiveData<Integer> userId = new MutableLiveData<>();
        LiveData<String> userIdString = Transformations.map(userId, new Function<Integer, String>() {
            @Override
            public String apply(Integer userId) {
                return "用户ID：" + userId;
            }
        });
        userIdString.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("更改后的数据====", s);
            }
        });
        userId.setValue(13);
    }

    /**
     * 功能：判断男孩还是女孩
     */
    private void useTwo() {
        MutableLiveData<Integer> sex = new MutableLiveData<>();
        MutableLiveData<String> girl = new MutableLiveData<>();
        MutableLiveData<String> boy = new MutableLiveData<>();
        LiveData<String> sexString = Transformations.switchMap(sex, new Function<Integer, LiveData<String>>() {

            @Override
            public LiveData<String> apply(Integer input) {
                if (input == 0) {
                    return girl;
                }
                return boy;
            }
        });
        sexString.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("sex===", s);
            }
        });
        girl.setValue("女孩");
        boy.setValue("男孩");
        sex.setValue(0);
    }

    /**
     * 功能：先读本地的内容，再读网络的内容，如果网络有，则优先网络的内容，若无，则默认本地的内容
     */
    private void useThree() {
        //本地储存得到的跳转到QQ的地址字符串
        MutableLiveData<String> toQQLocal = new MutableLiveData<>();
        //网络请求得到的跳转到QQ的地址字符串
        MutableLiveData<String> toQQNetwork = new MutableLiveData<>();
        //合并观察者
        MediatorLiveData<String> toQQMediator = new MediatorLiveData<>();

        toQQMediator.addSource(toQQLocal, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                toQQMediator.setValue(s);
            }
        });
        toQQMediator.addSource(toQQNetwork, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                toQQMediator.setValue(s);
            }
        });
        toQQMediator.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("qq====", s);
            }
        });

        toQQLocal.setValue("local===To====QQ");
        toQQNetwork.setValue("network===To===QQ");
    }
}