package com.baseo.hzl.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class TinyDB {
    Context mContext;
    SharedPreferences preferences;

    public TinyDB(Context appContext) {
        mContext = appContext;
        preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public TinyDB(Context appContext, String tinydbname) {
        mContext = appContext;
        setPreferences(tinydbname);
    }

    @SuppressLint("InlinedApi")
    public void setPreferences(String tinydbname) {
        if (Build.VERSION.SDK_INT < 11) {
            preferences = mContext.getSharedPreferences(tinydbname,
                    Context.MODE_PRIVATE);
        } else {
            preferences = mContext.getSharedPreferences(tinydbname,
                    Context.MODE_PRIVATE);
        }
    }


    public boolean contains(String key) {
        return preferences.contains(key);
    }

    public int getInt(String key) {
        return preferences.getInt(key, 0);
    }

    public int getInt(String key, int def) {
        return preferences.getInt(key, def);
    }

    public long getLong(String key) {
        return preferences.getLong(key, 0l);
    }

    public long getLongDefaultMaxValue(String key) {
        return preferences.getLong(key, Long.MAX_VALUE);
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public double getDouble(String key) {
        String number = getString(key);
        try {
            double value = Double.parseDouble(number);
            return value;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void putLong(String key, long value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public void putDouble(String key, double value) {
        putString(key, String.valueOf(value));
    }

    public void putString(String key, String value) {

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void putList(String key, ArrayList<String> marray) {

        SharedPreferences.Editor editor = preferences.edit();
        String[] mystringlist = marray.toArray(new String[marray.size()]);
        // the comma like character used below is not a comma it is the SINGLE
        // LOW-9 QUOTATION MARK unicode 201A and unicode 2017 they are used for
        // seprating the items in the list
        editor.putString(key, TextUtils.join("‚‗‚", mystringlist));
        editor.apply();
    }

    public ArrayList<String> getList(String key) {
        // the comma like character used below is not a comma it is the SINGLE
        // LOW-9 QUOTATION MARK unicode 201A and unicode 2017 they are used for
        // seprating the items in the list
        String[] mylist = TextUtils
                .split(preferences.getString(key, ""), "‚‗‚");
        ArrayList<String> gottenlist = new ArrayList<String>(
                Arrays.asList(mylist));
        return gottenlist;
    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public boolean getBooleanDefaultTrue(String key) {
        return preferences.getBoolean(key, true);
    }

    public void putFloat(String key, float value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public float getFloat(String key) {
        return preferences.getFloat(key, 0f);
    }

    public void remove(String key) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.apply();
    }


    public void clear() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

    public Map<String, ?> getAll() {
        return preferences.getAll();
    }


}
