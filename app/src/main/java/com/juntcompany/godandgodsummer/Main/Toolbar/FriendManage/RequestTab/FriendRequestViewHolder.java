package com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.RequestTab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-06.
 */
public class FriendRequestViewHolder extends RecyclerView.ViewHolder{

    TextView textFriendName;
    public FriendRequestViewHolder(View itemView) {
        super(itemView);
        textFriendName = (TextView)itemView.findViewById(R.id.text_friend_name);
    }

    public void setData(Friend friend){
        textFriendName.setText(friend.friendName);
    }
}
