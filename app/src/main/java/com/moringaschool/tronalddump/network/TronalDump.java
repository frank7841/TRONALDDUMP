package com.moringaschool.tronalddump.network;

import com.moringaschool.tronalddump.models.jokes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TronalDump {
    @GET("joke/Any?type=single")
    Call<jokes> getRandomJoke();

    @GET("joke/Any?type=single")
    Call<jokes> getJoke(
            @Query("contains") String jokeText
    );
}
