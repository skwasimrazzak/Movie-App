package com.shiftux.themovieapp.serviceapi;

import com.shiftux.themovieapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    //The service interface defines the structure and behaviour of the API requests.

    @GET("movie/popular")
    Call<Result> getPopularMovie(@Query("api_key") String apikey);
}
