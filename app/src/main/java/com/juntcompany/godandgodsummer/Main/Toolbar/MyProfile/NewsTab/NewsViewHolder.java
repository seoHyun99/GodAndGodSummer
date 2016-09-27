package com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.NewsTab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.News;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-15.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder {

    TextView textNewsName, textNewsContent,textNewsContentSecond, textNewsTime;
    public NewsViewHolder(View itemView) {
        super(itemView);

        textNewsName = (TextView)itemView.findViewById(R.id.text_news_name);
        textNewsContent = (TextView)itemView.findViewById(R.id.text_news_content)  ;
        textNewsContentSecond = (TextView)itemView.findViewById(R.id.text_news_content_second);
        textNewsTime = (TextView)itemView.findViewById(R.id.text_news_time);

    }

    public void setData(News news){

        textNewsName.setText(news.eventName);
        textNewsContent.setText(news.eventContent);
        textNewsContentSecond.setText(news.eventContentSecond);
        textNewsTime.setText(news.eventTime);
    }
}
