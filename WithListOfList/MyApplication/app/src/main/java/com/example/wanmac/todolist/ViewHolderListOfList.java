package com.example.wanmac.todolist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wanmac on 7/7/16.
 */
public class ViewHolderListOfList extends RecyclerView.ViewHolder {
    public TextView mTVListTitle;
    public Button mButtonDelete, mBuListDetail;

    public ViewHolderListOfList(View itemView) {

        super(itemView);
        mTVListTitle = (TextView) itemView.findViewById(R.id.textListName01);
        mButtonDelete = (Button) itemView.findViewById(R.id.buttonDelete);
        mBuListDetail = (Button) itemView.findViewById(R.id.buListDetail01);

    }
}
//buttonListDetail = (Button) findViewById(R.id.buListDetail01);