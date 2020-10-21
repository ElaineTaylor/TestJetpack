package com.elaine.testjetpack.network.http;

public class NetStateBean {
    private NetStateType netStateType;
    private String msg;

    public NetStateBean(NetStateType netStateType, String msg) {
        this.netStateType = netStateType;
        this.msg = msg;
    }

    public NetStateType getNetStateType() {
        return netStateType;
    }

    public void setNetStateType(NetStateType netStateType) {
        this.netStateType = netStateType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
