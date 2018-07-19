package com.example.fredericomonteiro.githubtest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GitHubClient {
    @GET("/users/{user}")
    Call<GitHubUserProfile> infoForUser(
            @Path("user") String user);

    // fazer outro metodo para obter a lista
}
