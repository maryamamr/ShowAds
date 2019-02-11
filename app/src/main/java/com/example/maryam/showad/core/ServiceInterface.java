package com.example.maryam.showad.core;

import com.example.maryam.showad.model.Ads;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceInterface {
    @GET("get_ad/?solo=false")
    Call<List<Ads>> getResult();
}
