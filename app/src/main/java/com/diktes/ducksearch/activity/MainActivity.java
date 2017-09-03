package com.diktes.ducksearch.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.diktes.ducksearch.BaseActivity;
import com.diktes.ducksearch.R;
import com.diktes.ducksearch.datamodel.DataModel;
import com.diktes.ducksearch.datamodel.dto.Search;
import com.diktes.ducksearch.network.Client;
import com.diktes.ducksearch.ui.ResultsAdapter;
import com.diktes.ducksearch.ui.SearchDialogFragment;
import com.diktes.ducksearch.utils.InternetUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements SearchDialogFragment.ISearch{
    public static final String TAG = BaseActivity.class.getSimpleName();

    protected RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected ResultsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void callSearch(String value) {
        if (InternetUtils.isInternetConnected(mContext)) {
            showLoadingDialog();
            DataModel.getInstance().setLastSearch(value);
            Client.searchData(reviewCallback, value);
        } else {
            Snackbar.make(mRecyclerView, R.string.no_internet, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
        }
    }

    //UI
    private void initUI() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_results);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ResultsAdapter(mContext);
        mRecyclerView.setAdapter(mAdapter);
        refreshData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchClick();
            }
        });
    }
    private void searchClick() {
        SearchDialogFragment newFragment = new SearchDialogFragment();
        newFragment.setSearchClick(this);
        newFragment.show(getSupportFragmentManager(), "SEARCH");
    }
    private void refreshData() {
        if (mAdapter != null) {
            mAdapter.setResults(DataModel.getInstance().getAllResults());
            mAdapter.notifyDataSetChanged();
        }
    }
    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            Snackbar.make(mRecyclerView, R.string.about, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //NETOWRK CALLBACK
    private Callback<Search> reviewCallback = new Callback<Search>() {
        @Override
        public void onResponse(Call<Search> call, Response<Search> response) {
            hideLoadingDialog();
            if (response.isSuccessful()) {
                DataModel.getInstance().setResults(response.body().getRelatedTopics());
                refreshData();
                Log.i(TAG, "OK");
            } else {
                Log.i(TAG,response.message());
            }
        }
        @Override
        public void onFailure(Call<Search> call, Throwable t) {
            hideLoadingDialog();
            Log.i(TAG, "Error: " + t.getMessage());
        }
    };

    //CLICK CALLBACK
    @Override
    public void onClick(String value) {
        callSearch(value);
    }
}