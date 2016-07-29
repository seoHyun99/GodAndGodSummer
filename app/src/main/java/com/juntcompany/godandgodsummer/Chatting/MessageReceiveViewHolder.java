package com.juntcompany.godandgodsummer.Chatting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-14.
 */
public class MessageReceiveViewHolder extends RecyclerView.ViewHolder{


     TextView mUsernameView;
     TextView mMessageView;

    public MessageReceiveViewHolder(View itemView) {
        super(itemView);
        mUsernameView = (TextView) itemView.findViewById(R.id.username);
        mMessageView = (TextView) itemView.findViewById(R.id.message);
    }

    public void setData(String username, String message){
        mUsernameView.setText(username);
        mMessageView.setText(message);
    }
}
