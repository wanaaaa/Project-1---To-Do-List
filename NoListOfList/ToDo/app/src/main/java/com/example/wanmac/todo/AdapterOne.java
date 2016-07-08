package com.example.wanmac.todo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by wanmac on 7/6/16.
 */
public class AdapterOne extends RecyclerView.Adapter<ViewHolerOne> {
    List<IndiTitleDetail> mTitileDetail;

    public AdapterOne(List<IndiTitleDetail> titleDetails ) {
        mTitileDetail = titleDetails;
    }

    @Override
    public ViewHolerOne onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.title_detail, parent,false);
        ViewHolerOne viewHoler = new ViewHolerOne(parentView);

        return viewHoler;
    }

    @Override
    public void onBindViewHolder(final ViewHolerOne holder, final int position) {
        holder.mTextViewTitle.setText(mTitileDetail.get(position).getmTitle());
        holder.mTextViewDescription.setText(mTitileDetail.get(position).getmDetail());

        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TitleDetail forDeleteTitleDetail = TitleDetail.getInstance();
                forDeleteTitleDetail.removeTitleDetail(position);
                Toast.makeText(view.getContext(), "I am clicked///" + position,
                        Toast.LENGTH_SHORT ).show();
                removeAt(position);
            }
        };

        holder.mButtonDelete.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return mTitileDetail.size();
    }

    public void removeAt(int position){
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mTitileDetail.size());
    }
}
