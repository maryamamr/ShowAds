package com.example.maryam.showad.core;

import android.content.Context;
import android.util.Log;

import com.example.maryam.showad.model.Ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Interactor implements GetDataContract.Interactor {
    private GetDataContract.onGetDataListener mOnGetDatalistener;
    private Retrofit retrofit = null;
    private String BASE_URL = "https://simswitch.bit68.com/";

    public Interactor(GetDataContract.onGetDataListener mOnGetDatalistener) {
        this.mOnGetDatalistener = mOnGetDatalistener;
    }

    @Override
    public void setRetroCall(Context context) {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        ServiceInterface requestInterface = retrofit.create(ServiceInterface.class);
        Call<List<Ads>> call = requestInterface.getResult();
        call.enqueue(new Callback<List<Ads>>() {
            @Override
            public void onResponse(Call<List<Ads>> call, Response<List<Ads>> response) {
                //get json from parsed url
                List<Ads> getJson = response.body();
                //sort order ascending
                Collections.sort(getJson, new Comparator<Ads>() {
                    @Override
                    public int compare(Ads o1, Ads o2) {
                        return o1.getOrder().compareTo(o2.getOrder());
                    }
                });
                Log.i("check order", String.valueOf(getJson.get(0).getOrder()));
                mOnGetDatalistener.onSuccess(getJson);
            }

            @Override
            public void onFailure(Call<List<Ads>> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });
    }
}
