// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OrderAPI.java

package com.pa.sdk.api;

import com.lurencun.http.ParamsWrapper;
import com.pa.sdk.core.BaseAPI;
import com.pa.sdk.core.JSONResponseHandler;

public class OrderAPI extends BaseAPI
{

	private static final String MODULE = "/order";

	public void batchOrders(JSONResponseHandler handler)
	{
		String url = makeURL(MODULE, "/myOrder");
		httpGet(url, null, handler);
	}

	public void cancelOrder(long orderId, JSONResponseHandler handler)
	{
		String url = makeURL(MODULE, "/cancelOrder");
		ParamsWrapper params = new ParamsWrapper();
		params.put("orderId", orderId);
		httpGet(url, params, handler);
	}

	public void ignoreOrder(long orderId, JSONResponseHandler handler)
	{
		String url = makeURL("/order", "/ignoreOrder");
		ParamsWrapper params = new ParamsWrapper();
		params.put("orderId", orderId);
		httpGet(url, params, handler);
	}
}
