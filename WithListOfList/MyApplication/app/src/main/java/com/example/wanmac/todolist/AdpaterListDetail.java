package com.example.wanmac.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wanmac on 7/8/16.
 */
public class AdpaterListDetail extends RecyclerView.Adapter<ViewHolderListDetails> {
    List<IndiTitleDetail> mIndiTitleDetails;

    /////////////////////////////////////////
    //private Bundle int aaa = getIntent().getExtra("indexTitleDetail", -1);

    public AdpaterListDetail(List<IndiTitleDetail> arg) {
        mIndiTitleDetails = arg;
    }

    @Override
    public ViewHolderListDetails onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_list_detail, parent, false);

        ViewHolderListDetails viewHolderListDetails = new ViewHolderListDetails(parentView);

        return viewHolderListDetails;
    }

    @Override
    public void onBindViewHolder(final ViewHolderListDetails holder,final int position) {
        holder.mRecyItemTitle.setText((CharSequence) mIndiTitleDetails.get(position).getmTitle());
        holder.mRecyItemDetail.setText((CharSequence) mIndiTitleDetails.get(position).getmDetail());

      // Bundle indexTitleDetail = getIntent.getExtr();
       // int aa = Intent.getIntentOld("indexTitleDetail")


        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /////////////////////////////////////

            }
        };

    }

    @Override
    public int getItemCount() {
        return mIndiTitleDetails.size();
    }

    public void removeAt(int position){
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mIndiTitleDetails.size());
    }

}
