package com.juntcompany.godandgodsummer.Main.Chatting.ChattingGroupTab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.juntcompany.godandgodsummer.Data.GroupRoom;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-07.
 */
public class ChattingGroupViewHolder extends RecyclerView.ViewHolder{


    public interface OnItemSelectClickListener{
        public void onItemSettingClick(View view, int position);
    }
    OnItemSelectClickListener mItemClickListener;
    public void setOnItemClickListener(OnItemSelectClickListener listener){
        mItemClickListener = listener;
    }


    public ChattingGroupViewHolder(View itemView) {
        super(itemView);


        ImageView imageSetting = (ImageView)itemView.findViewById(R.id.image_friend_setting);
        imageSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener != null){
                    mItemClickListener.onItemSettingClick(view, getAdapterPosition());
                }
            }
        });
    }

    public void setData(GroupRoom groupRoom){

    }
}
