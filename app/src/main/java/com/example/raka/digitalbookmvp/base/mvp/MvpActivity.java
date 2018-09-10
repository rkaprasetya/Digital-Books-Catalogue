package com.example.raka.digitalbookmvp.base.mvp;

import android.os.Bundle;

import com.example.raka.digitalbookmvp.base.ui.BaseActivity;
import com.example.raka.digitalbookmvp.base.ui.BasePresenter;

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P presenter;
    protected abstract P createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        presenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detachView();
        }
    }
}
