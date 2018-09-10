package com.example.raka.digitalbookmvp.feature.detail;

import com.example.raka.digitalbookmvp.base.ui.BasePresenter;
import com.example.raka.digitalbookmvp.model.ItemsItem;
import com.example.raka.digitalbookmvp.network.NetworkCallback;

public class DetailPresenter extends BasePresenter<DetailView> {

    DetailPresenter(DetailView view){
        super.attachView(view);
    }
    void loadData(String id){
        view.showLoading();
        addSubscribe(apiStores.getDetailBook(id), new NetworkCallback<ItemsItem>() {
            @Override
            public void onSuccess(ItemsItem model) {
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
}
