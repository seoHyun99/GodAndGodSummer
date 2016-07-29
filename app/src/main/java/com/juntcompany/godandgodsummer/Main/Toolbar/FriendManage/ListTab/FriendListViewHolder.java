package com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.ListTab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by Jiseong on 2016-05-12.
 */
public class FriendListViewHolder extends RecyclerView.ViewHolder {


    public interface OnItemSelectClickListener{
        public void onItemDeleteClick(View view, int position);
    }

    OnItemSelectClickListener mItemClickListener;
    public void setOnItemClickListener(OnItemSelectClickListener listener){
        mItemClickListener = listener;
    }



    ImageView friendListFriendPicture;
    TextView friendListFriendName;
    TextView friendListFriendCity;
    TextView friendListFriendReligion;
    Button btnDelete;
    public FriendListViewHolder(View itemView) {
        super(itemView);
        friendListFriendPicture = (ImageView) itemView.findViewById(R.id.friendListFriendPicture);
        friendListFriendName = (TextView) itemView.findViewById(R.id.friendListFriendName);
        friendListFriendCity = (TextView) itemView.findViewById(R.id.friendListFriendArea);
        friendListFriendReligion = (TextView) itemView.findViewById(R.id.friendListFriendReligion);
        btnDelete = (Button)itemView.findViewById(R.id.button_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener!=null){
                    mItemClickListener.onItemDeleteClick(view, getAdapterPosition());
                }
            }
        });

    }

    public void setData(Friend friend) {
        friendListFriendName.setText(friend.friendName);
        friendListFriendCity.setText(friend.friendCity);
        friendListFriendReligion.setText(friend.friendReligion);

    }

}