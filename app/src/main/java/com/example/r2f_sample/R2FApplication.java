package com.example.r2f_sample;

import android.app.Application;
import android.content.Context;

public class R2FApplication extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context GetAppContext() {
        return context;
    }

}
