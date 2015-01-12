package com.pa.detail.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.pa.R;
import com.pa.core.BaseController;
import com.pa.core.response.APIResponseHandler;
import com.pa.core.response.IAPIResponseListener;
import com.pa.detail.adapter.RoomListAdapter;
import com.pa.sdk.api.HotelAPI;
import com.pa.sdk.entity.HotelEntity;
import com.pa.sdk.entity.RoomEntity;
import com.pa.sdk.parser.HotelParser;
import com.pa.util.APPConstants;
import com.pa.util.ImageLoaderGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/12/13
 * @desc   :
 */
public class DetailController extends BaseController {

    private long hotelId;
    private HotelEntity hotel;
    private ListView listView;
    private RoomListAdapter roomListAdapter;

    private ImageLoader imageLoader;
    private ProgressDialog progressDialog;

    private HotelAPI hotelAPI = new HotelAPI();

    private IAPIResponseListener listener = new IAPIResponseListener() {
        @Override
        public void onStart() {
            progressDialog = ProgressDialog.show(context, null, APPConstants.LOADING);
        }

        @Override
        public void onResponse(JSONObject jsonObject) {
            HotelParser hotelParser = new HotelParser(jsonObject);

            if (hotelParser.success) {
                hotel = hotelParser.hotel;
                roomListAdapter.setListItems(hotelParser.hotel.getRooms());
                roomListAdapter.notifyDataSetChanged();
            }
            else {
                Toast.makeText(context, hotelParser.message, Toast.LENGTH_SHORT).show();
            }

            progressDialog.dismiss();
        }

        @Override
        public void onError(Throwable throwable) {
            System.err.println(throwable.getMessage());
            progressDialog.dismiss();
        }
    };

    public DetailController(Activity context, long hotelId) {
        super(context);
        this.hotelId = hotelId;
    }

    @Override
    public void initView() {
        //listView =  (ListView) this.layout.findViewById(R.id.detail_room_list);
        listView = (ListView) this.layout;

        View headerView = context.getLayoutInflater().inflate(R.layout.detail_header, null);
        listView.addHeaderView(headerView);

        List<RoomEntity> rooms = new ArrayList<RoomEntity>();
        roomListAdapter = new RoomListAdapter(context, rooms, R.layout.room_list_item);
        imageLoader = ImageLoaderGenerator.getInstance(context.getApplicationContext());
        roomListAdapter.setImageLoader(imageLoader);
        listView.setAdapter(roomListAdapter);
    }

    @Override
    public void bindAction() {
        hotelAPI.queryHotelDetail(hotelId, new APIResponseHandler(listener));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
