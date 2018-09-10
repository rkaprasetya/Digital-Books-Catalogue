package com.example.raka.digitalbookmvp.feature.home;

import android.app.Activity;
import android.content.Intent;

import com.example.raka.digitalbookmvp.base.ui.BasePresenter;
import com.example.raka.digitalbookmvp.feature.detail.DetailActivity;
import com.example.raka.digitalbookmvp.model.Books;
import com.example.raka.digitalbookmvp.model.ItemsItem;
import com.example.raka.digitalbookmvp.network.NetworkCallback;

public class MainPresenter extends BasePresenter<MainView> {
    MainPresenter(MainView view){
        super.attachView(view);
    }

    void loadData(String key){
        view.showLoading();
        addSubscribe(apiStores.getTopBooks(key), new NetworkCallback<Books>() {
            @Override
            public void onSuccess(Books model) {
                view.getDataSuccess(model);

            }

            @Override
            public void onFailure(String message) {
                view.getDataFail(message);
            }

            @Override
            public void onFinish() {
                view.hideLoading();
            }
        });
    }
    void getItem(ItemsItem item, Activity activity){
        Intent intent = new Intent(activity,DetailActivity.class);
        intent.putExtra("id", item.getId());
        view.moveToDetail(intent);
    }
}
