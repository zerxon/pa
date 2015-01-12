// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name:   RoomEntity.java

package com.pa.sdk.entity;

import java.text.DecimalFormat;

// Referenced classes of package com.pa.sdk.entity:
//			HotelEntity

public class RoomEntity
{

	private long id;
	private String name;
	private float price;
	private float otherPrice;
	private String photos;
	private int amount;
	private String description;
	private HotelEntity hotel;

	public RoomEntity()
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

	public String getPrice()
	{
        String strPrice = "";
        if (price > 0) {
            DecimalFormat decimalFormat = new DecimalFormat(".##");
            strPrice = decimalFormat.format(price);
        }

		return strPrice;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public String getOtherPrice()
	{
        String strOtherPrice = "";
        if (otherPrice > 0 ) {
            DecimalFormat decimalFormat = new DecimalFormat(".##");
            strOtherPrice = decimalFormat.format(otherPrice);
        }

		return strOtherPrice;
	}

	public void setOtherPrice(float otherPrice)
	{
		this.otherPrice = otherPrice;
	}

	public String[] getPhotos()
	{
		String[] photoArray = null;
        if (this.photos != null)
            photoArray = this.photos.split("\\|");

		return photoArray;
	}

	public void setPhotos(String photos)
	{
		this.photos = photos;
	}

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public HotelEntity getHotel()
	{
		return hotel;
	}

	public void setHotel(HotelEntity hotel)
	{
		this.hotel = hotel;
	}
}
