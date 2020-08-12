package com.moringaschool.tronalddump.network;

import com.moringaschool.tronalddump.TronaldDump;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface TronalDump {
    @Headers("accept: application/hal+json")
    @GET("search/quote")
    Call<TronaldDump> searchQuote(
            @Query("Query") String Search);
}
