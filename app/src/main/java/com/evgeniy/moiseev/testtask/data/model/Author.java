package com.evgeniy.moiseev.testtask.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("active_gift")
    @Expose
    private ActiveGift activeGift;
    @SerializedName("avatar_image")
    @Expose
    private AvatarImage avatarImage;
    @SerializedName("off_page")
    @Expose
    private boolean offPage;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("is_subscribed")
    @Expose
    private boolean isSubscribed;
    @SerializedName("is_online")
    @Expose
    private boolean isOnline;
    @SerializedName("last_online_timestamp")
    @Expose
    private int lastOnlineTimestamp;
    @SerializedName("in_my_blacklist")
    @Expose
    private boolean inMyBlacklist;
    @SerializedName("has_me_in_blacklist")
    @Expose
    private boolean hasMeInBlacklist;
    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("contest_entry_instance")
    @Expose
    private ContestEntryInstance contestEntryInstance;
    @SerializedName("chat_main_lang")
    @Expose
    private String chatMainLang;
    @SerializedName("is_voted")
    @Expose
    private boolean isVoted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ActiveGift getActiveGift() {
        return activeGift;
    }

    public void setActiveGift(ActiveGift activeGift) {
        this.activeGift = activeGift;
    }

    public AvatarImage getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(AvatarImage avatarImage) {
        this.avatarImage = avatarImage;
    }

    public boolean getOffPage() {
        return offPage;
    }

    public void setOffPage(boolean offPage) {
        this.offPage = offPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public int getLastOnlineTimestamp() {
        return lastOnlineTimestamp;
    }

    public void setLastOnlineTimestamp(int lastOnlineTimestamp) {
        this.lastOnlineTimestamp = lastOnlineTimestamp;
    }

    public boolean getInMyBlacklist() {
        return inMyBlacklist;
    }

    public void setInMyBlacklist(boolean inMyBlacklist) {
        this.inMyBlacklist = inMyBlacklist;
    }

    public boolean getHasMeInBlacklist() {
        return hasMeInBlacklist;
    }

    public void setHasMeInBlacklist(boolean hasMeInBlacklist) {
        this.hasMeInBlacklist = hasMeInBlacklist;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ContestEntryInstance getContestEntryInstance() {
        return contestEntryInstance;
    }

    public void setContestEntryInstance(ContestEntryInstance contestEntryInstance) {
        this.contestEntryInstance = contestEntryInstance;
    }

    public String getChatMainLang() {
        return chatMainLang;
    }

    public void setChatMainLang(String chatMainLang) {
        this.chatMainLang = chatMainLang;
    }

    public boolean getIsVoted() {
        return isVoted;
    }

    public void setIsVoted(boolean isVoted) {
        this.isVoted = isVoted;
    }

}