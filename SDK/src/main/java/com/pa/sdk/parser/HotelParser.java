// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HotelParser.java

package com.pa.sdk.parser;

import com.alibaba.fastjson.JSONObject;
import com.pa.sdk.core.BaseAPIParser;
import com.pa.sdk.entity.HotelEntity;

// Referenced classes of package com.pa.sdk.parser:
//			UserParser, RoomsParser

public class HotelParser extends BaseAPIParser
{

	public HotelEntity hotel;

	public HotelParser(JSONObject json)
	{
		super(json);
		if (success)
			hotel = parse(data);
	}

	public static HotelEntity parse(JSONObject data)
	{
		HotelEntity hotel = new HotelEntity();
		hotel.setId(data.getLongValue("id"));
		hotel.setName(data.getString("name"));
		hotel.setLogo(data.getString("logo"));
		hotel.setTel(data.getString("tel"));
		hotel.setOtherTel(data.getString("otherTel"));
		hotel.setAddress(data.getString("address"));
		hotel.setDescription(data.getString("desc"));
		hotel.setAddTime(data.getLongValue("addTime"));
		if (data.getJSONObject("user") != null)
			hotel.setUser(UserParser.parse(data.getJSONObject("user")));
		if (data.getJSONArray("rooms") != null)
		{
			java.util.List rooms = RoomsParser.parse(data.getJSONArray("rooms"));
			hotel.setRooms(rooms);
		}
		return hotel;
	}
}
