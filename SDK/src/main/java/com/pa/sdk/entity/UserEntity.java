// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserEntity.java

package com.pa.sdk.entity;


public class UserEntity
{

	private long id;
	private String tel;
	private String password;
	private String name;
	private String fullName;
	private String avatar;
	private String otherTel;
	private boolean isMerchant;
	private boolean isAdmin;
	private long addTime;

	public UserEntity()
	{
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public String getAvatar()
	{
		return avatar;
	}

	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}

	public String getOtherTel()
	{
		return otherTel;
	}

	public void setOtherTel(String otherTel)
	{
		this.otherTel = otherTel;
	}

	public boolean isMerchant()
	{
		return isMerchant;
	}

	public void setMerchant(boolean isMerchant)
	{
		this.isMerchant = isMerchant;
	}

	public boolean isAdmin()
	{
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}

	public long getAddTime()
	{
		return addTime;
	}

	public void setAddTime(long addTime)
	{
		this.addTime = addTime;
	}

	public String toString()
	{
		return (new StringBuilder()).append("UserEntity{id=").append(id).append(", tel='").append(tel).append('\'').append(", password='").append(password).append('\'').append(", name='").append(name).append('\'').append(", fullName='").append(fullName).append('\'').append(", avatar='").append(avatar).append('\'').append(", otherTel='").append(otherTel).append('\'').append(", isMerchant=").append(isMerchant).append(", isAdmin=").append(isAdmin).append(", addTime=").append(addTime).append('}').toString();
	}
}
