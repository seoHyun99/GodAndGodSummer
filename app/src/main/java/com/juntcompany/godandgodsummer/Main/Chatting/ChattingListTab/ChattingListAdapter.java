package com.juntcompany.godandgodsummer.Main.Chatting.ChattingListTab;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.Chat;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-01.
 */
public class ChattingListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ChattingListViewHolder.OnItemSelectClickListener{
    List<Chat> items = new ArrayList<Chat>();

    public void add(Chat data){
        items.add(data);
        notifyDataSetChanged();
    }

    public void addAll(List<Chat> chats) {
        items.addAll(chats);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       View view = inflater.inflate(R.layout.view_chatting_list, parent, false);
        ChattingListViewHolder holder = new ChattingListViewHolder(view);
        holder.setOnItemClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChattingListViewHolder)holder).setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


//    클릭할때 쓰려고 만듬
    public Chat getItem(int position){
        Log.i("getItem", "getItem 메소드 index : " + position);
        if (position < 0 || position >= items.size()) {
            return null;
        }
        return items.get(position);
    }
////////////////////////////////////////클릭 기능

    public interface OnAdapterItemClickListener{
        public void onAdapterItemViewClick(View view, int position);
    }

    OnAdapterItemClickListener mAdapterClickListener;
    public void setOnItemClickListener(OnAdapterItemClickListener listener){
        mAdapterClickListener = listener;
    }

    /////////////////// chattinglistviewholer 에서 재정의 한거
    @Override
    public void onItemClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterItemViewClick(view, position);
        }
    }
}
