// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OrderParser.java

package com.pa.sdk.parser;

import com.alibaba.fastjson.JSONObject;
import com.pa.sdk.core.BaseAPIParser;
import com.pa.sdk.entity.OrderEntity;

// Referenced classes of package com.pa.sdk.parser:
//			RoomParser

public class OrderParser extends BaseAPIParser
{

	public OrderEntity order;

	public OrderParser(JSONObject data)
	{
		super(data);
		if (!success);
	}

	public static OrderEntity parse(JSONObject data)
	{
		OrderEntity order = new OrderEntity();
		order.setId(data.getLongValue("id"));
		order.setCode(data.getString("code"));
		order.setComment(data.getString("comment"));
		order.setRange(data.getString("range"));
		order.setStatus(data.getIntValue("status"));
		order.setUserIgnore(data.getBooleanValue("isUserIgnore"));
		order.setMerchantIgnore(data.getBooleanValue("isMerchantIgnore"));
		order.setAddTime(data.getLongValue("addTime"));
		if (data.getJSONObject("room") != null)
			order.setRoom(RoomParser.parse(data.getJSONObject("room")));
		return order;
	}
}
