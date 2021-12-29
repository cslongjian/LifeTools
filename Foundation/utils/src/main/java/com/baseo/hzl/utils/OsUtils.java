package com.baseo.hzl.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;

import java.util.List;
import java.util.UUID;



/**
 * 系统工具类
 *
 * @author Administrator
 * @data: 2015-4-20 下午5:11:25
 * @version: V1.0
 */
public final class OsUtils {

    public static final int OS_BUILD_VERSION = Build.VERSION.SDK_INT;
    public static final String DEVICE_ID_TAG="deviceId";
    public static final String SIM_SERIAL_NUMBER_TAG="simSerialNumber";

    /**
     * 防止Application onCreate重复初始化
     *
     * @return boolean
     */
    public static boolean shouldInit(Context ctx) {
        ActivityManager am = ((ActivityManager) ctx
                .getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = ctx.getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }

    public static String getUniqueId(Context ctx) {
        String tmDevice, tmSerial, androidId;
        tmDevice = "";
        tmSerial = "";
        TinyDB tinyDB=new TinyDB(ctx);
        if(tinyDB.contains(DEVICE_ID_TAG)){
            tmDevice=tinyDB.getString(DEVICE_ID_TAG);
            tmSerial=tinyDB.getString(SIM_SERIAL_NUMBER_TAG);
        }
        androidId = ""
                + Settings.Secure.getString(
                ctx.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        UUID deviceUuid = new UUID(androidId.hashCode(),
                ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String uniqueId = deviceUuid.toString();
        return uniqueId;
    }

    /**
     * 获取当前运行的Activity数量
     */
    public static int getActivityStackCount(Context ctx) {
        int result = 0;
        if (ctx == null) {
            return result;
        }
        final String PKG_NAME = ctx.getPackageName();
        ActivityManager am = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
        if (am == null) {
            return result;
        }
        List<ActivityManager.RunningTaskInfo> taskInfoList = am.getRunningTasks(10);
        if (taskInfoList == null) {
            return result;
        }
        for (ActivityManager.RunningTaskInfo taskInfo : taskInfoList) {
            if ((taskInfo.baseActivity != null && PKG_NAME.equals(taskInfo.baseActivity.getPackageName())) ||
                    (taskInfo.topActivity != null && PKG_NAME.equals(taskInfo.topActivity.getPackageName()))
                    ) {
                result = taskInfo.numActivities;
                break;
            }
        }
        return result;
    }

    /**
     * 获取应用的VersionCode
     *
     * @param context
     * @return
     */
    public static int getAppVersionCode(Context context) {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }


    public static boolean hasFroyo() {
        // Can use static final constants like FROYO, declared in later versions
        // of the OS since they are inlined at compile time. This is guaranteed behavior.
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    }

    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }

    public static boolean hasHoneycomb() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public static boolean hasHoneycombMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
    }


    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    /**
     * 判断应用的消息通知功能是否开启
     *
     * @return
     */
//    public static boolean isNotificationOpen(final Context context) {
//        String CHECK_OP_NO_THROW = "checkOpNoThrow";
//        String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
//        AppOpsManager mAppOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
//        ApplicationInfo appInfo = context.getApplicationInfo();
//        String pkg = context.getApplicationContext().getPackageName();
//        int uid = appInfo.uid;
//        Class appOpsClass; /* Context.APP_OPS_MANAGER */
//        try {
//            appOpsClass = Class.forName(AppOpsManager.class.getName());
//            Method checkOpNoThrowMethod = appOpsClass.getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class);
//            Field opPostNotificationValue = appOpsClass.getDeclaredField(OP_POST_NOTIFICATION);
//            int value = (int) opPostNotificationValue.get(Integer.class);
//            return ((int) checkOpNoThrowMethod.invoke(mAppOps, value, uid, pkg) == AppOpsManager.MODE_ALLOWED);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    /**
     * 开启应用设置页面
     */
    public static void openNotificationActivity(Context context, String packageName) {

        Intent intent = new Intent();
        // above 2.3
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", packageName, null);
        intent.setData(uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

    /**
     * 判断app是否在前台运行
     * @param context   context
     * @return
     */
    public static boolean isAppOnForeground(Context context) {
        // Returns a list of application processes that are running on the
        // device
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = context.getApplicationContext().getPackageName();

        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.startsWith(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }


}

