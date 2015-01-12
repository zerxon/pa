package com.pa.account;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.pa.R;
import com.pa.account.controller.ChangeProfileController;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/12/24
 * @desc   :
 */
public class ChangeProfileActivity extends Activity {

    private ChangeProfileController changeProfileController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);

        changeProfileController = new ChangeProfileController(this);
        changeProfileController.initView();
        changeProfileController.bindAction();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }
}
