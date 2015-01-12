// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   JSONResponseHandler.java

package com.pa.sdk.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lurencun.http.ParamsWrapper;
import com.lurencun.http.StringResponseHandler;
import java.io.PrintStream;
import java.net.URL;

public abstract class JSONResponseHandler extends StringResponseHandler
{

	public JSONResponseHandler()
	{
	}

	public void onSubmit(URL url, ParamsWrapper params)
	{
		int hostPort = url.getPort();
		String port = hostPort <= 0 ? "" : String.format(":%d", new Object[] {
			Integer.valueOf(hostPort)
		});
		System.out.println((new StringBuilder()).append("[API]: ").append(url.getProtocol()).append("://").append(url.getHost()).append(port).append(url.getPath()).append("?").append(params.toString()).toString());
	}

	public final void onResponse(String content, URL url)
	{
		try
		{
			JSONObject json = JSON.parseObject(content);
			onResponse(json, url);
		}
		catch (Throwable exp)
		{
			System.err.println((new StringBuilder()).append("Invalid JSON content:").append(content).toString());
			exp.printStackTrace();
			onError(new Throwable("Invalid JSON content"));
		}
	}

	public abstract void onResponse(JSONObject jsonobject, URL url);
}
