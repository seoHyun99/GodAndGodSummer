package com.juntcompany.godandgodsummer.Main.Chatting.ChattingListTab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.Chat;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-01.
 */
public class ChattingListViewHolder extends RecyclerView.ViewHolder {

    public interface OnItemSelectClickListener{
        public void onItemClick(View view, int position);
    }

    OnItemSelectClickListener mItemClickListener;
    public void setOnItemClickListener(OnItemSelectClickListener listener){
        mItemClickListener = listener;
    }

    ImageView chatFriendPicture;
    TextView chatFriendName;
    TextView chatLastSpeak;
    TextView chatLastTime;

    public ChattingListViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener!=null){
                    mItemClickListener.onItemClick(view, getAdapterPosition());
                }
            }
        });
        chatFriendPicture = (ImageView)itemView.findViewById(R.id.image_video);
        chatFriendName = (TextView)itemView.findViewById(R.id.text_video_name);
        chatLastSpeak = (TextView)itemView.findViewById(R.id.text_last_speak);
        chatLastTime = (TextView)itemView.findViewById(R.id.text_last_time);
    }

    public void setData(Chat chat){
        chatFriendPicture.setImageResource(R.drawable.profile4);
        chatFriendName.setText(chat.friendName);
        chatLastSpeak.setText(chat.lastSpeak);
        chatLastTime.setText(chat.lastTime);
    }
}
