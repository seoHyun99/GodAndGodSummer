package com.juntcompany.godandgodsummer.Main.Video;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.Video;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-01.
 */
public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements VideoViewHolder.OnItemSelectClickListener{

    List<String> header = new ArrayList<String>();
    List<Video> items = new ArrayList<Video>();

    public void add(Video video){
        items.add(video);
        notifyDataSetChanged();
    }

    public void addAll(List<Video> videos){
        items.addAll(videos);
        notifyDataSetChanged();
    }
    public void addHeader(String title){
        header.add(title);
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 100;
    @Override
    public int getItemViewType(int position) {
        if(position < 1){
            return VIEW_TYPE_HEADER;
        }
        return VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType){
            case VIEW_TYPE_HEADER:{
                view = inflater.inflate(R.layout.view_header, parent, false);
                VideoHeaderViewHolder holder = new VideoHeaderViewHolder(view);
                return holder;
            }
            case VIEW_TYPE_ITEM:{
                view = inflater.inflate(R.layout.view_video, parent, false);
                VideoViewHolder holder = new VideoViewHolder(view);
                holder.setOnItemClickListener(this);
                return holder;
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        switch (getItemViewType(position)){
//            case VIEW_TYPE_ITEM:{
//                int index = position -1;
//                ((VideoViewHolder)holder).setData(items.get(index));
//            }
//            case VIEW_TYPE_HEADER:{
//                ((VideoHeaderViewHolder)holder).setTitle(header.get(0));
//
//            }
//        }
        if(position<1){
            ((VideoHeaderViewHolder)holder).setTitle(header.get(position));
        }else {
            int index = position -1;
            ((VideoViewHolder)holder).setData(items.get(index));
        }

    }

    public Video getItem(int position){
        if (position < 1 || position >= items.size()+ header.size()) {
            return null;
        }
        //헤더 사이즈 1
        return  items.get(position-1);
    }

    @Override
    public int getItemCount() {
        return items.size() + header.size();
    }

    ///////////////////////////클릭기능

    public interface OnAdapterItemClickListener{
        public void onAdapterItemViewClick(View view, int position);
    }

    OnAdapterItemClickListener mAdapterClickListener;
    public void setOnItemClickListener(OnAdapterItemClickListener listener){
        mAdapterClickListener =listener;
    }

    @Override
    public void onItemViewClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterItemViewClick(view, position);
        }
    }
}
