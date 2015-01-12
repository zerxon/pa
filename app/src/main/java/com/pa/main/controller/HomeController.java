package com.pa.main.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.pa.R;
import com.pa.core.BaseController;
import com.pa.core.response.APIResponseHandler;
import com.pa.core.response.IAPIResponseListener;
import com.pa.detail.DetailActivity;
import com.pa.main.adapter.HomeListAdapter;
import com.pa.sdk.api.HotelAPI;
import com.pa.sdk.entity.HotelEntity;
import com.pa.sdk.parser.HotelsParser;
import com.pa.util.ImageLoaderGenerator;

import org.pulltorefresh.PullAndLoadListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/11/29
 * @desc   :
 */
public class HomeController extends BaseController
        implements PullAndLoadListView.OnRefreshListener,
        PullAndLoadListView.OnLoadMoreListener {

    private static final int DELAY_TIME = 600;

    private ImageLoader imageLoader;

    private PullAndLoadListView listView;
    private HomeListAdapter homeListAdapter;
    private Handler delayHandler = new Handler();

    private int currentPage = 1;
    private int pageSize = 10;

    private HotelAPI hotelAPI = new HotelAPI();

    private IAPIResponseListener listener = new IAPIResponseListener() {

        @Override
        public void onStart() {

        }

        @Override
        public void onResponse(JSONObject jsonObject) {
            final HotelsParser hotelsParser = new HotelsParser(jsonObject);

            if (hotelsParser.success) {
                if (currentPage == 0) {
                    homeListAdapter.setListItems(hotelsParser.hotels);

                    //refreshHandler.post(refreshRunnable);

                    homeListAdapter.notifyDataSetChanged();
                    listView.onRefreshComplete();
                    currentPage += 2;
                }
                else {
                    delayHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            homeListAdapter.addListItems(hotelsParser.hotels);
                            homeListAdapter.notifyDataSetChanged();
                            listView.onLoadMoreComplete();

                            if (hotelsParser.hotels == null || hotelsParser.hotels.size() == 0) {
                                Toast.makeText(context, "无更多数据", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                currentPage++;
                            }
                        }
                    }, DELAY_TIME);

                }

            }
        }

        @Override
        public void onError(Throwable throwable) {
            System.err.println(throwable.getMessage());
        }
    };

    public HomeController(Activity context) {
        super(context);
    }

    @Override
    public void initView() {
        listView = (PullAndLoadListView) layout.findViewById(R.id.home_list);
        listView.setOnRefreshListener(this);
        listView.setOnLoadMoreListener(this);

        List<HotelEntity> hotels = new ArrayList<HotelEntity>();

        /*
        for (int i =0; i < 10; i++) {
            HotelEntity hotel = new HotelEntity();
            hotel.setName("爱情公寓1");
            hotel.setTel("18344502419");
            hotels.add(hotel);
        }
        */


        homeListAdapter = new HomeListAdapter(layout.getContext(), hotels, R.layout.home_list_item);
        imageLoader = ImageLoaderGenerator.getInstance(context.getApplicationContext());
        homeListAdapter.setImageLoader(imageLoader);
        listView.setAdapter(homeListAdapter);
    }

    @Override
    public void bindAction() {
        //首次载入数据
        this.onRefresh();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id == -1) {
                    return;
                }

                Intent intent = new Intent();
                long hotelId = homeListAdapter.getListItems().get(position - 1).getId();
                intent.putExtra("hotelId", hotelId);
                intent.setClass(context, DetailActivity.class);
                context.startActivity(intent);
            }

        });
    }

    @Override
    public void onRefresh() {
        this.currentPage = 0;
        this.loadData();
    }

    @Override
    public void onLoadMore() {
        this.loadData();
    }

    private void loadData() {
        hotelAPI.batchHotels(currentPage, pageSize, new APIResponseHandler(listener));
    }
}
