package com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.RequestTab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-06.
 */
public class FriendRecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> header = new ArrayList<String>();
    List<Friend> items = new ArrayList<Friend>();
//    List<Friend> recommendItems = new ArrayList<Friend>();

    public void addHeader(String headerText){
        header.add(headerText);
        notifyDataSetChanged();
    }
    public void add(Friend friend){
        items.add(friend);
        notifyDataSetChanged();
    }
    public void addAll(List<Friend> friends){
        items.addAll(friends);
        notifyDataSetChanged();
    }


    private static final int VIEW_TYPE_HEADER = 50;
    private static final int VIEW_TYPE_ITEM = 100;
    private static final int VIEW_TYPE_RECOMMEND_ITEM = 200;
    @Override
    public int getItemViewType(int position) {
        if (position < 1) {
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
                view = inflater.inflate(R.layout.view_friend_request, parent, false);
                FriendRequestViewHolder holder = new FriendRequestViewHolder(view);
                return holder;
            }
            default: VIEW_TYPE_HEADER:{
                view = inflater.inflate(R.layout.view_header_friend_request, parent, false);
                FriendRequestHeaderViewHolder holder = new FriendRequestHeaderViewHolder(view);
                return holder;
            }
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position==0 ){ //처음과 마지막 인덱스
            ((FriendRequestHeaderViewHolder) holder).setData(header.get(position));
        }else {
            int index = position - 1; //헤더 하나 제외
            ((FriendRequestViewHolder) holder).setData(items.get(index));
        }
    }

    //    이걸 안하면 화면이 안나옴
    @Override
    public int getItemCount() {
        return items.size() + header.size();
    }

}
