package com.cslong.app.lifetools;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;

/**
 * Created by chenlongjian on 2018/6/22.
 */

public class AppContext extends Application {
    private static AppContext sAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;
        Utils.init(this);

    }

    public static Context getAppContext() {
        if (sAppContext == null) {
            throw new IllegalStateException("Application is not created.");
        }
        return sAppContext;
    }

    public static void ignoreUpdate() {
        sIgnoreUpdate = true;
    }

    public static boolean shouldCheckUpdateAuto() {
        return sIgnoreUpdate == false;
    }

    private static boolean sIgnoreUpdate = false;
}
