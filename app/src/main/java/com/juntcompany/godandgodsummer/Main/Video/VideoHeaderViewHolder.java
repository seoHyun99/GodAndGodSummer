package com.juntcompany.godandgodsummer.Main.Video;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-19.
 */
public class VideoHeaderViewHolder extends RecyclerView.ViewHolder{


    TextView textTitle;
    public VideoHeaderViewHolder(View itemView) {
        super(itemView);
        textTitle = (TextView)itemView.findViewById(R.id.text_title);
    }

    public void setTitle(String title){
        textTitle.setText(title);
    }
}
