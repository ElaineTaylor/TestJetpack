package com.elaine.testlivedata.testsingleton;

/**
 * author: elaine
 * date: 2021/5/10
 */
public class BalanceManager {
    private volatile static BalanceManager balanceManager;
    private ChangeBalanceListener changeBalanceListener;

    public static BalanceManager getInstance() {
        if (balanceManager == null) {
            synchronized (BalanceManager.class) {
                if (balanceManager == null) {
                    balanceManager = new BalanceManager();
                }
            }
        }
        return balanceManager;
    }

    public void setBalance(float balance) {
        changeBalanceListener.onChange(balance);
    }

    public void addListener(ChangeBalanceListener changeBalanceListener) {
        this.changeBalanceListener = changeBalanceListener;
    }

    public void removeListener(ChangeBalanceListener changeBalanceListener) {
        if (changeBalanceListener != null) {
            changeBalanceListener = null;
        }
    }
}
