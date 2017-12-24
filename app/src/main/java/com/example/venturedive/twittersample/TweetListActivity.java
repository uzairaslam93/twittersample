package com.example.venturedive.twittersample;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.twitter.sdk.android.core.TwitterCore;

public class TweetListActivity extends AppCompatActivity implements TimeLineFragment.OnFragmentInteractionListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.user_home:
                                addFragment(getFragment(R.id.user_home));
                                return true;
                            case R.id.timeline2:
                                addFragment(getFragment(R.id.timeline2));
                                return true;
                            case R.id.timeline3:
                                addFragment(getFragment(R.id.timeline3));
                                return true;
                        }
                        return false;
                    }
                });

        bottomNavigationView.setOnNavigationItemReselectedListener(
                new BottomNavigationView.OnNavigationItemReselectedListener() {
                    @Override
                    public void onNavigationItemReselected(@NonNull MenuItem item) {
                        return;
                    }
                });
    }

    public TimeLineFragment getFragment(int id) {
        switch (id) {
            case R.id.user_home:
                TimeLineFragment fragment = TimeLineFragment.newInstance(TwitterCore.getInstance()
                        .getSessionManager().getActiveSession().getUserName());
                return fragment;

            case R.id.timeline2:
                TimeLineFragment fragment2 = TimeLineFragment.newInstance("OlxEgypt");
                return fragment2;

            case R.id.timeline3:
                TimeLineFragment fragment3 = TimeLineFragment.newInstance("AndroidDev");
                return fragment3;

            default:
                return null;
        }
    }

    public void addFragment(TimeLineFragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerHome, fragment, null).addToBackStack(null)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

