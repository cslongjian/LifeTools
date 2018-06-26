package com.cslong.app.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

/**
 * 各种杂七杂八的工具方法
 * Created by TanLingHui on 2016/5/25.
 */
public class MiscUtils {

    private static long lastClickTime;
    public static boolean isFasteClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if ( 0 < timeD && timeD < 800) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public static boolean isApkInstalled(Context context, String pkgName) {
        try {
            context.getPackageManager().getPackageInfo(pkgName, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void contactUs(final Context context) {
        PackageManager pm = context.getPackageManager();
        if (pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "4001181166"));
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "该设备不支持拨打电话。", Toast.LENGTH_SHORT).show();
        }
    }

     public static String getProcessName() {

        try {
            java.io.File file = new java.io.File("/proc/" + android.os.Process.myPid() + "/" + "cmdline");
            java.io.BufferedReader mBufferedReader = new java.io.BufferedReader(new java.io.FileReader(file));
            String processName = mBufferedReader.readLine().trim();
            mBufferedReader.close();
            return processName;
          } catch (Exception e) {
            e.printStackTrace();


          }
          return "";
    }

    public static boolean isMonkeyRunning() {
        return ActivityManager.isUserAMonkey();
    }
}
