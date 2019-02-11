package com.example.maryam.showad.core;


import android.content.Context;

import com.example.maryam.showad.model.Ads;

import java.util.List;

public interface GetDataContract {

    interface View {
        //getting data in view
        void onGetDataSuccess(List<Ads> list);
    }


    interface CallBackRecievedData {
        //method for sending data between fragment
        void onDataRecieved(Ads ads);
    }

    interface Presenter {
        //get data from parsed url in presenter
        void getDataFromURL(Context context);
    }

    interface Interactor {
        //initialize retrofit call
        void setRetroCall(Context context);

    }

    interface onGetDataListener {
        void onSuccess(List<Ads> list);
    }
}

