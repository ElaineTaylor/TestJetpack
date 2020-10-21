package com.elaine.testjetpack.network.http;

public class NetBaseBean<T> {

    public static final int CODE_SUCCESS = 0;
    public static final int CODE_ERROR = 1;

    private int errorCode;
    private String errorMsg;
    private T data;

    public NetBaseBean(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = null;
    }

    public NetBaseBean(int errorCode, String errorMsg, T data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }
}
