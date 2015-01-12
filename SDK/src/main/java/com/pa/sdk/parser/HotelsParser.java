// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HotelsParser.java

package com.pa.sdk.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pa.sdk.core.BaseAPIParser;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pa.sdk.parser:
//			HotelParser

public class HotelsParser extends BaseAPIParser
{

	public List hotels;

	public HotelsParser(JSONObject json)
	{
		super(json);
		if (success)
		{
			hotels = new ArrayList();
			JSONArray jsonArray = data.getJSONArray("records");
			hotels = parse(jsonArray);
		}
	}

	public static List parse(JSONArray jsonArray)
	{
		if (jsonArray == null || jsonArray.size() == 0)
			return null;
		List hotels = new ArrayList();
		for (int i = 0; i < jsonArray.size(); i++)
		{
			com.pa.sdk.entity.HotelEntity store = HotelParser.parse(jsonArray.getJSONObject(i));
			hotels.add(store);
		}

		return hotels;
	}
}
