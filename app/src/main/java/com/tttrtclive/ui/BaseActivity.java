package com.tttrtclive.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import com.gyf.immersionbar.ImmersionBar;
import com.wushuangtech.wstechapi.TTTRtcEngine;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by wangzhiguo on 17/10/12.
 */

public class BaseActivity extends AppCompatActivity {

    protected TTTRtcEngine mTTTEngine;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();// 隐藏标题
        }

        ImmersionBar.with(this).statusBarDarkFont(true).init();
        //获取上下文
        mContext = this;
        //获取SDK实例对象
        mTTTEngine = TTTRtcEngine.getInstance();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

}
