package com.zy.instagramstalker.model;

public class InstagramUser {
    private String id;
    private String userName;
    private String url;
    private int follower;
    private int following;
    private int post;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "InstagramUser{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", url='" + url + '\'' +
                ", follower=" + follower +
                ", following=" + following +
                ", post=" + post +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstagramUser that = (InstagramUser) o;

        if (follower != that.follower) return false;
        if (following != that.following) return false;
        return post == that.post;
    }

    @Override
    public int hashCode() {
        int result = follower;
        result = 31 * result + following;
        result = 31 * result + post;
        return result;
    }
}
