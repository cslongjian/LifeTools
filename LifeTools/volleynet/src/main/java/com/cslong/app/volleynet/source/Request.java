package com.cslong.app.volleynet.source;

import android.support.annotation.NonNull;

/**
 * Created by chenlongjian on 2018/6/27.
 */

public abstract class Request<T> implements Comparable<Request<T>> {

//    默认编码格式 UTF-8
    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";


    public interface Method{
        int DEPRECATED_GET_OR_POST = -1;
        int GET = 0;
        int POST = 1;
    }

    @Override
    public int compareTo(@NonNull Request<T> o) {
        return 0;
    }
}
