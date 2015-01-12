// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RoomParser.java

package com.pa.sdk.parser;

import com.alibaba.fastjson.JSONObject;
import com.pa.sdk.core.BaseAPIParser;
import com.pa.sdk.entity.RoomEntity;

// Referenced classes of package com.pa.sdk.parser:
//			HotelParser

public class RoomParser extends BaseAPIParser
{

	public RoomEntity room;

	public RoomParser(JSONObject data)
	{
		super(data);
		if (success)
			room = parse(this.data);
	}

	public static RoomEntity parse(JSONObject data)
	{
		RoomEntity room = new RoomEntity();
		room.setId(data.getLongValue("id"));
		room.setName(data.getString("name"));
		room.setPrice(data.getFloatValue("price"));
		room.setOtherPrice(data.getFloatValue("otherPrice"));
		room.setPhotos(data.getString("photos"));
		room.setDescription(data.getString("desc"));
		if (data.getJSONObject("hotel") != null)
			room.setHotel(HotelParser.parse(data.getJSONObject("hotel")));
		return room;
	}
}
