package com.juntcompany.godandgodsummer.Main.FriendInfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.Data.User;
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

    TextView textUserEmail;
    TextView textUserName;
    ImageView imageUserPhoto;
    TextView textFriendIntroduction;
    TextView textFriendReligion;
    TextView textFriendNum;
    TextView textFriendReligionArea;
    TextView textFriendCity;
    Context mContext;

    public FriendInfoHeaderViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();

        imageUserPhoto = (ImageView)itemView.findViewById(R.id.myProfileUserPicture);
        textUserEmail = (TextView)itemView.findViewById(R.id.myProfileUserEmail);
        textUserName = (TextView)itemView.findViewById(R.id.myProfileUserName);;
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

    public void setData(User user){
        textUserEmail.setText(user.email);
        textUserName.setText(user.name);
        Glide.with(mContext).load(user.userPhoto).into(imageUserPhoto);

        textFriendIntroduction.setText(user.introduction);
        textFriendReligion.setText(user.religion);
        textFriendNum.setText(""+user.friendNum);
        textFriendReligionArea.setText(user.religionArea);
        textFriendCity.setText(user.city);
    }
}
