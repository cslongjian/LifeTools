package com.cslong.app.lifetools.rooter.simple.impl;

import com.cslong.app.lifetools.lifetools_business.LifeToolsActivity;
import com.cslong.app.lifetools.rooter.simple.LifeToolsRoadMap;
import com.cslong.app.lifetools.rooter.simple.RouterSimple;

/**
 * Created by chenlongjian on 2018/6/25.
 */

public class LifeToolsRoadMapImpl extends BaseRouterSimple implements LifeToolsRoadMap {

    @Override
    public RouterSimple LifeToolsHere() {
        setClass(LifeToolsActivity.class);
        return this;
    }
}
