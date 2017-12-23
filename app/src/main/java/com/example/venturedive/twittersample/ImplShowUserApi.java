package com.example.venturedive.twittersample;

import android.util.Log;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;

import okhttp3.OkHttpClient;

/**
 * Created by Venturedive on 23/12/2017.
 */

public class ImplShowUserApi extends TwitterApiClient {
    ShowUserApi showUserApi;
    long userId;

    public ImplShowUserApi(TwitterSession session, OkHttpClient client) {
        super(session, client);
        userId = session.getUserId();
        showUserApi = getService(ShowUserApi.class);
    }

    public void getUserList() {
        showUserApi.show("twitterapi").enqueue(new Callback<TweetList>() {
            @Override
            public void success(Result<TweetList> result) {
                Log.d("tweet", "success() called with: result = [" + result + "]");
            }

            @Override
            public void failure(TwitterException exception) {
                Log.d("tweet", "failure() called with: result = [" + exception.getLocalizedMessage()+ "]");
            }
        });
    }
}
