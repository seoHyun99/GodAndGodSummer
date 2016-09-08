package com.juntcompany.godandgodsummer.Dialog.WriteReply;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-11.
 */
public class WriteReplyTimelineHeaderViewHolder extends RecyclerView.ViewHolder{



    ImageView tlUserPhoto;
    TextView tlUsername;
    TextView tlLikeCount;
    TextView tlReplyCount;
    TextView tlContent;
    ImageView tlContentPhoto;
    public WriteReplyTimelineHeaderViewHolder(View itemView) {
        super(itemView);


        tlUserPhoto = (ImageView)itemView.findViewById(R.id.timeline_user_picture);
        tlUsername = (TextView)itemView.findViewById(R.id.timeline_user_name);
        tlLikeCount = (TextView)itemView.findViewById(R.id.timeline_user_like_num);
        tlReplyCount = (TextView)itemView.findViewById(R.id.timeline_reply_count);
        tlContent = (TextView)itemView.findViewById(R.id.timeline_content);
        tlContentPhoto = (ImageView)itemView.findViewById(R.id.timeline_content_photo);

    }

    public void setData(Timeline timeline){
        tlContent.setText(timeline.content);
    }
}
