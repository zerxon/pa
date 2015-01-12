// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CheckParser.java

package com.pa.sdk.parser;

import com.alibaba.fastjson.JSONObject;
import com.pa.sdk.core.BaseAPIParser;
import com.pa.sdk.entity.ExistEntity;

public class CheckParser extends BaseAPIParser
{

	public ExistEntity exist;

	public CheckParser(JSONObject data)
	{
		super(data);
		if (success)
			exist = parse(this.data);
	}

	public static ExistEntity parse(JSONObject data)
	{
		ExistEntity exist = new ExistEntity();
		exist.setExist(!data.getBooleanValue("notExist"));
		return exist;
	}
}
