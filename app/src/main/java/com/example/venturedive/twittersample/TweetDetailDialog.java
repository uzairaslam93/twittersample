package com.example.venturedive.twittersample;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Venturedive on 24/12/2017.
 */

public class TweetDetailDialog extends DialogFragment {
    ImageView crossButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tweet_detail_dialog, container,
                false);;
        // Do something else
        crossButton = rootView.findViewById(R.id.imageViewCloseDialog);
        crossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TweetDetailDialog.this.dismiss();
            }
        });
        return rootView;
    }
}
