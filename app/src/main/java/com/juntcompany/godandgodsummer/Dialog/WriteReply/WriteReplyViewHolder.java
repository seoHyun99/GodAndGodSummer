package com.juntcompany.godandgodsummer.Dialog.WriteReply;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.juntcompany.godandgodsummer.Data.Reply;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-11.
 */
public class WriteReplyViewHolder extends RecyclerView.ViewHolder {

    TextView textReplyUserName;
    TextView testReplyContent;
    TextView textReplyTime;
    ImageView imageReplyProfile;
    Context mContext;

    public WriteReplyViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        textReplyUserName = (TextView)itemView.findViewById(R.id.text_user_name);
        testReplyContent = (TextView)itemView.findViewById(R.id.text_reply_content);
        textReplyTime = (TextView)itemView.findViewById(R.id.text_reply_time);
        imageReplyProfile = (ImageView) itemView.findViewById(R.id.image_reply_profile);


    }

    public void setData(Reply reply){
        testReplyContent.setText(reply.replyContent);
        textReplyUserName.setText(reply.replyUsername);
        textReplyTime.setText(reply.replyUpdateTime);
        Glide.with(mContext).load(reply.replyUserImage).into(imageReplyProfile);
    }
}
