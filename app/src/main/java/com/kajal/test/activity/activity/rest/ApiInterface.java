package com.kajal.test.activity.activity.rest;

import com.kajal.test.activity.activity.model.Login;
import com.kajal.test.activity.activity.model.MainPojo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("rest-auth/login/")
    Call<Login> createUser(@Body Login login);

    @GET("homes/houses/")
    Call<MainPojo> getHouseDetails(
            @Query("house_type") String house_type,
            @Query("furnish_type") String furnish_type,
            @Query("accomodation_type") String accomodation_type,
            @Query("bhk_count") Integer bhkcount

    );

}
