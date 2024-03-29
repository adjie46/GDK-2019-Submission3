package com.adjiekurniawan.sumbission3_dicoding.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.adjiekurniawan.sumbission3_dicoding.R;
import com.adjiekurniawan.sumbission3_dicoding.activities.DetailMovieActivity;
import com.adjiekurniawan.sumbission3_dicoding.adapters.TvAdapter;
import com.adjiekurniawan.sumbission3_dicoding.models.Tv;
import com.adjiekurniawan.sumbission3_dicoding.models.TvData;
import com.adjiekurniawan.sumbission3_dicoding.network.ApiService;
import com.adjiekurniawan.sumbission3_dicoding.utils.LoadMore;

import java.net.SocketTimeoutException;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentTvShow extends Fragment implements TvAdapter.OnTvItemSelectedListener {

    private View rootView;
    private RecyclerView dataTvShow;
    private GridLayoutManager gridLayoutManager;
    private TvAdapter tvAdapter;
    private SwipeRefreshLayout refreshLayout;
    private int page = 1;
    public static String CATEGORY_INTENT_TV = "TV";
    private LoadMore loadMore;
    private Tv tv;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tv_show, container, false);
        initView();
        if (savedInstanceState != null){
            tv = savedInstanceState.getParcelable(CATEGORY_INTENT_TV);
            tvAdapter.addAll(tv != null ? tv.getResults() : null);
            savedInstanceState.putParcelable(CATEGORY_INTENT_TV,tv);
            addScroll();
        }else{
            loadData();
            addScroll();
        }

        return rootView;
    }

    private void initView(){
        refreshLayout = rootView.findViewById(R.id.refresh);
        dataTvShow = rootView.findViewById(R.id.dataTvShow);

        tvAdapter = new TvAdapter(getContext());
        tvAdapter.setOnTvItemSelectedListener(this);
        gridLayoutManager = new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL, false);
        dataTvShow.setLayoutManager(gridLayoutManager);
        dataTvShow.setHasFixedSize(true);
        dataTvShow.setAdapter(tvAdapter);
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });
    }

    private void refreshData() {
        if(tvAdapter != null) {
            tvAdapter.clear();
        }
        page = 1;

        removeScroll();
        addScroll();

        loadData();
    }

    private void removeScroll() {
        dataTvShow.removeOnScrollListener(loadMore);
    }

    private void addScroll() {
        loadMore = new LoadMore(gridLayoutManager, page) {
            @Override
            public void onLoadMore(int next) {
                page = next;
                loadData();
            }
        };

        dataTvShow.addOnScrollListener(loadMore);
    }

    private void loadData(){
        Random r = new Random();
        page = r.nextInt(100 - 25) + 65;
        if (refreshLayout != null) {
            refreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    refreshLayout.setRefreshing(true);
                }
            });
        }
        ApiService apiService = new ApiService();
        apiService.getPopularTvShow(page, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                tv = (Tv) response.body();

                if(tv != null) {
                    if(tvAdapter != null) {
                        tvAdapter.addAll(tv.getResults());
                    }
                }else{
                    Toast.makeText(getContext(), getString(R.string.no_data_text), Toast.LENGTH_LONG).show();
                }

                if (refreshLayout != null)
                    refreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                if(t instanceof SocketTimeoutException) {
                    Toast.makeText(getContext(), getString(R.string.message_failed), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(), getString(R.string.message_connection_error), Toast.LENGTH_LONG).show();
                }

                if (refreshLayout != null)
                    refreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onItemClick(View v, TvData tvData, int position) {
        Intent detailMovie = new Intent(getActivity(), DetailMovieActivity.class);
        detailMovie.putExtra(DetailMovieActivity.EXTRA_TVSHOW, tvAdapter.getItem(position));
        detailMovie.putExtra(DetailMovieActivity.EXTRA_CATEGORY,CATEGORY_INTENT_TV);
        startActivity(detailMovie);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(CATEGORY_INTENT_TV, tv);
        super.onSaveInstanceState(outState);
    }
}
