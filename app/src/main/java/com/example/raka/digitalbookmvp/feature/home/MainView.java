package com.example.raka.digitalbookmvp.feature.home;

import android.content.Intent;

import com.example.raka.digitalbookmvp.model.Books;

public interface MainView {
    void showLoading();
    void hideLoading();
    void getDataSuccess(Books model);
    void getDataFail(String message);
    void moveToDetail(Intent intent);
}
