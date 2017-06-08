package com.ke.countdowntimerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ke.countdowntimer.CountDownTimerView;

public class MainActivity extends AppCompatActivity {

    private CountDownTimerView countDownTimerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countDownTimerView = (CountDownTimerView) findViewById(R.id.count_down_view);
        countDownTimerView.setOnTimeListener(new CountDownTimerView.OnTimeListener() {
            @Override
            public CharSequence getText(long time) {
                long downTime = time / 1000;
                return String.valueOf(downTime);
            }
        });
        countDownTimerView.startCountDown(20 * 1000,1000);
    }

    public void doClick(View view) {
        countDownTimerView.startCountDown(20 * 1000,1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimerView.onDestroy();
    }
}
