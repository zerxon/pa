// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OrdersParser.java

package com.pa.sdk.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pa.sdk.core.BaseAPIParser;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pa.sdk.parser:
//			OrderParser

public class OrdersParser extends BaseAPIParser
{

	public List orders;

	public OrdersParser(JSONObject data)
	{
		super(data);
		if (success)
			orders = parse(this.data.getJSONArray("records"));
	}

	public static List parse(JSONArray jsonArray)
	{
		if (jsonArray == null || jsonArray.size() == 0)
			return null;
		List orders = new ArrayList();
		for (int i = 0; i < jsonArray.size(); i++)
		{
			com.pa.sdk.entity.OrderEntity order = OrderParser.parse(jsonArray.getJSONObject(0));
			orders.add(order);
		}

		return orders;
	}
}
