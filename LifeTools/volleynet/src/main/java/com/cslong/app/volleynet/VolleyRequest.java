package com.cslong.app.volleynet;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by chenlongjian on 2018/6/23.
 */

public class VolleyRequest extends Request<BaseRespone> {

    private static final String TAG = "VolleyRequest";
    //超时时间，默认10秒
    private int defaultHttpTimeOut = 10 * 1000;
    //回调监听
    private Response.Listener<BaseRespone> listener;
    //返回类型
    private Type type;
    //请求参数
    private Map<String, String> methodBody;

    /**
     * get请求
     *
     * @param url
     * @param type
     * @param listener
     * @param errorListener
     */
    public VolleyRequest(String url, Type type, Response.Listener<BaseRespone> listener,
                         Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        // 不启用缓存(默认是true)
        setShouldCache(false);
        this.type = type;
        this.listener = listener;
        // 设置重连策略
        this.setRetryPolicy(new DefaultRetryPolicy(defaultHttpTimeOut,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }


    /**
     * post请求
     *
     * @param methodName
     * @param methodBoby
     * @param type
     * @param listener
     * @param errorListener
     */
    public VolleyRequest(String url, Map<String, String> methodBoby, Type type,
                         Response.Listener<BaseRespone> listener, Response.ErrorListener errorListener) {
        super(Method.POST, url, errorListener);
        this.methodBody = methodBoby;
        this.listener = listener;
        this.type = type;
        // 不启用缓存
        setShouldCache(false);
        // 设置重连策略
        this.setRetryPolicy(new DefaultRetryPolicy(defaultHttpTimeOut,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    /**
     * 设置请求参数
     */
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        if (methodBody == null) {
            return super.getParams();
        }
        //创建一个集合，保存请求参数
        Map<String, String> map = new LinkedHashMap<>();
        //----此处可以添加多个通用参数
        //map.put(key,value);
        //------
        //------
        //遍历集合
        Iterator<Map.Entry<String, String>> iter = methodBody.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    /**
     * 将服务器返回的原生字节内容进行转换
     */
    @Override
    protected Response<BaseRespone> parseNetworkResponse(NetworkResponse response) {
        try {
            // 获取返回的数据(在 Content-Type首部中获取编码集，如果没有找到，默认返回 ISO-8859-1)
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(parseNetworkResponseDelegate(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            return Response.error(new ParseError(e));
        }
    }

    /**
     * 将服务器返回的内容用gson进行封装
     */
    private BaseRespone parseNetworkResponseDelegate(String jsonString) {
        return new Gson().fromJson(jsonString, type);
    }

    /**
     * 将解析后的数据进行回调
     */
    @Override
    protected void deliverResponse(BaseRespone arg0) {
        listener.onResponse(arg0);
    }
}
