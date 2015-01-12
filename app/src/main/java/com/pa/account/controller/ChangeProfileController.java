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
import com.pa.sdk.entity.SessionEntity;
import com.pa.sdk.entity.UserEntity;
import com.pa.sdk.parser.UserParser;
import com.pa.util.APPConstants;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/12/24
 * @desc   :
 */
public class ChangeProfileController extends BaseController {

    private EditText textTel;
    private EditText textName;
    private EditText textFullName;
    private EditText textOtherTel;
    private Button btnSave;

    private ProgressDialog progressDialog;

    private UserAPI userAPI = new UserAPI();

    private IAPIResponseListener profileListener = new IAPIResponseListener() {
        @Override
        public void onStart() {
            progressDialog = ProgressDialog.show(context, null, APPConstants.LOADING);
        }

        @Override
        public void onResponse(JSONObject jsonObject) {

            UserParser parser = new UserParser(jsonObject);

            if (parser.success) {
                UserEntity user = parser.user;

                if (user != null) {
                    textTel.setText(user.getTel());
                    textName.setText(user.getName());
                    textFullName.setText(user.getFullName());
                    textOtherTel.setText(user.getOtherTel());
                }
            }

            progressDialog.dismiss();
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
            progressDialog.dismiss();
        }
    };

    private IAPIResponseListener changeProfileListener = new IAPIResponseListener() {
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
            progressDialog.dismiss();
        }
    };

    public ChangeProfileController(Activity context) {
        super(context);
    }

    @Override
    public void initView() {
        textTel = (EditText) context.findViewById(R.id.profile_tel);
        textName = (EditText) context.findViewById(R.id.profile_name);
        textFullName = (EditText) context.findViewById(R.id.profile_full_name);
        textOtherTel = (EditText) context.findViewById(R.id.profile_other_tel);

        btnSave = (Button) context.findViewById(R.id.profile_save);
    }

    @Override
    public void bindAction() {

        final long userId = SessionEntity.getInstance().getUser().getId();
        userAPI.profile(userId, new APIResponseHandler(profileListener));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textName.getText().toString();
                String fullName = textFullName.getText().toString();
                String otherTel = textOtherTel.getText().toString();

                UserEntity user = new UserEntity();
                user.setName(name);
                user.setFullName(fullName);
                user.setOtherTel(otherTel);

                userAPI.doChangeProfile(user, new APIResponseHandler(changeProfileListener));
            }
        });
    }

}
