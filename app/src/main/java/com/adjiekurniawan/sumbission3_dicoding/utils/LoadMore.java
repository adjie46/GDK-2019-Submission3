package com.adjiekurniawan.sumbission3_dicoding.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class LoadMore extends RecyclerView.OnScrollListener {
    private int previousTotal = 0;
    private boolean loading = true;
    private int firstVisibleItem;

    private int offset;

    private RecyclerView.LayoutManager mLayoutManager;
    private boolean isUseLinearLayoutManager;

    protected LoadMore(LinearLayoutManager linearLayoutManager, int offset) {
        this.mLayoutManager = linearLayoutManager;
        isUseLinearLayoutManager = true;
        this.offset = 0;
        this.offset = offset;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (isUseLinearLayoutManager && mLayoutManager instanceof LinearLayoutManager) {
            firstVisibleItem = ((LinearLayoutManager) mLayoutManager).findFirstVisibleItemPosition();
        }

        int visibleItemCount = mLayoutManager.getChildCount();
        int totalItemCount = mLayoutManager.getItemCount();

        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        int visibleThreshold = 1;
        int limit = 0;
        if (!loading && (totalItemCount - visibleItemCount)
                <= (firstVisibleItem + visibleThreshold)
                && totalItemCount >= limit) {
            // End has been reached

            // Do something
            offset++;
            onLoadMore(offset);

            loading = true;
        }
    }

    public abstract void onLoadMore(int offset);
}
