// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HotelEntity.java

package com.pa.sdk.entity;

import java.util.List;

// Referenced classes of package com.pa.sdk.entity:
//			UserEntity

public class HotelEntity
{

	private long id;
	private String name;
	private String logo;
	private String tel;
	private String otherTel;
	private String address;
	private boolean isOpening;
	private boolean status;
	private String description;
	private long addTime;
	private UserEntity user;
	private List rooms;

	public HotelEntity()
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLogo()
	{
		return logo;
	}

	public void setLogo(String logo)
	{
		this.logo = logo;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getOtherTel()
	{
		return otherTel;
	}

	public void setOtherTel(String otherTel)
	{
		this.otherTel = otherTel;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public boolean isOpening()
	{
		return isOpening;
	}

	public void setOpening(boolean isOpening)
	{
		this.isOpening = isOpening;
	}

	public boolean isStatus()
	{
		return status;
	}

	public void setStatus(boolean status)
	{
		this.status = status;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public long getAddTime()
	{
		return addTime;
	}

	public void setAddTime(long addTime)
	{
		this.addTime = addTime;
	}

	public UserEntity getUser()
	{
		return user;
	}

	public void setUser(UserEntity user)
	{
		this.user = user;
	}

	public List getRooms()
	{
		return rooms;
	}

	public void setRooms(List rooms)
	{
		this.rooms = rooms;
	}

	public String toString()
	{
		return (new StringBuilder()).append("HotelEntity{id=").append(id).append(", name='").append(name).append('\'').append(", logo='").append(logo).append('\'').append(", tel='").append(tel).append('\'').append(", otherTel='").append(otherTel).append('\'').append(", address='").append(address).append('\'').append(", isOpening=").append(isOpening).append(", status=").append(status).append(", description='").append(description).append('\'').append(", addTime=").append(addTime).append(", user=").append(user).append(", rooms=").append(rooms).append('}').toString();
	}
}
