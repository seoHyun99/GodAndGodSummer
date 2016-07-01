package com.juntcompany.godandgodsummer.Main.Video;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.Video;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-01.
 */
public class VideoViewHolder extends RecyclerView.ViewHolder {


    ImageView videoThumbnail;
    TextView videoName;
    TextView videoOwner;

    public VideoViewHolder(View itemView) {
        super(itemView);
        videoThumbnail = (ImageView)itemView.findViewById(R.id.image_video_thumbnail);
        videoName =(TextView)itemView.findViewById(R.id.text_video_name);
        videoOwner = (TextView)itemView.findViewById(R.id.text_video_owner);
    }

    public void setData(Video video){
        videoThumbnail.setImageResource(R.drawable.profile6);
        videoName.setText(video.videoName);
        videoOwner.setText(video.videoOwner);
    }
}
