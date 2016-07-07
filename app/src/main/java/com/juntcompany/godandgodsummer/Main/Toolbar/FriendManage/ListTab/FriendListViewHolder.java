package com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.ListTab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by Jiseong on 2016-05-12.
 */
public class FriendListViewHolder extends RecyclerView.ViewHolder {


    ImageView friendListFriendPicture;
    TextView friendListFriendName;
    TextView friendListFriendArea;
    TextView friendListFriendReligion;

    public FriendListViewHolder(View itemView) {
        super(itemView);
        friendListFriendPicture = (ImageView) itemView.findViewById(R.id.friendListFriendPicture);
        friendListFriendName = (TextView) itemView.findViewById(R.id.friendListFriendName);
        friendListFriendArea = (TextView) itemView.findViewById(R.id.friendListFriendArea);
        friendListFriendReligion = (TextView) itemView.findViewById(R.id.friendListFriendReligion);
    }

    public void setData(Friend friend) {


    }

}