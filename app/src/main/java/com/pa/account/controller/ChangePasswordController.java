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
import com.pa.sdk.core.BaseAPIParser;
import com.pa.util.APPConstants;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/12/23
 * @desc   :
 */
public class ChangePasswordController extends BaseController {

    private EditText textOldPwd;
    private EditText textNewPwd;
    private EditText textRePwd;
    private Button btnSave;

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
                Toast.makeText(context, "修改成功", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, parser.message, Toast.LENGTH_SHORT).show();
            }

            progressDialog.dismiss();
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
            Toast.makeText(context, "修改失败", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }
    };

    public ChangePasswordController(Activity context) {
        super(context);
    }

    @Override
    public void initView() {
        textOldPwd = (EditText) context.findViewById(R.id.old_password);
        textNewPwd = (EditText) context.findViewById(R.id.new_password);
        textRePwd = (EditText) context.findViewById(R.id.re_password);
        btnSave = (Button) context.findViewById(R.id.pwd_save);
    }

    @Override
    public void bindAction() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPwd = textOldPwd.getText().toString();
                String newPwd = textNewPwd.getText().toString();
                String rePwd = textRePwd.getText().toString();

                if (oldPwd.trim().length() == 0) {
                    Toast.makeText(context, "旧密码不能为空", Toast.LENGTH_SHORT).show();
                }
                else if(newPwd.length() < 6 || newPwd.length() > 16) {
                    Toast.makeText(context, "新密码长度为6～16个字符", Toast.LENGTH_SHORT).show();
                }
                else if(!newPwd.equals(rePwd)) {
                    Toast.makeText(context, "两次密码不一致", Toast.LENGTH_SHORT).show();
                }
                else {
                    userAPI.doChangePassword(oldPwd, newPwd, new APIResponseHandler(listener));
                }
            }
        });
    }
}
