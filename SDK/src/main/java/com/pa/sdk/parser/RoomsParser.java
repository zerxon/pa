// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RoomsParser.java

package com.pa.sdk.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pa.sdk.core.BaseAPIParser;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pa.sdk.parser:
//			RoomParser

public class RoomsParser extends BaseAPIParser
{

	private List rooms;

	public RoomsParser(JSONObject data)
	{
		super(data);
		if (success)
		{
			rooms = new ArrayList();
			JSONArray jsonArray = this.data.getJSONArray("records");
			rooms = parse(jsonArray);
		}
	}

	public static List parse(JSONArray jsonArray)
	{
		if (jsonArray == null || jsonArray.size() == 0)
			return null;
		List rooms = new ArrayList();
		for (int i = 0; i < jsonArray.size(); i++)
		{
			com.pa.sdk.entity.RoomEntity room = RoomParser.parse(jsonArray.getJSONObject(i));
			rooms.add(room);
		}

		return rooms;
	}
}
