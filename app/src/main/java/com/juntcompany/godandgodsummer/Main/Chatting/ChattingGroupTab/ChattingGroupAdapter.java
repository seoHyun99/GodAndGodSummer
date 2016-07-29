package com.juntcompany.godandgodsummer.Main.Chatting.ChattingGroupTab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.juntcompany.godandgodsummer.Data.GroupRoom;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-07.
 */
public class ChattingGroupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ChattingGroupHeaderViewHolder.OnItemSelectClickListener, ChattingGroupViewHolder.OnItemSelectClickListener{

    List<String> header = new ArrayList<String>();
    List<GroupRoom> items = new ArrayList<GroupRoom>();


    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 100;

    public void add(GroupRoom groupRoom){
        items.add(groupRoom);
        notifyDataSetChanged();
    }
    public void addAll(List<GroupRoom> groupRooms){
        items.addAll(groupRooms);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(position <1){
            return VIEW_TYPE_HEADER;
        }
        return VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;

        switch (viewType){
            case VIEW_TYPE_ITEM:{
                view = inflater.inflate(R.layout.view_chatting_group_item, parent, false);
                ChattingGroupViewHolder holder = new ChattingGroupViewHolder(view);
                holder.setOnItemClickListener(this);
                return holder;
            }
            default:{
                view = inflater.inflate(R.layout.view_chatting_group_header, parent, false);
                ChattingGroupHeaderViewHolder holder = new ChattingGroupHeaderViewHolder(view);
                holder.setOnItemClickListener(this);
                return holder;
            }
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position < 1){
//            헤더뷰 세팅 할거 있으면
        }else {
            int index = position -1;
            ((ChattingGroupViewHolder)holder).setData(items.get(index));
        }
    }

    @Override
    public int getItemCount() {
        return items.size() + 1;
    }




    ///////////////////////////클릭 기능

    public interface OnAdapterItemClickListener{
        public void onAdapterHeaderMakeGroupClick(View view, int position);
        public void onAdapterItemSettingClick(View view, int position);
    }
    OnAdapterItemClickListener mAdapterClickListener;
    public void setOnItemClickListener(OnAdapterItemClickListener listener){
        mAdapterClickListener = listener;
    }

    //////////헤더 클릭
    @Override
    public void onItemGroupButtonClickListener(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterHeaderMakeGroupClick(view, position);
        }
    }

/////아이템 클릭
    @Override
    public void onItemSettingClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterItemSettingClick(view, position);
        }
    }
}
