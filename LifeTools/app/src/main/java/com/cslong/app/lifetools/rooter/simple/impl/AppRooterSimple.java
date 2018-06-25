package com.cslong.app.lifetools.rooter.simple.impl;

import com.cslong.app.lifetools.rooter.simple.LifeToolsRoadMap;

/**
 * Created by chenlongjian on 2018/6/25.
 * 一个简配版路由
 */

public class AppRooterSimple {

    private static AppRooterSimple INSTANCE;

    private LifeToolsRoadMap mLifeToolsRoadMap;


    public static AppRooterSimple get() {
        if (INSTANCE == null) {
            INSTANCE = new AppRooterSimple();
        }
        return INSTANCE;
    }

    private AppRooterSimple() {
        mLifeToolsRoadMap = new LifeToolsRoadMapImpl();
    }

    public LifeToolsRoadMap getmLifeToolsRoadMap() {
        return mLifeToolsRoadMap;
    }
}
