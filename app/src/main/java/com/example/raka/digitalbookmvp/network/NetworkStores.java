package com.example.raka.digitalbookmvp.network;

import com.example.raka.digitalbookmvp.model.Books;
import com.example.raka.digitalbookmvp.model.ItemsItem;


import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface NetworkStores {
    @GET("volumes")
    Observable<Books> getTopBooks(@Query("q")String key);
    @GET("volumes/{id}")
    Observable<ItemsItem> getDetailBook(@Path("id")String id);
}

