package com.cslong.app.lifetools.rooter.simple.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.cslong.app.lifetools.rooter.simple.RouterSimple;

/**
 * Created by chenlongjian on 2018/6/25.
 */

public class BaseRouterSimple implements RouterSimple {
    private int mFlags = -1;
    private Bundle mBundle;
    private String mClassName;

    public BaseRouterSimple() {
    }

    @Override
    public RouterSimple flags(int flags) {
        mFlags = flags;
        return this;
    }

    @Override
    public RouterSimple with(Bundle bundle) {
        if (bundle == null)
            return this;
        mBundle = bundle;
        return this;
    }

    @Override
    public boolean start(Context context) {
        Intent intent = buildIntent(context);
        if (!(context instanceof Activity)) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
        return true;
    }

    @Override
    public boolean start(Activity activity, int requestCode) {
        Intent intent = buildIntent(activity);
        activity.startActivityForResult(intent, requestCode);
        return true;
    }

    private Intent buildIntent(Context context) {
        if (TextUtils.isEmpty(mClassName)) {
            throw new IllegalArgumentException();
        }
        Intent intent = new Intent();
        if (mFlags != -1) {
            intent.setFlags(mFlags);
        }
        if (mBundle != null) {
            intent.putExtras(mBundle);
        }
        intent.setClassName(context, mClassName);
        return intent;
    }

    protected void setClass(@NonNull Class cls) {
        mClassName = cls.getName();
    }

    protected void setClassName(@NonNull String className) {
        mClassName = className;
    }
}
