package com.pa.core.response;

import com.alibaba.fastjson.JSONObject;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/11/29
 * @desc   :
 */
public interface IAPIResponseListener {
    public void onStart();
    public void onResponse(JSONObject jsonObject);
    public void onError(Throwable throwable);
}