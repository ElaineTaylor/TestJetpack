package com.elaine.testlivedata.testsingleton;

import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;

/**
 * author: elaine
 * date: 2021/5/10
 */
public class BalanceLiveData extends LiveData<Float> {
    private static BalanceLiveData instance;
    private BalanceManager balanceManager;

    private ChangeBalanceListener changeBalanceListener = new ChangeBalanceListener() {
        @Override
        public void onChange(float balance) {
            setValue(balance);
        }
    };

    @MainThread
    public static BalanceLiveData get() {
        if (instance == null) {
            instance = new BalanceLiveData();
        }
        return instance;
    }

    private BalanceLiveData() {
        balanceManager = new BalanceManager();
    }

    @Override
    protected void onActive() {
        super.onActive();
        balanceManager.addListener(changeBalanceListener);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        balanceManager.removeListener(changeBalanceListener);
    }

}
