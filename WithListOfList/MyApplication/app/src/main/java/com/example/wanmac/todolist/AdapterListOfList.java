package com.example.wanmac.todolist;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wanmac on 7/7/16.
 */
public class AdapterListOfList extends RecyclerView.Adapter<ViewHolderListOfList> {
    List<TitleDetail> mTitleDetaile;

    public AdapterListOfList(List<TitleDetail> argu) {
        mTitleDetaile = argu;
    }

    @Override
    public ViewHolderListOfList onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_list_lists, parent,false);
        ViewHolderListOfList viewHolder = new ViewHolderListOfList(parentView);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolderListOfList holder, final int position) {
        holder.mTVListTitle.setText((CharSequence) mTitleDetaile.get(position).getListName());

        View.OnClickListener onClickListenerDetail = new View.OnClickListener(){
            @Override
            public void onClick(View view) {

               //view.getContext().startActivity(new Intent(  view.getContext(), ListDetailActivity.class  ));

                Intent sendPostionIntent = new Intent(view.getContext(), ListDetailActivity.class);

                sendPostionIntent.putExtra("position", position);
                view.getContext().startActivity(sendPostionIntent);

            }
        };

        View.OnClickListener onClickListenerDeleteItem = new View.OnClickListener(){
          @Override
          public void onClick(View view){
              DaListOfList listOfList = DaListOfList.getInstance();
              listOfList.removeList(position);
              removeAt(position);
          }
        };

        holder.mBuListDetail.setOnClickListener(onClickListenerDetail);
        holder.mButtonDelete.setOnClickListener(onClickListenerDeleteItem);
    }

    @Override
    public int getItemCount() {
        return mTitleDetaile.size();
    }

    public void removeAt(int position){
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mTitleDetaile.size());
    }

}

//buttonListDetail = (Button) findViewById(R.id.buListDetail01);
//Toast.makeText(view.getContext(), "Detail Button Clicked",Toast.LENGTH_SHORT ).show();