package com.evgeniy.moiseev.testtask.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attachments {

    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("videos")
    @Expose
    private List<Video> videos = null;
    @SerializedName("posts")
    @Expose
    private Object posts;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Object getPosts() {
        return posts;
    }

    public void setPosts(Object posts) {
        this.posts = posts;
    }

}