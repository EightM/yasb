package com.eightm.yasb.model;

public class GetInfoResult {
    private boolean ok;
    private User result;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public User getResult() {
        return result;
    }

    public void setResult(User result) {
        this.result = result;
    }
}
