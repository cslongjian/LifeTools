package com.cslong.app.lifetools.annotationDemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cslong.app.lifetools.R;

import java.security.spec.ECField;

/**
 * Created by chenlongjian on 2018/6/25.
 */

public class AnnotationDemoActivity extends Activity {

    private static String TAG = "AnnotationDemoActivity";

    @TestAnnotation("test to use annotation")
    String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_annotationdemo);

        try {
            ParseAnnotation.parseAnnotation(this);
            Log.i(TAG, name);
        } catch (Exception e) {

        }


    }
}
