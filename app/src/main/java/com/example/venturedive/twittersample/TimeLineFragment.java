package com.example.venturedive.twittersample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import butterknife.BindView;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


public class TimeLineFragment extends Fragment implements TweetListAdapter.TweetSelectionCallback {
    @BindView(R.id.recyclerViewTweetTimeLine)
    RecyclerView tweetList;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String twitterId;

    private OnFragmentInteractionListener mListener;

    public TimeLineFragment() {
        // Required empty public constructor
    }

    public static TimeLineFragment newInstance(String param1) {
        TimeLineFragment fragment = new TimeLineFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            twitterId = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_time_line, container, false);
        tweetList = rootView.findViewById(R.id.recyclerViewTweetTimeLine);
        initDependencies(rootView);
        return rootView;
    }

    private void initDependencies(View rootView) {
        tweetList.setLayoutManager(new LinearLayoutManager(getContext()));
        final TwitterSession activeSession = TwitterCore.getInstance()
                .getSessionManager().getActiveSession();

        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient customClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor).build();
        ImplShowTweetsApiService implShowTweetsApiService = new ImplShowTweetsApiService(activeSession, customClient, this, twitterId);
        implShowTweetsApiService.getUserList();

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onTweetSelected(int position) {
        TweetDetailDialog dTweetDetailDialog = new TweetDetailDialog();
        // Show DialogFragment
        dTweetDetailDialog.show(getActivity().getFragmentManager(), "Dialog TweetDetailDialog");
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void onSuccess(List<Tweet> tweetLists) {
        TweetListAdapter adapter = new TweetListAdapter(tweetLists);
        adapter.setTweetSelectionCallback(this);
        tweetList.setAdapter(adapter);
    }
}
