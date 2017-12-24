package com.example.venturedive.twittersample;

import android.util.Log;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import okhttp3.OkHttpClient;

/**
 * Created by Venturedive on 23/12/2017.
 */

public class ImplShowTweetsApiService extends TwitterApiClient {
    ShowTweetsApiService showTweetsApiService;
    long userId;
    TimeLineFragment fragment;
    String twitterId;

    public ImplShowTweetsApiService(TwitterSession session, OkHttpClient client, TimeLineFragment timeLineFragment, String twitterId) {
        super(session, client);
        userId = session.getUserId();
        showTweetsApiService = getService(ShowTweetsApiService.class);
        fragment = timeLineFragment;
        this.twitterId = twitterId;
    }

    public void getUserList() {
        showTweetsApiService.show(twitterId).enqueue(new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> result) {
                fragment.onSuccess(result.data);
                Log.d("tweet", "success() called with: result = [" + result + "]");
            }

            @Override
            public void failure(TwitterException exception) {
                Log.d("tweet", "failure() called with: result = [" + exception.getLocalizedMessage() + "]");
            }
        });
    }
}
