package com.userprofiling.twitterside;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Entities_ {

    @Expose
    private List<Object> hashtags = new ArrayList<Object>();
    @Expose
    private List<Object> symbols = new ArrayList<Object>();
    @Expose
    private List<Url> urls = new ArrayList<Url>();
    @Expose
    private List<User_mention> user_mentions = new ArrayList<User_mention>();

    public List<Object> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Object> hashtags) {
        this.hashtags = hashtags;
    }

    public List<Object> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Object> symbols) {
        this.symbols = symbols;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public List<User_mention> getUser_mentions() {
        return user_mentions;
    }

    public void setUser_mentions(List<User_mention> user_mentions) {
        this.user_mentions = user_mentions;
    }

}
