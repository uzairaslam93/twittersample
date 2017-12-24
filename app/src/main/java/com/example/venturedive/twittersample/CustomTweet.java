package com.example.venturedive.twittersample;

import com.twitter.sdk.android.core.models.User;

/**
 * Created by Venturedive on 23/12/2017.
 */

public class CustomTweet {
    private String text;

    private String retweeted;

    private String possibly_sensitive;

    private String truncated;

    private String lang;

    private String is_quote_status;

    private String id;

    private String favorited;

    private String retweet_count;

    private String created_at;

    private String favorite_count;

    private String id_str;

    private User user;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(String retweeted) {
        this.retweeted = retweeted;
    }

    public String getPossibly_sensitive() {
        return possibly_sensitive;
    }

    public void setPossibly_sensitive(String possibly_sensitive) {
        this.possibly_sensitive = possibly_sensitive;
    }

    public String getTruncated() {
        return truncated;
    }

    public void setTruncated(String truncated) {
        this.truncated = truncated;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }


    public String getIs_quote_status() {
        return is_quote_status;
    }

    public void setIs_quote_status(String is_quote_status) {
        this.is_quote_status = is_quote_status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFavorited() {
        return favorited;
    }

    public void setFavorited(String favorited) {
        this.favorited = favorited;
    }

    public String getRetweet_count() {
        return retweet_count;
    }

    public void setRetweet_count(String retweet_count) {
        this.retweet_count = retweet_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(String favorite_count) {
        this.favorite_count = favorite_count;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    @Override
    public String toString() {
      //  return "ClassPojo [text = " + text + ", contributors = " + contributors + ", retweeted_status = " + retweeted_status + ", geo = " + geo + ", retweeted = " + retweeted + ", possibly_sensitive = " + possibly_sensitive + ", truncated = " + truncated + ", lang = " + lang + ", entities = " + entities + ", is_quote_status = " + is_quote_status + ", id = " + id + ", favorited = " + favorited + ", retweet_count = " + retweet_count + ", created_at = " + created_at + ", favorite_count = " + favorite_count + ", id_str = " + id_str + ", place = " + place + ", user = " + user + ", coordinates = " + coordinates + "]";
        return  "";
    }
}
