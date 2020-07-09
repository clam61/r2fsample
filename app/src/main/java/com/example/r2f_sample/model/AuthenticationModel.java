package com.example.r2f_sample.model;

import com.example.r2f_sample.viewmodel.LoginValid;

public class AuthenticationModel {
    public boolean login(String u, String p) {
        return u.equals("a@a.com") && p.equals("pass");
    }
}
