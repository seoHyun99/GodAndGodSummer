package com.juntcompany.godandgodsummer.Main.Chatting.ChattingGroupTab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-07.
 */
public class ChattingGroupHeaderViewHolder extends RecyclerView.ViewHolder{

    public interface OnItemSelectClickListener{
        public void onItemGroupButtonClickListener(View view, int position);
    }

    OnItemSelectClickListener mItemClickListener;
    public void setOnItemClickListener(OnItemSelectClickListener listener){
        mItemClickListener = listener;
    }

    public ChattingGroupHeaderViewHolder(View itemView) {
        super(itemView);


        Button btn = (Button)itemView.findViewById(R.id.button_make_group);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener!=null){
                    mItemClickListener.onItemGroupButtonClickListener(view, getAdapterPosition());
                }
            }
        });

    }

}
