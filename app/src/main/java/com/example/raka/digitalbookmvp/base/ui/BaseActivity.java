package com.example.raka.digitalbookmvp.base.ui;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import rx.subscriptions.CompositeSubscription;

public class BaseActivity extends AppCompatActivity {

    public Activity activity;
    CompositeSubscription compositeSubscription;
    List<Call> call;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        activity = this;
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onCancelled();
        onUnsubscribe();
    }

    private void onCancelled(){
        if (call != null && call.size() > 0){
            for (Call mCall : call){
                if (!mCall.isCanceled()){
                    mCall.cancel();
                }
            }
        }
    }

    private void onUnsubscribe(){
        if (compositeSubscription != null && compositeSubscription.hasSubscriptions()){
            compositeSubscription.unsubscribe();
        }
    }
}
