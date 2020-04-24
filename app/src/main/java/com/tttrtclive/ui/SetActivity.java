package com.tttrtclive.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.tttrtclive.R;

public class SetActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /*-------------------------------配置参数---------------------------------*/
    public boolean mUseHQAudio = false;
    /*-------------------------------配置参数---------------------------------*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        Intent intent = getIntent();
        mUseHQAudio = intent.getBooleanExtra("HQA", mUseHQAudio);

        findViewById(R.id.local_ok_button).setOnClickListener(this);
        ((Switch) findViewById(R.id.local_audio_switch)).setOnCheckedChangeListener(this);

        ((Switch) findViewById(R.id.local_audio_switch)).setChecked(mUseHQAudio);
    }

    public void onExitButtonClick(View v) {
        exit();
    }

    @Override
    public void onClick(View v) {
        exit();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mUseHQAudio = isChecked;
    }

    private void exit() {
        Intent intent = new Intent();
        intent.putExtra("HQA", mUseHQAudio);
        setResult(SplashActivity.ACTIVITY_SETTING, intent);
        finish();
    }
}
