package com.cslong.app.lifetools.designpatterndemo;

import android.os.Bundle;
import android.widget.TextView;

import com.cslong.app.lifetools.BaseActivity;
import com.cslong.app.lifetools.R;

public class SingleInstanceActivity extends BaseActivity {

    private TextView mFirstTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_singleinstance);

        mFirstTxt = (TextView) findViewById(R.id.contain);

        mFirstTxt.setText(":查看历史来看");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}
