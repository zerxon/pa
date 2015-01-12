package com.pa.account.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.pa.R;
import com.pa.account.ChangePasswordActivity;
import com.pa.account.ChangeProfileActivity;
import com.pa.core.BaseController;
import com.pa.core.response.APIResponseHandler;
import com.pa.core.response.IAPIResponseListener;
import com.pa.main.MainActivity;
import com.pa.sdk.api.UserAPI;
import com.pa.sdk.core.BaseAPIParser;
import com.pa.sdk.entity.SessionEntity;
import com.pa.util.APPConstants;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/12/21
 * @desc   :
 */
public class MyAccountController extends BaseController {

    private TextView changeProfile;
    private TextView changePassword;
    private TextView signOut;

    private ProgressDialog progressDialog;

    private UserAPI userAPI = new UserAPI();

    private IAPIResponseListener listener = new IAPIResponseListener() {
        @Override
        public void onStart() {
            progressDialog = ProgressDialog.show(context, null, APPConstants.LOADING);
        }

        @Override
        public void onResponse(JSONObject jsonObject) {
            BaseAPIParser parser = new BaseAPIParser(jsonObject);

            if (parser.success) {
                SessionEntity.getInstance().destory();
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.onNavigationDrawerItemSelected("首页");
                Toast.makeText(context, "退出成功", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, parser.message, Toast.LENGTH_SHORT).show();
            }

            progressDialog.dismiss();
        }

        @Override
        public void onError(Throwable throwable) {

            throwable.printStackTrace();
            Toast.makeText(context, "退出失败", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }
    };

    public MyAccountController(Activity context) {
        super(context);
    }

    @Override
    public void initView() {
        changeProfile = (TextView) this.layout.findViewById(R.id.account_change_profile);
        changePassword = (TextView) this.layout.findViewById(R.id.account_change_password);
        signOut = (TextView) this.layout.findViewById(R.id.account_sign_out);
    }

    @Override
    public void bindAction() {
        changeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, ChangeProfileActivity.class);
                context.startActivity(intent);
            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, ChangePasswordActivity.class);
                context.startActivity(intent);
            }
        });

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAPI.doSignOut(new APIResponseHandler(listener));
            }
        });
    }
}
