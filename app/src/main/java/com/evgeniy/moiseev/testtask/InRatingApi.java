package com.evgeniy.moiseev.testtask;

import com.evgeniy.moiseev.testtask.data.model.Persons;
import com.evgeniy.moiseev.testtask.data.model.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InRatingApi {

    @POST("users/posts/get")
    @FormUrlEncoded
    public Call<Post> getPost(@Field("slug") String slug);

    @POST("users/posts/likers/all")
    @FormUrlEncoded
    public Call<Persons> getLikers(@Field("id") long postId, @Field("page") int page);

    @POST("users/posts/commentators/all")
    @FormUrlEncoded
    public Call<Persons> getCommentators(@Field("id") long postId, @Field("page") int page);

    @POST("users/posts/mentions/all")
    @FormUrlEncoded
    public Call<Persons> getMentions(@Field("id") long postId, @Field("page") int page);

    @POST("users/posts/reposters/all")
    @FormUrlEncoded
    public Call<Persons> getReposts(@Field("id") long postId, @Field("page") int page);
}
