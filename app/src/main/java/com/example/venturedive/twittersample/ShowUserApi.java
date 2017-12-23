package com.example.venturedive.twittersample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Venturedive on 23/12/2017.
 */

public interface ShowUserApi {

    @GET("/1.1/statuses/user_timeline.json")
    Call<TweetList> show(@Query("screen_name") String name);
}
