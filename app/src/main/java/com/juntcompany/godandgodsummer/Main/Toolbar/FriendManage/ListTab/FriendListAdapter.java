package com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.ListTab;

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
public class FriendListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements FriendListViewHolder.OnItemSelectClickListener{


    List<Friend> items = new ArrayList<Friend>();

    public void add(Friend friend) {
        items.add(friend);
        notifyDataSetChanged();
    }

    public void addAll(List<Friend> friends) {
        items.addAll(friends);
        notifyDataSetChanged();
    }

    public void removeItem(Friend friend){
        items.remove(friend);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_friend_list, parent, false);;

        FriendListViewHolder holder = new FriendListViewHolder(view);
        holder.setOnItemClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            ((FriendListViewHolder) holder).setData(items.get(position));
    }


    @Override
    public int getItemCount() {
        return items.size() ;
    }

    public Friend getItem(int position){
        if(position<0 || position>= items.size()){
            return null;
        }
        return items.get(position);
    }
    ////////////////////////////클릭 기능

    public interface OnAdapterItemClickListener{
        public void onAdapterItemDeleteClick(View view, int position);
    }

    OnAdapterItemClickListener mAdapterClickListener;
    public void setOnItemClickListener(OnAdapterItemClickListener listener){
        mAdapterClickListener = listener;
    }

    @Override
    public void onItemDeleteClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterItemDeleteClick(view, position);
        }
    }
}
