// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HotelAPI.java

package com.pa.sdk.api;

import com.lurencun.http.ParamsWrapper;
import com.pa.sdk.core.BaseAPI;
import com.pa.sdk.core.JSONResponseHandler;

public class HotelAPI extends BaseAPI
{

	private static final String MODULE = "/hotel";

	public void batchHotels(int pageIndex, int pageSize, JSONResponseHandler handler)
	{
		String url = makeURL(MODULE, "/all");
		pageIndex = pageIndex <= 0 ? 1 : pageIndex;
		pageSize = pageSize <= 0 ? 30 : pageSize;
		ParamsWrapper params = new ParamsWrapper();
		params.put("pageIndex", pageIndex);
		params.put("pageSize", pageSize);
		httpGet(url, params, handler);
	}

	public void queryHotelDetail(long hotelId, JSONResponseHandler handler)
	{
		String url = makeURL(MODULE, "/detail");
		ParamsWrapper params = new ParamsWrapper();
		params.put("id", hotelId);
		httpGet(url, params, handler);
	}
}
