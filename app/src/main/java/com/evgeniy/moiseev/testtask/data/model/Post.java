package com.evgeniy.moiseev.testtask.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("allow_comments")
    @Expose
    private boolean allowComments;
    @SerializedName("content")
    @Expose
    private Object content;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("attachments")
    @Expose
    private Attachments attachments;
    @SerializedName("site_link")
    @Expose
    private String siteLink;
    @SerializedName("intags")
    @Expose
    private List<Intag> intags = null;
    @SerializedName("place")
    @Expose
    private Place place;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("created_at_timestamp")
    @Expose
    private int createdAtTimestamp;
    @SerializedName("is_repost")
    @Expose
    private boolean isRepost;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("attachments_order")
    @Expose
    private List<AttachmentsOrder> attachmentsOrder = null;
    @SerializedName("is_liked")
    @Expose
    private boolean isLiked;
    @SerializedName("comments_count")
    @Expose
    private int commentsCount;
    @SerializedName("likes_count")
    @Expose
    private int likesCount;
    @SerializedName("extra")
    @Expose
    private Object extra;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("is_avatar")
    @Expose
    private boolean isAvatar;
    @SerializedName("is_bookmarked")
    @Expose
    private boolean isBookmarked;
    @SerializedName("is_reposted")
    @Expose
    private boolean isReposted;
    @SerializedName("bookmarks_count")
    @Expose
    private int bookmarksCount;
    @SerializedName("reposts_count")
    @Expose
    private int repostsCount;
    @SerializedName("views_count")
    @Expose
    private int viewsCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean getAllowComments() {
        return allowComments;
    }

    public void setAllowComments(boolean allowComments) {
        this.allowComments = allowComments;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Attachments getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments attachments) {
        this.attachments = attachments;
    }

    public String getSiteLink() {
        return siteLink;
    }

    public void setSiteLink(String siteLink) {
        this.siteLink = siteLink;
    }

    public List<Intag> getIntags() {
        return intags;
    }

    public void setIntags(List<Intag> intags) {
        this.intags = intags;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedAtTimestamp() {
        return createdAtTimestamp;
    }

    public void setCreatedAtTimestamp(int createdAtTimestamp) {
        this.createdAtTimestamp = createdAtTimestamp;
    }

    public boolean getIsRepost() {
        return isRepost;
    }

    public void setIsRepost(boolean isRepost) {
        this.isRepost = isRepost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AttachmentsOrder> getAttachmentsOrder() {
        return attachmentsOrder;
    }

    public void setAttachmentsOrder(List<AttachmentsOrder> attachmentsOrder) {
        this.attachmentsOrder = attachmentsOrder;
    }

    public boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public boolean getIsAvatar() {
        return isAvatar;
    }

    public void setIsAvatar(boolean isAvatar) {
        this.isAvatar = isAvatar;
    }

    public boolean getIsBookmarked() {
        return isBookmarked;
    }

    public void setIsBookmarked(boolean isBookmarked) {
        this.isBookmarked = isBookmarked;
    }

    public boolean getIsReposted() {
        return isReposted;
    }

    public void setIsReposted(boolean isReposted) {
        this.isReposted = isReposted;
    }

    public int getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(int bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

}