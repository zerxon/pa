package com.pa.core.response;

import android.os.Message;

import com.alibaba.fastjson.JSONObject;
import com.lurencun.http.ParamsWrapper;
import com.pa.sdk.core.JSONResponseHandler;

import java.net.URL;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/11/29
 * @desc   :
 */
public class APIResponseHandler extends JSONResponseHandler {

    private APIMessageHandler messageHandler;

    public APIResponseHandler(IAPIResponseListener listener) {
        messageHandler = new APIMessageHandler(listener);
    }

    @Override
    public void onSubmit(URL url,ParamsWrapper params) {
        super.onSubmit(url, params);
        Message msg = Message.obtain();
        msg.what = APIMessageType.START;
        messageHandler.sendMessage(msg);
    }

    @Override
    public void onResponse(JSONObject json, URL url) {
        Message msg = Message.obtain();
        msg.what = APIMessageType.SUCCESS;
        msg.obj = json;
        messageHandler.sendMessage(msg);
    }

    @Override
    public void onError(Throwable throwable) {
        Message msg = Message.obtain();
        msg.what = APIMessageType.ERROR;
        msg.obj = throwable;
        messageHandler.sendMessage(msg);
    }
}
