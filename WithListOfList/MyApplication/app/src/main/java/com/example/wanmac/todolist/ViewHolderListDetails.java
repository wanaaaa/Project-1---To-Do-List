package com.example.wanmac.todolist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by wanmac on 7/8/16.
 */
public class ViewHolderListDetails extends RecyclerView.ViewHolder {
    public TextView mTVListTitle;
    public EditText mEditItemTitle, mEditItemDetail;
    public Button mButtonDelete, mBuListDetail;
    public Button mButtonSave;

    public ViewHolderListDetails(View itemView) {

        super(itemView);


    }
}
