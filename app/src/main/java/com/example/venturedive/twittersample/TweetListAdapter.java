package com.example.venturedive.twittersample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

/**
 * Created by Venturedive on 23/12/2017.
 */

public class TweetListAdapter extends RecyclerView.Adapter<TweetListAdapter.ViewHolder> {
    List<Tweet> tweetList;
    Context mContext;
    TweetSelectionCallback tweetSelectionCallback;

    public TweetListAdapter(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.tweet_list_item, parent, false);
        return new TweetListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tweet tweet = tweetList.get(position);
        holder.displayName.setText(tweet.user.name);
        holder.displayHandle.setText("@" + tweet.user.screenName);
        holder.tweetText.setText(tweet.text);
        Glide.with(mContext)
                .load(tweet.user.profileImageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.profileImage);

    }

    @Override
    public int getItemCount() {
       return tweetList == null ? 0 : tweetList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView displayName;
        TextView displayHandle;
        TextView date;
        TextView tweetText;

        public ViewHolder(View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.imageViewUserProfile);
            displayName = itemView.findViewById(R.id.textViewDisplayName);
            displayHandle = itemView.findViewById(R.id.textViewProfileId);
            date = itemView.findViewById(R.id.textViewTweetTime);
            tweetText = itemView.findViewById(R.id.textViewTweetDescription);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tweetSelectionCallback.onTweetSelected(getAdapterPosition());
                }
            });

        }
    }

    public void setTweetSelectionCallback(TweetSelectionCallback tweetSelectionCallback){
        this.tweetSelectionCallback = tweetSelectionCallback;
    }

    public interface TweetSelectionCallback{
        public void onTweetSelected(int position);
    }
}
