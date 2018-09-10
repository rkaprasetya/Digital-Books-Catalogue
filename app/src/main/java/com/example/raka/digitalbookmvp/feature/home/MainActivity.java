package com.example.raka.digitalbookmvp.feature.home;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.raka.digitalbookmvp.R;
import com.example.raka.digitalbookmvp.adapter.BookAdapter;
import com.example.raka.digitalbookmvp.base.mvp.MvpActivity;
import com.example.raka.digitalbookmvp.model.Books;
import com.example.raka.digitalbookmvp.model.ItemsItem;
import com.example.raka.digitalbookmvp.utility.GridSpacingItemDecoration;
import com.example.raka.digitalbookmvp.utility.RecyclerItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView, SearchView.OnQueryTextListener {
    @BindView(R.id.rv_activity_main)
    RecyclerView rvActivityMain;
    @BindView(R.id.pb_activity_main)
    ProgressBar pbActivityMain;
    private String query = "Programming";
    private List<ItemsItem> list;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rvActivityMain.setLayoutManager(new GridLayoutManager(this,2));
        rvActivityMain.addOnItemTouchListener(selectItemOnRecyclerView());
        rvActivityMain.addItemDecoration(new GridSpacingItemDecoration(this,2,10,true));
        rvActivityMain.setItemAnimator(new DefaultItemAnimator());
        presenter.loadData(query);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        setupSearchView(searchView);

        return super.onCreateOptionsMenu(menu);
    }

    private void setupSearchView(SearchView searchView){
        searchView.setIconifiedByDefault(true);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        if(searchManager!=null){
            List<SearchableInfo> searchable = searchManager.getSearchablesInGlobalSearch();
            SearchableInfo info = searchManager.getSearchableInfo(getComponentName());
            for(SearchableInfo inf : searchable){
                if (inf.getSuggestAuthority() != null && inf.getSuggestAuthority().startsWith("applications")){
                    info = inf;
                }
                searchView.setSearchableInfo(info);
            }
            searchView.setOnQueryTextListener(this);
        }
    }

    private RecyclerItemClickListener selectItemOnRecyclerView() {
        return new RecyclerItemClickListener(this, rvActivityMain, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                presenter.getItem(list.get(position),activity);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                presenter.getItem(list.get(position),activity);
            }
        });
    }

    @Override
    public void showLoading() {
        pbActivityMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbActivityMain.setVisibility(View.GONE);

    }

    @Override
    public void getDataSuccess(Books model) {
        this.list = model.getItems();
        rvActivityMain.setAdapter(new BookAdapter(list,R.layout.item, getApplicationContext()));
    }

    @Override
    public void getDataFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveToDetail(Intent intent) {
         startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        getData(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        presenter.stop();
        getData(newText);
        return false;
    }

    public void refresh(View view){
        presenter.loadData(query);
    }

    private void getData(String query) {
        if (query != null) {
            this.query = query;
            presenter.loadData(query);
        }
    }
}
