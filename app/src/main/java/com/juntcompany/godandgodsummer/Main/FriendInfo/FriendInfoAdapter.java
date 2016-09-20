package com.juntcompany.godandgodsummer.Main.FriendInfo;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.Data.User;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineHeaderViewHolder;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineViewHolder;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by EOM on 2016-07-12.
 */
public class FriendInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements FriendInfoHeaderViewHolder.OnItemSelectClickListener, TimelineViewHolder.OnItemSelectClickListener{


    User header;
    List<Timeline> items = new ArrayList<Timeline>();

    public void addHeader(User user){
        this.header = user;
        notifyDataSetChanged();
    }

    public void add(Timeline timeline){
        items.add(timeline);
        notifyDataSetChanged();
    }

    public void addAll(List<Timeline> timelines){
        items.addAll(timelines);
        notifyDataSetChanged();
    }


    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 100;

    //    헤더인지 일반 아이템인지 판별
    @Override
    public int getItemViewType(int position) {
        Log.i("getItemViewType","2번 getItemViewType");
//        2번으로 호출됨
        if(position< 1){
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
                view = inflater.inflate(R.layout.view_friend_info, parent, false);
                FriendInfoHeaderViewHolder holder = new FriendInfoHeaderViewHolder(view);
                holder.setOnItemClickListener(this);
                return holder;
            }
            case VIEW_TYPE_ITEM:{
                view = inflater.inflate(R.layout.view_timeline, parent, false);
                TimelineViewHolder holder = new TimelineViewHolder(view);
                holder.setOnItemClickListener(this);
                return holder;
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //        헤더인경우
        if(position==0){
            ((FriendInfoHeaderViewHolder) holder).setData(header);
        }else {
            int index = position - 1; //헤더 하나 제외
            ((TimelineViewHolder) holder).setData(items.get(index));
        }
    }

    @Override
    public int getItemCount() {
        return items.size() + 1;
    }
    ////////////////////////////////////////클릭 기능
    public interface OnAdapterItemClickListener{
        public void onAdapterItemAddClick(View view, int position);
        public void onAdapterMessageClick(View view, int position);
    }

    OnAdapterItemClickListener mAdapterClickListener;
    public void setOnItemClickListener(OnAdapterItemClickListener listener){
        mAdapterClickListener = listener;
    }



//////////////// 헤더
    @Override
    public void onItemAddClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterItemAddClick(view, position);
        }
    }

    @Override
    public void onItemMessageClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterMessageClick(view, position);
        }
    }
////////////헤더
///////////타임라인
    @Override
    public void onItemLikeClick(View view, int position) {

    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemReplyClick(View view, int position) {

    }

    @Override
    public void onItemReportClick(View view, int position) {

    }

    @Override
    public void onItemMarkClick(View view, int position) {

    }
    ///////////타임라인

}
