package com.baseo.hzl.net;

public class ApiUtil {


    // 此处必须与environment.gradle的envValues一致
    public static final int ENV_R = 1;//正式环境
    public static final int ENV_T = 2;//测试环境
    public static final int ENV_D = 3;//开发环境

    /**
     * debug 模式判断
     */
    public static boolean isDebug() {
        return BuildConfig.ENV_TYPE != ENV_R;
    }


    /**
     * API环境获取
     */
    public static int getApiEnv() {
        return BuildConfig.ENV_TYPE;
    }

    public static boolean isOwnApi(String host) {
        if (host == null) {
            return false;
        }
        return BASES_API_URL.APIPHP.contains(host);
    }
}
