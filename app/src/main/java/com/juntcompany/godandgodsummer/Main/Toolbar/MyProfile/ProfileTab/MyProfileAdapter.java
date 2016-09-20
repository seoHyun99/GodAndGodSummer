package com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.ProfileTab;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.MyProfile;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.Data.User;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineHeaderViewHolder;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineViewHolder;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-05.
 */
public class MyProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MyProfileHeaderViewHolder.OnItemSelectClickListener, TimelineViewHolder.OnItemSelectClickListener, TimelineHeaderViewHolder.OnItemClickListener{

    User header; // 헤더 두개 임
    List<MyProfile> headerWriteTimeline = new ArrayList<MyProfile>();

    List<Timeline> items = new ArrayList<Timeline>();

    public void add(Timeline timeline) {
        items.add(timeline);
        notifyDataSetChanged();
    }

    public void addWriteHeader(MyProfile profile){ // 타임라인에 글 적기 위한 아이템
        headerWriteTimeline.add(profile);
        notifyDataSetChanged();
    }
    public void addProfileHeader(User user){ //프로필 정보 관련 헤더 첫번째 인덱스
        this.header = user;
        notifyDataSetChanged();
    }

    public void addChangeProfileHeader(User user){ //이미지가 바뀌면 쓸려고 만듬
//        header.add(0, user);
        notifyDataSetChanged();
    }



    public void addAll(List<Timeline> timelines) {
        items.addAll(timelines);
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_PROFILE_HEADER = 0;
    private static final int VIEW_TYPE_HEADER = 50;
    private static final int VIEW_TYPE_ITEM = 100;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;

        switch (viewType) {
            case VIEW_TYPE_PROFILE_HEADER: {
                view = inflater.inflate(R.layout.view_my_profile_header, parent, false);
                MyProfileHeaderViewHolder holder = new MyProfileHeaderViewHolder(view);
                holder.setOnItemClickListener(this);
                return holder;
            }
            case VIEW_TYPE_HEADER:{
//                timline 프래그먼트에서 사용한 헤더 재사용
                view = inflater.inflate(R.layout.view_header_timeline, parent, false);
                TimelineHeaderViewHolder holder = new TimelineHeaderViewHolder(view);
                holder.setOnItemClickListener(this);
                return holder;
            }
            default:
//                timline 프래그먼트에서 사용한 뷰 재사용
                view = inflater.inflate(R.layout.view_timeline, parent, false);
                TimelineViewHolder holder = new TimelineViewHolder(view);
                holder.setOnItemClickListener(this);
                return holder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)){
            case VIEW_TYPE_PROFILE_HEADER:{
                Log.i("user adapter", this.header.email + this.header.toString());
                ((MyProfileHeaderViewHolder) holder).setData(this.header);

            }
            case VIEW_TYPE_HEADER:{

            }
            case VIEW_TYPE_ITEM:{

            }
        }

//        if (position == 0) {
//            //헤더
//            ((MyProfileHeaderViewHolder) holder).setData(header);
//        }else if(position == 1){
////            타임라인 헤더뷰 재사용
//            ((TimelineHeaderViewHolder) holder).setData(headerWriteTimeline.get(position));
//        }else {
//            int index = position - 2; //헤더가 두개이므로
////            타임라인 item viewHolder 재사용
//            ((TimelineViewHolder) holder).setData(items.get(index));
//        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position < 1) {
            return VIEW_TYPE_PROFILE_HEADER; // 프로필 정보
        }else if(position < 2){
            return VIEW_TYPE_HEADER;
        }
        return VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return items.size() + 2; // 헤더 포지션 2 더함
    }

    public User getFirstHeaderItem(int position){
        if(position ==0){
            return header; // 0번 인덱스
        }
        return null;
    }

    /////////////////////////////////////클릭 기능

    public interface OnAdapterItemClickListener{
        //헤더 프로필 클릭
        public void onAdapterHeaderProfileCorrectClick(View view, int position);
        public void onAdapterHeaderProfilePictureClick(View view, int position);
        public void onAdapterHeaderClick(View view, int position); //타임라인 헤더 클릭
        //타임라인 안에 클릭
        public void onAdapterItemLikeClick(View view, int position);
        public void onAdapterItemViewClick(View view, int position); //타임라인 전체 클릭
        public void onAdapterItemReportClick(View view, int position);
        public void onAdapterItemReplyClick(View view, int position);
        public void onAdapterItemMarkClick(View view, int position);
    }
    OnAdapterItemClickListener mAdapterClickListener;
    public void setOnItemClickListener(OnAdapterItemClickListener listener){
        mAdapterClickListener = listener;
    }
/////헤더 프로필 클릭
    @Override
    public void onItemCorrectClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterHeaderProfileCorrectClick(view, position);
        }
    }

    @Override
    public void onItemPictureClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterHeaderProfilePictureClick(view, position);
        }
    }
//////헤더 클릭
    @Override
    public void onAdapterItemHeaderClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterHeaderClick(view, position);
        }
    }

    @Override
    public void onItemLikeClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterItemLikeClick(view, position);
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterItemViewClick(view, position);
        }
    }

    @Override
    public void onItemReplyClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterItemReplyClick(view, position);
        }
    }

    @Override
    public void onItemReportClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterItemReportClick(view, position);
        }
    }

    @Override
    public void onItemMarkClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterHeaderProfileCorrectClick(view, position);
        }
    }


}
