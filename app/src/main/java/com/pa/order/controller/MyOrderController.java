package com.pa.order.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.pa.R;
import com.pa.core.BaseController;
import com.pa.core.response.APIResponseHandler;
import com.pa.core.response.IAPIResponseListener;
import com.pa.order.adapter.OrderListAdapter;
import com.pa.sdk.api.OrderAPI;
import com.pa.sdk.parser.OrdersParser;
import com.pa.util.APPConstants;
import com.pa.util.ImageLoaderGenerator;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2015/1/12
 * @desc   :
 */
public class MyOrderController extends BaseController {

    private ImageLoader imageLoader;

    private ProgressDialog progressDialog;

    private ListView listView;
    private OrderListAdapter orderListAdapter;

    private OrderAPI orderAPI = new OrderAPI();

    private IAPIResponseListener listener = new IAPIResponseListener() {
        @Override
        public void onStart() {
            progressDialog = ProgressDialog.show(context, null, APPConstants.LOADING);
        }

        @Override
        public void onResponse(JSONObject jsonObject) {
            OrdersParser parser = new OrdersParser(jsonObject);

            if (parser.success) {
                orderListAdapter.setListItems(parser.orders);
            }
            else {
                Toast.makeText(context, "无订单数据", Toast.LENGTH_SHORT).show();
            }

            progressDialog.dismiss();
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
            progressDialog.dismiss();
        }
    };

    public MyOrderController(Activity context) {
        super(context);
    }

    @Override
    public void initView() {
        listView = (ListView) this.layout.findViewById(R.id.order_list);

        orderListAdapter = new OrderListAdapter(layout.getContext(), null, R.layout.order_list_item);
        imageLoader = ImageLoaderGenerator.getInstance(context.getApplicationContext());
        orderListAdapter.setImageLoader(imageLoader);
        listView.setAdapter(orderListAdapter);
    }

    @Override
    public void bindAction() {
        orderAPI.batchOrders(new APIResponseHandler(listener));
    }
}
