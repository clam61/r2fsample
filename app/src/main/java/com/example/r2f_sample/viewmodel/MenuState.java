package com.example.r2f_sample.viewmodel;

/*
 * Represents the state of the menu activity.  Right now the only information we need is
 * whether submitting the textfields was successful or not
 */
public class MenuState {
    private boolean success;

    public MenuState(boolean success) {
        this.success = success;
    }
    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
