package com.pa.account.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.pa.R;
import com.pa.core.BaseController;
import com.pa.core.response.APIResponseHandler;
import com.pa.core.response.IAPIResponseListener;
import com.pa.sdk.api.UserAPI;
import com.pa.sdk.entity.UserEntity;
import com.pa.sdk.core.BaseAPIParser;
import com.pa.sdk.parser.CheckParser;
import com.pa.util.APPConstants;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/12/19
 * @desc   :
 */
public class SignUpController extends BaseController {

    private ProgressDialog progressDialog;

    private EditText textTel;
    private EditText textName;
    private EditText textPassword;
    private EditText textRePassword;
    private Button btnSubmit;

    private UserAPI api = new UserAPI();
    private UserEntity user = new UserEntity();

    private IAPIResponseListener listener = new IAPIResponseListener() {

        @Override
        public void onStart() {
            progressDialog = ProgressDialog.show(context, null, APPConstants.LOADING);
        }

        @Override
        public void onResponse(JSONObject jsonObject) {
            BaseAPIParser parser = new BaseAPIParser(jsonObject);

            if (parser.success) {
                Toast.makeText(context, "注册成功，请重新登录", Toast.LENGTH_SHORT).show();
                context.finish();
            }
            else {
                Toast.makeText(context, parser.message, Toast.LENGTH_SHORT).show();
            }

            progressDialog.dismiss();
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
            Toast.makeText(context, "注册失败，系统错误", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }
    };

    private IAPIResponseListener checkListener = new IAPIResponseListener() {

        @Override
        public void onStart() {
            progressDialog = ProgressDialog.show(context, null, APPConstants.LOADING);
        }

        @Override
        public void onResponse(JSONObject jsonObject) {
            CheckParser parser = new CheckParser(jsonObject);

            if (parser.success) {
                if (parser.exist.isExist()) {
                    Toast.makeText(context, "该手机号码已被注册", Toast.LENGTH_SHORT).show();
                }
                else {
                    api.doSignUp(user, new APIResponseHandler(listener));
                }
            }
            else {
                Toast.makeText(context, parser.message, Toast.LENGTH_SHORT).show();
            }

            progressDialog.dismiss();
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
            Toast.makeText(context, "注册失败，系统错误", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }
    };

    public SignUpController(Activity context) {
        super(context);
    }

    @Override
    public void initView() {
        btnSubmit = (Button) context.findViewById(R.id.signup_submit);
        textName = (EditText) context.findViewById(R.id.signup_name);
        textTel = (EditText) context.findViewById(R.id.signup_tel);
        textPassword = (EditText) context.findViewById(R.id.signup_password);
        textRePassword = (EditText) context.findViewById(R.id.signup_repassword);
    }

    @Override
    public void bindAction() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = textTel.getText().toString().trim();
                String name = textName.getText().toString().trim();
                String password = textPassword.getText().toString().trim();
                String rePassword = textRePassword.getText().toString().trim();

                if (tel.length() == 0 || password.length() == 0) {
                    Toast.makeText(context, "请填写完整的注册信息", Toast.LENGTH_SHORT).show();
                }
                else if (name.length() < 2 || name.length() > 10) {
                    Toast.makeText(context, "昵称长度为2～10个字符", Toast.LENGTH_SHORT).show();
                }
                else if (password.length() < 6 || password.length() > 16) {
                    Toast.makeText(context, "密码长度为6~16个字符", Toast.LENGTH_SHORT).show();
                }
                else if (!password.equals(rePassword)) {
                    Toast.makeText(context, "两次密码不一致", Toast.LENGTH_SHORT).show();
                }
                else {
                    user.setTel(tel);
                    user.setName(name);
                    user.setPassword(password);
                    api.checkTelExist(tel, new APIResponseHandler(checkListener));
                }
            }
        });
    }
}
