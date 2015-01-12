package com.pa.account.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.pa.R;
import com.pa.account.SignInFragment;
import com.pa.account.SignUpActivity;
import com.pa.core.BaseController;
import com.pa.core.response.APIResponseHandler;
import com.pa.core.response.IAPIResponseListener;
import com.pa.main.MainActivity;
import com.pa.sdk.api.UserAPI;
import com.pa.sdk.entity.UserEntity;
import com.pa.sdk.parser.SessionParser;
import com.pa.util.APPConstants;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/12/17
 * @desc   :
 */
public class SignInController extends BaseController {

    private ProgressDialog progressDialog;

    private EditText textAccount;
    private EditText textPassword;
    private Button btnSubmit;
    private TextView newAccount;

    private UserAPI api = new UserAPI();

    private IAPIResponseListener listener = new IAPIResponseListener() {
        @Override
        public void onStart() {
            progressDialog = ProgressDialog.show(context, null, APPConstants.LOADING);
        }

        @Override
        public void onResponse(JSONObject jsonObject) {
            SessionParser parser = new SessionParser(jsonObject);

            if (parser.success) {
                System.out.println(parser.session.getSessionId());
                Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.onNavigationDrawerItemSelected("首页");
            }
            else {
                Toast.makeText(context, parser.message, Toast.LENGTH_SHORT).show();
            }

            progressDialog.dismiss();
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
            Toast.makeText(context, "登录失败", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }
    };

    public SignInController(Activity context) {
        super(context);
    }

    @Override
    public void initView() {
        textAccount = (EditText) this.layout.findViewById(R.id.signin_account);
        textPassword = (EditText) this.layout.findViewById(R.id.signin_password);
        btnSubmit = (Button) this.layout.findViewById(R.id.signin_submit);
        newAccount = (TextView) this.layout.findViewById(R.id.signin_newaccount);
    }

    @Override
    public void bindAction() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strAccount = textAccount.getText().toString().trim();
                String strPassword = textPassword.getText().toString().trim();

                if (strAccount.length() > 0 && strPassword.length() > 0) {
                    UserEntity user = new UserEntity();
                    user.setTel(strAccount);
                    user.setPassword(strPassword);

                    api.doSignIn(user, new APIResponseHandler(listener));
                }
                else {
                    Toast.makeText(context, "请填写手机号码和密码", Toast.LENGTH_SHORT).show();
                }
            }
        });

        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, SignUpActivity.class);
                context.startActivity(intent);
            }
        });
    }
}
