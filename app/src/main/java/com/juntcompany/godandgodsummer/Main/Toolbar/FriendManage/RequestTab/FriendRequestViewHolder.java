package com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.RequestTab;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.R;

import java.sql.BatchUpdateException;

/**
 * Created by EOM on 2016-07-06.
 */
public class FriendRequestViewHolder extends RecyclerView.ViewHolder{


    public interface OnItemSelectClickListener{
        public void onItemConfirmClick(View view, int position);
        public void onItemDeleteClick(View view, int position);
    }

    OnItemSelectClickListener mItemClickListener;
    public void setOnItemClickListener(OnItemSelectClickListener listener){
        mItemClickListener = listener;
    }


    TextView textFriendName;
    TextView textFriendReligion;
    Button btnConfirm;
    Button btnDelete;
    public FriendRequestViewHolder(View itemView) {
        super(itemView);
        textFriendName = (TextView)itemView.findViewById(R.id.text_friend_name);
        textFriendReligion =(TextView)itemView.findViewById(R.id.text_friend_religion);
        btnConfirm = (Button)itemView.findViewById(R.id.button_confirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener !=null){
                    mItemClickListener.onItemConfirmClick(view, getAdapterPosition());
                    Log.i("click", "confirm viewholder button");
                }
            }
        });
        btnDelete = (Button)itemView.findViewById(R.id.button_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener !=null){
                    mItemClickListener.onItemDeleteClick(view, getAdapterPosition());
                    Log.i("click", "delete viewholder button");
                }
            }
        });
    }

    public void setData(Friend friend){
        textFriendName.setText(friend.friendName);
        textFriendReligion.setText(friend.friendReligion);
    }
}
