package com.cslong.app.volleynet;


import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlongjian on 2018/6/23.
 */

public class APIRestClient {

    private static APIRestClient instance;

    private RequestQueue queue;

    private APIRestClient(Context context) {
        queue = Volley.newRequestQueue(context);

    }


    public static APIRestClient getInstance(Context context) {
        synchronized (APIRestClient.class) {
            if (null == instance) {
                instance = new APIRestClient(context);
            }
        }
        return instance;
    }


    public void VolleyStringGet(String url, int type, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        StringRequest request = new StringRequest(url, listener, errorListener);
        queue.add(request);
    }

    public void VolleyStringPost(String url, int type, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        StringRequest request = new StringRequest(Request.Method.POST, url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
    }

    public void VolleyGet(String url, Type type, Response.Listener<BaseRespone> listener,
                          Response.ErrorListener errorListener)
    {
        VolleyRequest request = new VolleyRequest(url,type,listener,errorListener);

    }



}
