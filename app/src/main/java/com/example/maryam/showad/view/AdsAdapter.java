package com.example.maryam.showad.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maryam.showad.R;
import com.example.maryam.showad.model.Ads;

import java.util.List;

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.AdsViewHolder> {

    private Context mContext;
    private List<Ads> adsList;
    private OnItemClickListener clickListener;

    public AdsAdapter(Context mContext, List<Ads> adsList, OnItemClickListener clickListener) {
        this.mContext = mContext;
        this.adsList = adsList;
        this.clickListener = clickListener;
    }

    @Override
    public AdsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AdsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_ad_view, parent, false));
    }

    @Override
    public void onBindViewHolder(AdsViewHolder holder, int position) {

        //set text
        holder.titleTextView.setText(String.format(adsList.get(position).getTitle()));
        //set click listner on item
        holder.click(adsList.get(position), clickListener);
    }

    public interface OnItemClickListener {
        void onClick(Ads Item);
    }

    @Override
    public int getItemCount() {
        return adsList == null ? 0 : adsList.size();
    }

    public class AdsViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;

        public AdsViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.ad_title_tv);
        }

        public void click(final Ads ads, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(ads);
                }
            });
        }

    }
}
