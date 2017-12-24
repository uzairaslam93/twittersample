package com.example.venturedive.twittersample;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Venturedive on 23/12/2017.
 */

public interface ShowTweetsApiService {

    @GET("/1.1/statuses/user_timeline.json")
    Call<List<Tweet>> show(@Query("screen_name") String name);
}
