package com.tttrtclive.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tttrtclive.R;
import com.tttrtclive.bean.EnterUserInfo;

public class RemoteWindow extends RelativeLayout {

    public long mId = -1;
    private boolean mIsMuted;

    private ImageView mSpeakImage;
    private TextView mIdView;
    private TextView mAudioBitrate;

    public RemoteWindow(Context context, AttributeSet attrs) {
        super(context, attrs);
        View v = LayoutInflater.from(context).inflate(R.layout.audio_remote_window, this, true);
        mSpeakImage = v.findViewById(R.id.speakimage);
        mIdView = v.findViewById(R.id.id);
        mAudioBitrate = v.findViewById(R.id.audiorate);
    }

    public void show(EnterUserInfo userInfo) {
        mId = userInfo.getId();
        mIdView.setText("" + mId);
        mSpeakImage.setVisibility(View.VISIBLE);
        mIdView.setVisibility(View.VISIBLE);
        mAudioBitrate.setVisibility(View.VISIBLE);
    }

    public void hide() {
        mId = -1;
        mSpeakImage.setImageResource(R.drawable.mainly_btn_speaker_selector);
        mSpeakImage.setVisibility(View.INVISIBLE);
        mIdView.setVisibility(View.INVISIBLE);
        mAudioBitrate.setVisibility(View.INVISIBLE);
    }

    public void mute(boolean mute) {
        mIsMuted = mute;
        mSpeakImage.setImageResource(mute ? R.drawable.jinyan : R.drawable.mainly_btn_speaker_selector);
    }

    public void updateBitrate(String bitrate) {
        mAudioBitrate.setText(bitrate);
    }

    public void updateSpeakState(int volumeLevel) {
        if (mIsMuted) return;
        if (volumeLevel >= 0 && volumeLevel <= 3) {
            mSpeakImage.setImageResource(R.drawable.mainly_btn_speaker_selector);
        } else if (volumeLevel > 3 && volumeLevel <= 6) {
            mSpeakImage.setImageResource(R.drawable.mainly_btn_speaker_middle_selector);
        } else if (volumeLevel > 6 && volumeLevel <= 9) {
            mSpeakImage.setImageResource(R.drawable.mainly_btn_speaker_big_selector);
        }
    }

}
