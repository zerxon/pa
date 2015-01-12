// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserParser.java

package com.pa.sdk.parser;

import com.alibaba.fastjson.JSONObject;
import com.pa.sdk.core.BaseAPIParser;
import com.pa.sdk.entity.UserEntity;

public class UserParser extends BaseAPIParser
{

	public UserEntity user;

	public UserParser(JSONObject data)
	{
		super(data);
		if (success)
			user = parse(this.data);
	}

	public static UserEntity parse(JSONObject data)
	{
		UserEntity user = new UserEntity();
		user.setId(data.getLongValue("id"));
		user.setTel(data.getString("tel"));
		user.setPassword(data.getString("password"));
		user.setName(data.getString("name"));
		user.setFullName(data.getString("fullName"));
		user.setAvatar(data.getString("avatar"));
		user.setOtherTel(data.getString("otherTel"));
		user.setMerchant(data.getShortValue("isMerchant") > 0);
		user.setAdmin(data.getShortValue("isAdmin") > 0);
		user.setAddTime(data.getLongValue("addTime"));
		return user;
	}
}
