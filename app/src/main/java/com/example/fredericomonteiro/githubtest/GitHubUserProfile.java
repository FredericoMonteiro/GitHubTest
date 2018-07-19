package com.example.fredericomonteiro.githubtest;
import java.io.Serializable;
import java.net.URL;

import retrofit2.http.Url;

@SuppressWarnings("serial")
public class GitHubUserProfile implements Serializable {

    private String login;
    private String id;
    private String type;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String bio;
    private String repos;
    private String gits;
    private String followers;
    private String following;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String avatar_url;





    public GitHubUserProfile()
    {

    }




    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setrepos(String repos) {
        this.repos = repos;
    }

    public void setGits(String gits) {
        this.gits = gits;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getBlog() {
        return blog;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public String getrepos() {
        return repos;
    }

    public String getGits() {
        return gits;
    }

    public String getFollowers() {
        return followers;
    }

    public String getFollowing() {
        return following;
    }
}
