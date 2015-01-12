// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SessionParser.java

package com.pa.sdk.parser;

import com.alibaba.fastjson.JSONObject;
import com.pa.sdk.core.BaseAPIParser;
import com.pa.sdk.entity.SessionEntity;

// Referenced classes of package com.pa.sdk.parser:
//			UserParser

public class SessionParser extends BaseAPIParser
{

	public SessionEntity session;

	public SessionParser(JSONObject data)
	{
		super(data);
		if (success)
			session = parse(this.data);
	}

	public static SessionEntity parse(JSONObject data)
	{
		SessionEntity session = SessionEntity.getInstance();
		session.setSessionId(data.getString("sessionId"));
		com.pa.sdk.entity.UserEntity user = UserParser.parse(data.getJSONObject("user"));
		session.setUser(user);
		return session;
	}
}
