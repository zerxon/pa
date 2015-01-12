package com.pa.detail.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.pa.R;
import com.pa.core.PaBaseAdapter;
import com.pa.sdk.APIConstants;
import com.pa.sdk.entity.RoomEntity;

import java.util.List;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/12/14
 * @desc   :
 */
public class RoomListAdapter extends PaBaseAdapter<RoomEntity> {

    private class ListItemView {
        public TextView title;
        public ImageView thumb;
        public TextView price;
        public TextView otherPrice;
    }

    private ListItemView listItemView;

    private ImageLoader imageLoader;

    public RoomListAdapter(Context context, List<RoomEntity> listItems, int resource) {
        super(context, listItems, resource);
    }

    public void setImageLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    @Override
    public int getCount() {
        return this.listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = viewContainer.inflate(this.itemViewResource, null);
            listItemView = new ListItemView();
            listItemView.title = (TextView) view.findViewById(R.id.room_title);
            listItemView.thumb = (ImageView) view.findViewById(R.id.room_thumb);
            listItemView.price = (TextView) view.findViewById(R.id.room_price);
            listItemView.otherPrice = (TextView) view.findViewById(R.id.room_other_price);

            view.setTag(listItemView);
        }
        else {
            listItemView = (ListItemView) view.getTag();
        }

        RoomEntity room = listItems.get(position);
        listItemView.title.setText(room.getName());
        listItemView.price.setText(room.getPrice() + "元/天");
        String otherPrice = room.getOtherPrice() == "" ? "" : room.getOtherPrice() + "元/天";
        listItemView.otherPrice.setText(otherPrice);

        if (room.getPhotos() != null && room.getPhotos().length > 0) {
            String url = APIConstants.API_HOST + room.getPhotos()[0];
            this.imageLoader.displayImage(url, listItemView.thumb);
        }

        return view;
    }
}
