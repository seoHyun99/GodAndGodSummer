package com.juntcompany.godandgodsummer.Main.Toolbar.Search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.Data.User;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineViewHolder;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-08.
 */
public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements SearchViewHolder.OnItemSelectClickListener{

    List<User> items = new ArrayList<User>();

    public void add(User user){
        items.add(user);
        notifyDataSetChanged();
    }

    public void addAll(List<User> users){
        items.addAll(users);
        notifyDataSetChanged();
    }
    public void clear(){
        items.clear();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_search, parent, false);
        SearchViewHolder holder = new SearchViewHolder(view);
        holder.setOnItemClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SearchViewHolder)holder).setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public void removeItem(int position){
        items.remove(position);
        notifyDataSetChanged();
    }

    public User getItem(int position){
        if(position > items.size()){
            return null;
        }
        return items.get(position);
    }


    //////////////////////////////////////////////////////////////////클릭 기능


    public interface OnAdapterItemClickListener{
        public void onAdapterItemDeleteClick(View view, int position);
        public void onAdapterItemClick(View view, int position);
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

    @Override
    public void onItemClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterItemClick(view, position);
        }
    }
}
