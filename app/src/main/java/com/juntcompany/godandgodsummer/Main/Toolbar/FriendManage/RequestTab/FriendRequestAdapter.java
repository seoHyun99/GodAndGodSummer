package com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.RequestTab;

import android.support.v4.text.TextUtilsCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.Data.SectionHeader;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-06.
 */
public class FriendRequestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements FriendRequestViewHolder.OnItemSelectClickListener{

//    List<String> header = new ArrayList<String>();
    List<SectionHeader> items = new ArrayList<SectionHeader>();
//    List<Friend> recommendItems = new ArrayList<Friend>();



    public void addFirstSection(String sectionHeaderText, List<Friend> friends){
        Log.i("section", "section first created");
        SectionHeader sectionHeader= new SectionHeader();
        sectionHeader.sectionName = sectionHeaderText;
          items.add(sectionHeader);
          sectionHeader.friends.addAll(friends);
          notifyDataSetChanged();
    }
    public void addSecondSection(String sectionHeaderText, List<Friend> friends){
        SectionHeader sectionHeader= new SectionHeader();
        sectionHeader.sectionName = sectionHeaderText;
        items.add(sectionHeader);
        sectionHeader.friends.addAll(friends);
        notifyDataSetChanged();
    }
//
//    public void addHeader(String headerText){
//        header.add(headerText);
//        notifyDataSetChanged();
//    }
//    public void add(Friend friend){
//        items.add(friend);
//        notifyDataSetChanged();
//    }
//    public void addAll(List<Friend> friends){
//        items.addAll(friends);
//        notifyDataSetChanged();
//    }


    private static final int VIEW_TYPE_HEADER = 50;
    private static final int VIEW_TYPE_REQUEST_ITEM = 100;
    private static final int VIEW_TYPE_RECOMMEND_ITEM = 200;
    @Override
    public int getItemViewType(int position) {
        for(int i =0; i< items.size(); i++) {
            SectionHeader sectionHeader = items.get(i);
            if (position < 1) {
                return VIEW_TYPE_HEADER;
            }
//            포지션이 0이 아니면
            position--;
            int childCount = sectionHeader.friends.size();
            if (position < childCount) {
                return VIEW_TYPE_REQUEST_ITEM;
            }
            position-=childCount;
            //다음 섹션으로 넘어가기 위해 필요
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType){
            case VIEW_TYPE_REQUEST_ITEM:{
                view = inflater.inflate(R.layout.view_friend_request, parent, false);
                FriendRequestViewHolder holder = new FriendRequestViewHolder(view);
                holder.setOnItemClickListener(this);
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
        for(int i=0; i<items.size(); i++){
            SectionHeader s = items.get(i);
            if(position < 1){
                ((FriendRequestHeaderViewHolder)holder).setData(s);
                return;
            }
            //헤더가 아닌 경우
            position--;
            int childCount = s.friends.size();
            if(position< childCount){
                Friend friend = s.friends.get(position);
                ((FriendRequestViewHolder)holder).setData(friend);
                return;
            }
            position -=childCount;
        }

    }

//    이걸 안하면 화면이 안나옴
    @Override
    public int getItemCount() {
        int totalCount =0;
        for(SectionHeader s: items){
            totalCount += (1 + s.friends.size()); //1은 헤더
        }
        return totalCount;
    }

    public Friend getItem(int position){
        for(int i=0; i<items.size(); i++) {
            SectionHeader s = items.get(i);
            if (position < 1) {

                return null;
            }
            position--;
            int childCount = s.friends.size();
            if (position < childCount) {
                Friend friend = s.friends.get(position);

                return friend;
            }
            position -= childCount;
        }
        return null;
    }

    public void removeItem(int position){
        for(int i=0; i<items.size(); i++){
            SectionHeader s = items.get(i);
            if(position < 1){

                return;
            }
            //헤더가 아닌 경우
            position--;
            int childCount = s.friends.size();
            if(position< childCount){
                s.friends.remove(position);
                notifyDataSetChanged();
                return;
            }
            position -=childCount;
        }
    }



    //////////////////////////////////////////클릭기능
    public interface OnAdapterItemClickListener{
        public void onAdapterConfirmClick(View view, int position);
        public void onAdapterDeleteClick(View view, int position);
    }

    OnAdapterItemClickListener mAdapterClickListener;
    public void setOnItemClickListener(OnAdapterItemClickListener listener){
        mAdapterClickListener = listener;
    }

///////////////////viewHolder 재정의
    @Override
    public void onItemConfirmClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterConfirmClick(view, position);
        }
    }

    @Override
    public void onItemDeleteClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterDeleteClick(view, position);
        }
    }
}
