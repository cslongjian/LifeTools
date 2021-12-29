package com.baseo.hzl.net.httpclient;


import com.google.gson.Gson;

import okhttp3.Interceptor;
import okhttp3.Response;

public class HzlOkHttpInterceptor implements Interceptor {

    private final Gson gson = new Gson();

    @Override
    public Response intercept(Chain chain) {
        return null;
    }
}
