package com.pa.core;

import android.app.Activity;
import android.view.View;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/11/29
 * @desc   :
 */
public abstract class BaseController {
    protected Activity context;
    protected View layout;

    public BaseController(Activity activity) {
        this.context =  activity;
    }

    public void setLayout(View layout) {
        this.layout = layout;
        this.initView();
    }

    public abstract void initView();
    public abstract void bindAction();
}