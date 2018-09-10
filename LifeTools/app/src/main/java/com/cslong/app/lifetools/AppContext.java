package com.cslong.app.lifetools;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

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


//
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(sAppContext);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

// Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());


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
