package com.juntcompany.godandgodsummer.MakeGroup;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.Data.GroupRoom;
import com.juntcompany.godandgodsummer.R;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-18.
 */
public class MakeGroupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MakeGroupViewHolder.OnItemClickListener{

    GroupRoom header = new GroupRoom();

    List<Friend> items = new ArrayList<Friend>();
    SparseBooleanArray checkedItems = new SparseBooleanArray();

    public void add(Friend friend){
        items.add(friend);
        notifyDataSetChanged();
    }

    public void addAll(List<Friend> friends){
        items.addAll(friends);
        notifyDataSetChanged();
    }

    public void addHeader(GroupRoom groupRoom){
        this.header = groupRoom;
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 100;

    @Override
    public int getItemViewType(int position) {
       if(position<1){
           return VIEW_TYPE_HEADER;
       }
        return VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType){
            case VIEW_TYPE_ITEM: {
                MakeGroupViewHolder holder = new MakeGroupViewHolder(new CheckFriendItemView(parent.getContext()));
                holder.setOnItemCheckListener(this);
                return holder;

            }
            case VIEW_TYPE_HEADER: {
                view = inflater.inflate(R.layout.view_header_make_group, parent, false);
                MakeGroupHeaderViewHolder holder = new MakeGroupHeaderViewHolder(view);

                return holder;
            }
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position<1){
            ((MakeGroupHeaderViewHolder)holder).setData(header);
        }else {
            int index = position -1;
            ((MakeGroupViewHolder)holder).setData(items.get(index));
            ((MakeGroupViewHolder) holder).setChecked(checkedItems.get(index));
            Log.i("position", "onBindViewHolder position-1 : " + index + ", position : " + position);

        }
    }

    @Override
    public int getItemCount() {
        return items.size() +1;
    }

    public SparseBooleanArray getCheckedItems(){
        return checkedItems;
    } //getCjeckedItemsTrueCount()에서 사용, checkedItems 의 true 값 개수를 구하기 위해
    public int getCheckedItemsTrueCount(){
        int count = 0;
        Log.i("checkedItems", "checkedItems :" + getCheckedItems());
        for(int i =0; i < getCheckedItems().size(); i++ ){
            if(getCheckedItems().get(i) == true){
                Log.i("checkedItems", "checkedItems true:" + getCheckedItems());
                count ++;
            }
        }
        Log.i("count", "" + count);
        return count;
    }


    ///////////////////////////클릭 기능

    public interface  OnAdapterItemClickListener{
        public void onAdapterItemCheckClick(View view, int position);
    }

    OnAdapterItemClickListener mAdapterListener;
    public void setOnItemClickListener(OnAdapterItemClickListener listener){
        mAdapterListener = listener;
    }

    @Override
    public void onItemClick(View view, int position) {
        //체크한거를 모아둠
        if(mAdapterListener!=null){
            int index = position -1; //헤더 제외

//            Log.i("position", "onItemClick" + position);
            boolean oldChecked = checkedItems.get(index );
            Log.i("oldChecked", "oldChecked : " + oldChecked + ", index : " + index );
            checkedItems.put(index, !oldChecked);
            notifyDataSetChanged();
            mAdapterListener.onAdapterItemCheckClick(view, index); //어댑터에서 리스너를 반응하도록 설정, checkedItems에 값을 넣은 뒤에 이 코드를 둬야 함
        }

    }
}
