package com.leemurking.leemurkingstore.Interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YelpApi {
    @GET("businesses/search")
    Call<YelpApiResponse> getProducts(
            @Query("location") String location,
            @Query("term") String term
    );
}
