// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SessionEntity.java

package com.pa.sdk.entity;


// Referenced classes of package com.pa.sdk.entity:
//			UserEntity

public class SessionEntity
{

	private static SessionEntity instance;
	private String sessionId;
	private UserEntity user;

	public static void setInstance(SessionEntity instance)
	{
		instance = instance;
	}

	private SessionEntity()
	{
	}

	public static SessionEntity getInstance()
	{
		if (instance == null)
			instance = new SessionEntity();
		return instance;
	}

	public String getSessionId()
	{
		return sessionId;
	}

	public void setSessionId(String sessionId)
	{
		this.sessionId = sessionId;
	}

	public UserEntity getUser()
	{
		return user;
	}

	public void setUser(UserEntity user)
	{
		this.user = user;
	}

	public void destory()
	{
		sessionId = null;
		user = null;
	}
}
