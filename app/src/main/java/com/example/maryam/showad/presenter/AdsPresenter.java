package com.example.maryam.showad.presenter;

import android.content.Context;

import com.example.maryam.showad.core.GetDataContract;
import com.example.maryam.showad.core.Interactor;
import com.example.maryam.showad.model.Ads;

import java.util.List;

public class AdsPresenter implements GetDataContract.Presenter, GetDataContract.onGetDataListener {
    private GetDataContract.View mGetDataView;
    private Interactor interactor;

    public AdsPresenter(GetDataContract.View mGetDataView) {
        this.mGetDataView = mGetDataView;
        interactor = new Interactor(this);
    }

    @Override
    public void onSuccess(List<Ads> list) {
        mGetDataView.onGetDataSuccess(list);
    }


    @Override
    public void getDataFromURL(Context context) {
        interactor.setRetroCall(context);

    }
}
