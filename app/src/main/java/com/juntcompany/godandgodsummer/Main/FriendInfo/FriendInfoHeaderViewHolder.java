package com.juntcompany.godandgodsummer.Main.FriendInfo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-12.
 */
public class FriendInfoHeaderViewHolder extends RecyclerView.ViewHolder{

    public interface OnItemSelectClickListener{
        public void onItemAddClick(View view, int position);
        public void onItemMessageClick(View view, int position);
    }

    OnItemSelectClickListener mItemClickListener;
    public void setOnItemClickListener(OnItemSelectClickListener listener){
        mItemClickListener = listener;
    }

    RelativeLayout btnAddFriend;
    RelativeLayout btnMessage;

    TextView textFriendIntroduction;
    TextView textFriendReligion;
    TextView textFriendNum;
    TextView textFriendReligionArea;
    TextView textFriendCity;

    public FriendInfoHeaderViewHolder(View itemView) {
        super(itemView);
        textFriendIntroduction = (TextView)itemView.findViewById(R.id.myProfileComment); //자기 소개
        textFriendReligion = (TextView)itemView.findViewById(R.id.myProfileReligion);
        textFriendNum = (TextView)itemView.findViewById(R.id.myProfileFriendNum);
        textFriendReligionArea = (TextView)itemView.findViewById(R.id.myProfileReligionHome);
        textFriendCity = (TextView)itemView.findViewById(R.id.myProfileCity);
        btnAddFriend = (RelativeLayout)itemView.findViewById(R.id.relative_add_friend);
        btnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener!=null){
                    mItemClickListener.onItemAddClick(view, getAdapterPosition());
                }
            }
        });
        btnMessage = (RelativeLayout)itemView.findViewById(R.id.relative_message);
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener!=null){
                    mItemClickListener.onItemMessageClick(view, getAdapterPosition());
                }
            }
        });
    }

    public void setData(Friend friend){
        textFriendIntroduction.setText(friend.friendIntroduction);
        textFriendReligion.setText(friend.friendReligion);
        textFriendNum.setText(""+friend.friendNum);
        textFriendReligionArea.setText(friend.friendReligionArea);
        textFriendCity.setText(friend.friendCity);
    }
}
