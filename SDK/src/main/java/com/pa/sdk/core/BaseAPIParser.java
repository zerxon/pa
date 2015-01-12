// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BaseAPIParser.java

package com.pa.sdk.core;

import com.alibaba.fastjson.JSONObject;

public class BaseAPIParser
{

	public static final String FIELD_STATUS = "success";
	public static final String FIELD_MESSAGE = "message";
	public static final String FIELD_ERROR_TYPE = "errorType";
	public static final String FIELD_DATA = "data";
	public static final String FIELD_RECORDS = "records";
	public boolean success;
	public String message;
	public String errorType;
	public JSONObject data;

	public BaseAPIParser(JSONObject data)
	{
		success = data.getBooleanValue("success");
		this.data = data.getJSONObject("data");
		if (success)
		{
			message = null;
		} else
		{
			errorType = data.getString("errorType");
			message = data.getString("message");
		}
	}
}
