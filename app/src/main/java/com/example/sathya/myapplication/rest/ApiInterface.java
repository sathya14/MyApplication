package com.example.sathya.myapplication.rest;

import com.example.sathya.myapplication.model.GetData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("person_object.json")
    Call<GetData> getTopRatedMovies();

}
