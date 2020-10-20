package com.elaine.testjetpack.callback;

public interface DialogCallback {
    /**
     * 弹窗消失事件
     *
     * @param type 类型
     */
    void onDismiss(int type);

    /**
     * 点击事件
     *
     * @param o 返回值
     */
    void onClick(Object o);
}
