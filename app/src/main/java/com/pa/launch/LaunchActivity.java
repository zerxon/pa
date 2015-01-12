package com.pa.launch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.pa.R;
import com.pa.main.MainActivity;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014-10-6
 * @desc   :
 */
public class LaunchActivity extends Activity {

    private Handler startHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        this.init();
    }

    private void init() {
        startHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                start();
            }
        };

        startHandler.sendEmptyMessageDelayed(0, 1000);
    }

    private void start() {
        Intent intent = new Intent();
        intent.setClass(LaunchActivity.this, MainActivity.class);
        this.startActivity(intent);
        this.finish();
    }
}
