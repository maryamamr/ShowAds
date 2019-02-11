package com.example.maryam.showad.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maryam.showad.R;
import com.example.maryam.showad.core.GetDataContract;
import com.example.maryam.showad.model.Ads;
import com.example.maryam.showad.presenter.AdsPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements GetDataContract.View {
    @BindView(R.id.ads_recycelerview)
    RecyclerView recyclerView;
    AdsAdapter adsAdapter;
    private AdsPresenter adsPresenter;
    private GetDataContract.CallBackRecievedData callBackRecievedData;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        adsPresenter = new AdsPresenter(this);
        adsPresenter.getDataFromURL(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return view;
    }

    @Override
    public void onGetDataSuccess(List<Ads> list) {
        adsAdapter = new AdsAdapter(getActivity(), list, new AdsAdapter.OnItemClickListener() {
            @Override
            public void onClick(Ads item) {
                AdDetialFragment adDetialFragment = new AdDetialFragment();
                callBackRecievedData = adDetialFragment;
                callBackRecievedData.onDataRecieved(item);
                getFragmentManager().beginTransaction().replace(R.id.layout_container, adDetialFragment).addToBackStack(null).commit();
            }
        });

        recyclerView.setAdapter(adsAdapter);
    }

}
