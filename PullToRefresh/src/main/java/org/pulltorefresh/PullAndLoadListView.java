package org.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PullAndLoadListView extends PullToRefreshListView {
    private LinearLayout mFooterView;
    private OnLoadMoreListener mOnLoadMoreListener;
    private boolean mIsLoadingMore = false;
    private TextView mTextViewLoadMore;
    private ProgressBar mProgressBarLoadMore;

	public PullAndLoadListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initComponent(context);
	}
	
	public PullAndLoadListView(Context context, AttributeSet attrs, int defStyle) { 
		super(context, attrs, defStyle);
		initComponent(context);
	}
	
	public void initComponent(Context context){
		mFooterView = (LinearLayout) inflater.inflate(R.layout.load_more_footer, this, false);
		mProgressBarLoadMore = (ProgressBar) mFooterView.findViewById(R.id.listview_foot_progress);
		mTextViewLoadMore = (TextView) mFooterView.findViewById(R.id.listview_foot_more);
		
		addFooterView(mFooterView);
	}
	
	public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener){
		mOnLoadMoreListener = onLoadMoreListener;
	}
	
	@Override
	public void onScroll(AbsListView view, int firstVisiableItem, int visibleItemCount,  int totalItemCount) {
		super.onScroll(view, firstVisiableItem, visibleItemCount, totalItemCount);
		
        // if need a list to load more items
        if (mOnLoadMoreListener != null) {
        	if (visibleItemCount == totalItemCount) {
        		return;
        	}
        	
        	//System.out.println("has listner. firstVisiableItem:"+firstVisiableItem+" visibleItemCount:"+visibleItemCount+" totalItemCount:"+totalItemCount);
        	
        	boolean loadMore = firstVisiableItem + visibleItemCount >= totalItemCount;
        	
        	if(!mIsLoadingMore && loadMore && state != REFRESHING && currentScrollState != SCROLL_STATE_IDLE){
                onStartLoadMore();
        		onLoadMore();
        	}
        }
	}
	
	private void onLoadMore() {
		if (mOnLoadMoreListener != null){
			mOnLoadMoreListener.onLoadMore();
		}
	}

    public void onStartLoadMore() {
        mIsLoadingMore = true;

        mProgressBarLoadMore.setVisibility(View.VISIBLE);
        mTextViewLoadMore.setText(R.string.loading);
    }
	
	/**
	 * Notify the loading more operation has finished
	 */
	public void onLoadMoreComplete() {
		mIsLoadingMore = false;
		mProgressBarLoadMore.setVisibility(View.GONE);
		mTextViewLoadMore.setText(R.string.more);
	}

	public interface OnLoadMoreListener {
		/**
		 * Called when the list reaches the last item (the last item is visible
		 * to the user) A call to
		 * {@link PullAndLoadListView #onLoadMoreComplete()} is expected to
		 * indicate that the loadmore has completed.
		 */
		public void onLoadMore();
	}
}
