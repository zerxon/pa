package com.pa.account;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.pa.R;
import com.pa.account.controller.ChangePasswordController;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/12/23
 * @desc   :
 */
public class ChangePasswordActivity extends Activity {

    private ChangePasswordController changePasswordController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        changePasswordController = new ChangePasswordController(this);
        changePasswordController.initView();
        changePasswordController.bindAction();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }
}
