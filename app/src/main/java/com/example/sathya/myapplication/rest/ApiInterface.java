package com.example.sathya.myapplication.rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("person_object.json")
    Call<ResponseBody> getTopRatedMovies();

}
