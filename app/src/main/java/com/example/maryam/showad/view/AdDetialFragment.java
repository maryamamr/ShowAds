package com.example.maryam.showad.view;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maryam.showad.R;
import com.example.maryam.showad.core.GetDataContract;
import com.example.maryam.showad.model.Ads;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdDetialFragment extends Fragment implements GetDataContract.CallBackRecievedData {
    @BindView(R.id.title_tv)
    TextView titleTextView;
    @BindView(R.id.ad_img)
    ImageView imageView;
    @BindView(R.id.go_to_web_btn)
    Button button;
    private String title, url, imgPath;

    public AdDetialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ad_detial, container, false);
        ButterKnife.bind(this, view);
        titleTextView.setText(title);
        Picasso.with(getContext()).load(imgPath).fit().into(imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open url in browser
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        return view;
    }

    //get sent data from fragment
    @Override
    public void onDataRecieved(Ads ads) {
        title = ads.getTitle();
        imgPath = ads.getPicture();
        url = ads.getUrl();
    }

}
