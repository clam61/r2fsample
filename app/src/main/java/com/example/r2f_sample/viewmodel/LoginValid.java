package com.example.r2f_sample.viewmodel;

import com.example.r2f_sample.R;

public class LoginValid {
    private boolean valid;

    public LoginValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return this.valid;
    }

    public Integer getLoginError() { return R.string.login_failed; }
}
