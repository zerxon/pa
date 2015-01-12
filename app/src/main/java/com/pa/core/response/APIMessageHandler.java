package com.pa.core.response;

import android.os.Handler;
import android.os.Message;

import com.alibaba.fastjson.JSONObject;

/**
 * @author : wallace leung
 * @email : wallaceleung@163.com
 * @date : 2014/11/29 0029
 * @desc :
 */
public class APIMessageHandler extends Handler {

    private IAPIResponseListener listener;

    public APIMessageHandler(IAPIResponseListener listener) {
        this.listener = listener;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case APIMessageType.START:
                listener.onStart();
                break;

            case APIMessageType.ERROR:
                Throwable throwable = (Throwable) msg.obj;
                listener.onError(throwable);
                break;

            case  APIMessageType.SUCCESS:
                JSONObject jsonObject = (JSONObject) msg.obj;
                listener.onResponse(jsonObject);
                break;

            default:
                System.err.println("Unknow message type: "+msg.toString());
        }
    }
}
