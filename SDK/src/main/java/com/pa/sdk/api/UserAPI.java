// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserAPI.java

package com.pa.sdk.api;

import com.lurencun.http.ParamsWrapper;
import com.pa.sdk.core.BaseAPI;
import com.pa.sdk.core.JSONResponseHandler;
import com.pa.sdk.entity.UserEntity;

public class UserAPI extends BaseAPI
{

	private static final String MODULE = "/account";

	public void doSignUp(UserEntity user, JSONResponseHandler handler)
	{
		String url = makeURL(MODULE, "/doSignUp");
		ParamsWrapper params = new ParamsWrapper();
		params.put("name", user.getName());
		params.put("tel", user.getTel());
		params.put("password", user.getPassword());
		httpPost(url, params, handler);
	}

	public void doSignIn(UserEntity user, JSONResponseHandler handler)
	{
		String url = makeURL(MODULE, "/doSignIn");
		ParamsWrapper params = new ParamsWrapper();
		params.put("tel", user.getTel());
		params.put("password", user.getPassword());
		httpPost(url, params, handler);
	}

	public void doSignOut(JSONResponseHandler handler)
	{
		String url = makeURL(MODULE, "/doSignOut");
		httpGet(url, null, handler);
	}

	public void profile(long userId, JSONResponseHandler handler)
	{
		String url = makeURL(MODULE, "/profile");
		ParamsWrapper params = new ParamsWrapper();
		params.put("id", userId);
		httpGet(url, params, handler);
	}

	public void doChangeProfile(UserEntity user, JSONResponseHandler handler)
	{
		String url = makeURL(MODULE, "/doChangeProfile");
		ParamsWrapper params = new ParamsWrapper();
		params.put("name", user.getName());
		params.put("full_name", user.getFullName());
		params.put("other_tel", user.getOtherTel());
		httpPost(url, params, handler);
	}

	public void doChangePassword(String oldPassword, String newPassword, JSONResponseHandler handler)
	{
		String url = makeURL(MODULE, "/doChangePassword");
		ParamsWrapper params = new ParamsWrapper();
		params.put("password", oldPassword);
		params.put("newPassword", newPassword);
		httpPost(url, params, handler);
	}

	public void checkTelExist(String tel, JSONResponseHandler handler)
	{
		String url = makeURL(MODULE, "/checkExist");
		ParamsWrapper params = new ParamsWrapper();
		params.put("tel", tel);
		httpPost(url, params, handler);
	}
}
