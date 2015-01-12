package com.pa.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014-10-1
 * @desc   :
 */
public abstract class PaBaseAdapter<T> extends BaseAdapter {
    protected Context context;
    protected LayoutInflater viewContainer;
    protected int itemViewResource;
    protected List<T> listItems;

    public PaBaseAdapter(Context context, List<T> listItems, int resource) {
        this.context = context;
        this.viewContainer = LayoutInflater.from(context);
        this.itemViewResource = resource;
        this.listItems  = listItems;
    }

    public List<T> getListItems() {
        return  this.listItems;
    }

    public void  setListItems(List<T> listItems) {
        this.listItems = listItems;
    }

    public void addListItems(List<T> listItems) {
        if (listItems != null)
            this.listItems.addAll(listItems);
    }

    @Override
    public int getCount() {
        return this.listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return this.listItems.get(i);
    }

    @Override
    public abstract long getItemId(int i);

    @Override
    public abstract View getView(int position, View view, ViewGroup viewGroup);

}
