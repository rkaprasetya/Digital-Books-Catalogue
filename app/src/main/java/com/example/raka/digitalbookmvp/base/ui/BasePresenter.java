package com.example.raka.digitalbookmvp.base.ui;

import com.example.raka.digitalbookmvp.network.NetworkClient;
import com.example.raka.digitalbookmvp.network.NetworkStores;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class BasePresenter<V> {
    public V view;
    protected NetworkStores apiStores;
    private CompositeSubscription compositeSubscription;
    private Subscriber subscriber;

    public void attachView(V view){
        this.view = view;
        apiStores = NetworkClient.getRetrofit().create(NetworkStores.class);
    }

    public void detachView(){
        this.view = null;
        onUnsubscribe();
    }

    private void onUnsubscribe() {
        if (compositeSubscription != null && compositeSubscription.hasSubscriptions()){
            compositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Observable observable, Subscriber subscriber){
        this.subscriber = subscriber;
        if (compositeSubscription == null){
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(observable
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber));
    }
    public void stop(){
        if (subscriber!=null){
            subscriber.unsubscribe();
        }
    }
}
