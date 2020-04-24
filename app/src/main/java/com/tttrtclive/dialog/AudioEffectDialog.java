package com.tttrtclive.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tttrtclive.R;
import com.wushuangtech.library.Constants;
import com.wushuangtech.wstechapi.TTTRtcEngine;

import androidx.annotation.NonNull;

public class AudioEffectDialog extends Dialog implements RadioGroup.OnCheckedChangeListener {

    private TTTRtcEngine mRtcEngine;

    public AudioEffectDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_audio_effect);
        mRtcEngine = TTTRtcEngine.getInstance();
        initView();
    }

    private void initView() {
        RadioGroup audioEffectRG = findViewById(R.id.audio_effect_rg);
        audioEffectRG.setOnCheckedChangeListener(this);
        RadioButton closeBT = findViewById(R.id.audio_effect_close);
        closeBT.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int id = group.getCheckedRadioButtonId();
        switch (id) {
            case R.id.audio_effect_close:
                mRtcEngine.enableAudioEffect(false, 0);
                break;
            case R.id.audio_effect_delay:
                mRtcEngine.enableAudioEffect(true, Constants.WSAUDIO_EFFECT_DELAY);
                break;
            case R.id.audio_effect_pitchshift_low:
                mRtcEngine.enableAudioEffect(true, Constants.WSAUDIO_EFFECT_PITCHSHIFT_LOW);
                break;
            case R.id.audio_effect_pitchshift_hi:
                mRtcEngine.enableAudioEffect(true, Constants.WSAUDIO_EFFECT_PITCHSHIFT_HI);
                break;
            case R.id.audio_effect_robot:
                mRtcEngine.enableAudioEffect(true, Constants.WSAUDIO_EFFECT_ROBOT);
                break;
            case R.id.audio_effect_whisper:
                mRtcEngine.enableAudioEffect(true, Constants.WSAUDIO_EFFECT_WHISPER);
                break;
        }
    }
}
