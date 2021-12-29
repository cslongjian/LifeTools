package com.baseo.hzl.net.httpclient;

import android.content.Context;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class HzlHttpClientRx {

    private static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024; //10MB

    private final Retrofit retrofit;
    private final OkHttpClient okHttpClient;

    /**
     * @param connTimeout  设置连接超时，以毫秒为单位
     * @param readTimeout  设置读超时，以毫秒为单位
     * @param writeTimeout 设置写超时，以毫秒为单位
     */
    public HzlHttpClientRx(final Context context,
                           final long connTimeout,
                           final long readTimeout,
                           final long writeTimeout,
                           final boolean isDebug) {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        if (isDebug) {
            //DEBUG 可添加处理
        }

        //核心步骤。添加处理逻辑
        httpClientBuilder.addInterceptor(null);


        if (connTimeout > 0) {
            httpClientBuilder.connectTimeout(connTimeout, TimeUnit.MILLISECONDS);
        }
        if (readTimeout > 0) {
            httpClientBuilder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        }
        if (writeTimeout > 0) {
            httpClientBuilder.writeTimeout(writeTimeout, TimeUnit.MILLISECONDS);
        }

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

        okHttpClient = httpClientBuilder.build();
        retrofit = retrofitBuilder.client(okHttpClient).build();

    }


    public HzlHttpClientRx(final Context context, final boolean isDebug) {
        this(context, 15 * 1000, 15 * 1000, 15 * 1000, isDebug);
    }


    /**
     * 创建一个API实例
     *
     * @param apiClass
     * @param <S>
     * @return
     */
    public <S> S createApi(Class<S> apiClass) {
        return retrofit.create(apiClass);
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }


}
