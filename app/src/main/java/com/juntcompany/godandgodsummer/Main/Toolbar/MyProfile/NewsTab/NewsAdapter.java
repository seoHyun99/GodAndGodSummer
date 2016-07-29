package com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.NewsTab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.News;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-15.
 */
public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<News> items = new ArrayList<News>();


    public void add(News news){
        items.add(news);
        notifyDataSetChanged();
    }

    public void addAll(List<News> newses){
        items.addAll(newses);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_news, parent, false);
        NewsViewHolder holder = new NewsViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NewsViewHolder)holder).setData();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
