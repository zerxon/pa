package com.pa.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.pa.R;
import com.pa.core.PaBaseAdapter;
import com.pa.sdk.APIConstants;
import com.pa.sdk.entity.HotelEntity;

import java.util.List;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/10/1
 * @desc   :
 */
public class HomeListAdapter extends PaBaseAdapter<HotelEntity> {

    private class ListItemView {
        public TextView title;
        public TextView contact;
        public TextView address;
        public ImageView logo;
    }

    private ImageLoader imageLoader;

    private ListItemView listItemView;

    public HomeListAdapter(Context context, List<HotelEntity> listItems, int resource) {
        super(context, listItems, resource);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        //view 重用
        if (view == null)
        {
            view = viewContainer.inflate(itemViewResource, null);
            listItemView = new ListItemView();
            listItemView.logo = (ImageView)view.findViewById(R.id.house_img);
            listItemView.title = (TextView)view.findViewById(R.id.house_title);
            listItemView.contact = (TextView)view.findViewById(R.id.house_contact);
            listItemView.address = (TextView)view.findViewById(R.id.house_address);
            view.setTag(listItemView);
        }
        else
        {
            listItemView = (ListItemView)view.getTag();
        }

        HotelEntity hotel = listItems.get(position);
        listItemView.title.setText(hotel.getName());
        listItemView.contact.setText(hotel.getTel());
        listItemView.address.setText(hotel.getAddress());

        if (hotel.getLogo() != null) {
            imageLoader.displayImage(hotel.getLogo(), listItemView.logo);
        }

        return view;
    }

    public void setImageLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

}
