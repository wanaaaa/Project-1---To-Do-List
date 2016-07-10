package com.example.wanmac.todolist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wanmac on 7/8/16.
 */
public class ViewHolderListDetails extends RecyclerView.ViewHolder {
    public TextView mRecyItemTitle, mRecyItemDetail ;
    public Button mBuRecyDelete;

    public ViewHolderListDetails(View itemView) {
        super(itemView);

        mRecyItemTitle = (TextView) itemView.findViewById(R.id.itemRecycleTitle01);
        mRecyItemDetail = (TextView) itemView.findViewById(R.id.itemRecycleDetail01);
        mBuRecyDelete = (Button) itemView.findViewById(R.id.buItemRecyDele01);

    }
}

