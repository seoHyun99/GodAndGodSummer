package com.juntcompany.godandgodsummer.MakeGroup;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Checkable;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-18.
 */
public class MakeGroupViewHolder extends RecyclerView.ViewHolder {



    public interface OnItemClickListener{
        public void onItemClick(View view, int position);
    }

    OnItemClickListener mClickListener;
    public void setOnItemCheckListener(OnItemClickListener listener){
        mClickListener = listener;
    }

    View itemView;


    public MakeGroupViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mClickListener!=null){
                    mClickListener.onItemClick(view, getAdapterPosition());
                }
            }
        });
    }

    public void setData(Friend friend){
        if(itemView instanceof CheckFriendItemView){
            ((CheckFriendItemView)itemView).setFriendName(friend.friendName);
        }
    }

    public void setChecked(boolean checked){
        if(itemView instanceof Checkable){
            ((Checkable)itemView).setChecked(checked);
        }
    }

}
