package com.baseo.hzl.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.baseo.hzl.net.httpclient.HzlHttpClientRx;
import com.baseo.hzl.utils.OsUtils;

public class RxApiService {

    private static RxApiService _instance;
    private final HzlHttpClientRx httpClientRx;

    public static RxApiService createInstance(final Context context, final boolean isDebug) {
        if (_instance == null) {
            _instance = new RxApiService(context.getApplicationContext(), isDebug);
        }
        return _instance;
    }


    public static RxApiService getInstance() {
        if (_instance == null) {
            throw new IllegalStateException("RestApiService is not init!");
        }
        return _instance;
    }

    private static final String SYSTEM = "android";
    private static String sVersionName = ""; // eg:4.1.0
    private static String sImei; // 设备号
    private static final char SPLIT = '_';

    private RxApiService(final Context context, final boolean isDebug) {
        httpClientRx = new HzlHttpClientRx(context,isDebug);

        final PackageManager packManager = context.getPackageManager();
        try {

            PackageInfo pi = packManager.getPackageInfo(context.getPackageName(), 0);
            sVersionName = pi.versionName;

        } catch (Exception e) {
            sVersionName = "";
        }
        sImei = OsUtils.getUniqueId(context);

    }
}
