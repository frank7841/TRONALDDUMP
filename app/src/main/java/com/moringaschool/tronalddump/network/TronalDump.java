package com.moringaschool.tronalddump.network;

import com.moringaschool.tronalddump.models.Jokes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TronalDump {
    @GET("joke/Any?type=single")
    Call<Jokes> getRandomJoke();

    @GET("joke/Any?type=single")
    Call<Jokes> getJoke(
            @Query("contains") String jokeText
    );
}
