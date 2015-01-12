// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OrderEntity.java

package com.pa.sdk.entity;


// Referenced classes of package com.pa.sdk.entity:
//			RoomEntity

public class OrderEntity
{

	private long id;
	private String code;
	private String comment;
	private String range;
	private int status;
	private boolean isUserIgnore;
	private boolean isMerchantIgnore;
	private long addTime;
	private RoomEntity room;

	public OrderEntity()
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

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public String getRange()
	{
		return range;
	}

	public void setRange(String range)
	{
		this.range = range;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public boolean isUserIgnore()
	{
		return isUserIgnore;
	}

	public void setUserIgnore(boolean isUserIgnore)
	{
		this.isUserIgnore = isUserIgnore;
	}

	public boolean isMerchantIgnore()
	{
		return isMerchantIgnore;
	}

	public void setMerchantIgnore(boolean isMerchantIgnore)
	{
		this.isMerchantIgnore = isMerchantIgnore;
	}

	public long getAddTime()
	{
		return addTime;
	}

	public void setAddTime(long addTime)
	{
		this.addTime = addTime;
	}

	public RoomEntity getRoom()
	{
		return room;
	}

	public void setRoom(RoomEntity room)
	{
		this.room = room;
	}
}
