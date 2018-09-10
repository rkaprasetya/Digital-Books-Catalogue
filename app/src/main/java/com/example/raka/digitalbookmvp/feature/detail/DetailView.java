package com.example.raka.digitalbookmvp.feature.detail;

import com.example.raka.digitalbookmvp.model.ItemsItem;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void getDataSuccess(ItemsItem item);
    void getDataFail(String message);
    void refreshData();
}
