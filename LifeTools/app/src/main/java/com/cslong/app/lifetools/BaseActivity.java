package com.cslong.app.lifetools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.cslong.app.utils.MiscUtils;

/**
 * Created by chenlongjian on 2018/6/26.
 */


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MiscUtils.isMonkeyRunning()) {
            //定义全屏参数
            int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
            //设置当前窗体为全屏显示
            Window window = getWindow();
            window.setFlags(flag, flag);
        }
    }


}
