package com.example.sathya.myapplication.rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    public static final String BASE_URL = "https://api.androidhive.info/volley/";
    private static ApiInterface service;
    private static ApiManager apiManager;


    private ApiManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiInterface.class);
    }

    public static ApiManager getInstance() {
        if (apiManager == null) {
            apiManager = new ApiManager();
        }
        return apiManager;
    }

    public void getRegions(Callback<ResponseBody> callback) {
        Call<ResponseBody> call = service.getTopRatedMovies();
        call.enqueue(callback);

    }
}
