package com.example.wanmac.todo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wanmac on 7/6/16.
 */
public class ViewHolerOne extends RecyclerView.ViewHolder {
    public TextView mTextViewTitle, mTextViewDescription;
    public Button mButtonDelete;

    public ViewHolerOne(View itemView) {
        super(itemView);

        mTextViewTitle = (TextView) itemView.findViewById(R.id.titleID);
        mTextViewDescription = (TextView) itemView.findViewById(R.id.detailID);
        mButtonDelete = (Button) itemView.findViewById(R.id.buttonDelete);
    }
}
