// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BaseAPI.java

package com.pa.sdk.core;

import com.lurencun.http.AsyncHttpConnection;
import com.lurencun.http.ParamsWrapper;
import com.pa.sdk.APIConstants;
import com.pa.sdk.entity.SessionEntity;

// Referenced classes of package com.pa.sdk.core:
//			JSONResponseHandler

public abstract class BaseAPI
{

	protected String makeURL(String module, String action)
	{
		//String url = (new StringBuilder()).append("http://192.168.191.1/arche/api.php").append(module).append(action).toString();
		String url = APIConstants.API_URL + module + action;

        return url;
	}

	protected void httpGet(String url, ParamsWrapper params, JSONResponseHandler listener)
	{
		sendRequest(url, params, "GET", listener);
	}

	protected void httpPost(String url, ParamsWrapper params, JSONResponseHandler listener)
	{
		sendRequest(url, params, "POST", listener);
	}

	private void sendRequest(String url, ParamsWrapper params, String method, JSONResponseHandler listener)
	{
		if (params == null)
			params = new ParamsWrapper();
		String sessionId = SessionEntity.getInstance().getSessionId();
		if (sessionId != null)
			params.put("PHPSESSID", sessionId);
		if ("GET".equals(method))
			AsyncHttpConnection.getInstance().get(url, params, listener);
		else
		if ("POST".equals(method))
			AsyncHttpConnection.getInstance().post(url, params, listener);
	}
}
