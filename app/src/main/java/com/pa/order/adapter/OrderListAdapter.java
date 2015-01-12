package com.pa.order.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.pa.core.PaBaseAdapter;
import com.pa.sdk.entity.OrderEntity;

import java.util.List;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2015/1/12
 * @desc   :
 */
public class OrderListAdapter extends PaBaseAdapter<OrderEntity> {

    private class ListItemView {
        public TextView title;
        public TextView state;
        public Button btnCancel;
    }

    private ListItemView listItemView;
    private ImageLoader imageLoader;

    public OrderListAdapter(Context context, List<OrderEntity> listItems, int resource) {
        super(context, listItems, resource);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = viewContainer.inflate(itemViewResource, null);
            listItemView = new ListItemView();
        }
        else
        {
            listItemView = (ListItemView)view.getTag();
        }

        return null;
    }

    public void setImageLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }
}
