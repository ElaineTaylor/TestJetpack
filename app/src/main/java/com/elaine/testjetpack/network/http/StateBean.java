package com.elaine.testjetpack.network.http;

public class StateBean {
    private StateType stateType;
    private String msg;

    public StateBean(StateType stateType, String msg) {
        this.stateType = stateType;
        this.msg = msg;
    }

    public StateType getStateType() {
        return stateType;
    }

    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
