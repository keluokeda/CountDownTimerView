package com.ke.countdowntimer;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;


public class CountDownTimerView extends android.support.v7.widget.AppCompatTextView {
    private CharSequence defaultText;
    private OnTimeListener mOnTimeListener;

    private CountDownTimer mCountDownTimer;

    public CountDownTimerView(Context context) {
        super(context);
        init();
    }

    public CountDownTimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CountDownTimerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setDefaultText(CharSequence defaultText) {
        this.defaultText = defaultText;
    }

    public void setOnTimeListener(OnTimeListener onTimeListener) {
        mOnTimeListener = onTimeListener;
    }



    public void startCountDown(long millisInFuture,long countDownInterval) {
        if (mCountDownTimer == null) {
            mCountDownTimer = new CountDownTimer(millisInFuture, countDownInterval) {
                @Override
                public void onTick(long millisUntilFinished) {
                    if (mOnTimeListener != null) {
                        setText(mOnTimeListener.getText(millisUntilFinished));
                    }
                }

                @Override
                public void onFinish() {
                    setEnabled(true);
                    setText(defaultText);
                }
            };
        }else if (isEnabled()){
            //已经初始化完成 并且已经完成倒计时
        }else {
            //已经完成初始化 但没有完成倒计时
            return;
        }
        setEnabled(false);
        mCountDownTimer.start();
    }

    public void onDestroy() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }


    private void init() {
        defaultText = getText();
    }

    public interface OnTimeListener {
        CharSequence getText(long time);
    }


}
