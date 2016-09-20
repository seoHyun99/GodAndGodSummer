package com.juntcompany.godandgodsummer.Main.TimeLine;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.MyProfile;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.R;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-06-30.
 */
public class TimelineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements TimelineViewHolder.OnItemSelectClickListener, TimelineHeaderViewHolder.OnItemClickListener{

    List<Timeline> items = new ArrayList<Timeline>();
    List<MyProfile> header = new ArrayList<MyProfile>();

    public void add(Timeline data) {
        items.add(data);
        notifyDataSetChanged();
    }


    public void addAll(List<Timeline> timelines) {
        items.addAll(timelines);
        notifyDataSetChanged();
    }

    public void addHeader(MyProfile myProfile){
        header.add(myProfile);
        notifyDataSetChanged();
    }

    public void clear(){
        items.clear();
    }

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 100;

//    헤더인지 일반 아이템인지 판별
    @Override
    public int getItemViewType(int position) {
        Log.i("getItemViewType","2번 getItemViewType");
//        2번으로 호출됨
        if(position< header.size()){
            return VIEW_TYPE_HEADER;
        }
        return VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("oncreateViewHolder","3번 oncreateViewHolder");
//        3번으로 호출됨
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType){
            case VIEW_TYPE_ITEM:{
                view = inflater.inflate(R.layout.view_timeline, parent, false);
                TimelineViewHolder holder = new TimelineViewHolder(view);
                holder.setOnItemClickListener(this);

                //        클릭하려면 holer를 만들어야 함
                return holder;
            }default:{
                view = inflater.inflate(R.layout.view_header_timeline, parent, false);
                TimelineHeaderViewHolder holder = new TimelineHeaderViewHolder(view);
                holder.setOnItemClickListener(this);
                return holder;
            }
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.i("onBindViewHolder","1번 onBindViewHolder");
//        1번으로 호출됨
//        헤더인경우
        if(position==0){
            ((TimelineHeaderViewHolder) holder).setData(header.get(position));
        }else {
            int index = position - 1; //헤더 하나 제외
            ((TimelineViewHolder) holder).setData(items.get(index));
        }
    }

    @Override
    public int getItemCount() {
        return items.size() + header.size();
    }

    public Timeline getItem(int position){
//        헤더 사이즈가 1이여서 1
        Log.i("getItem", "getItem 메소드 index : " + position);
        if (position < 1 || position >= items.size()+ header.size()) {
            return null;
        }
//       header 가 하나이므로 -1 을 한다.
        return items.get(position-1);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////클릭 기능



    public interface OnAdapterItemClickListener {
        public void onAdapterHeaderClick(View view, int position);
        public void onAdapterItemLikeClick(View view, int position);
        public void onAdapterItemViewClick(View view, int position);
        public void onAdapterItemReportClick(View view, int position);
        public void onAdapterItemReplyClick(View view, int position);
        public void onAdapterItemMarkClick(View view, int position);
    }

    OnAdapterItemClickListener mAdapterClickListener;
    public void setOnItemClickListener(OnAdapterItemClickListener listener){
        mAdapterClickListener = listener;
    }

//    TimeLineViewHolder 에서 만든 인터페이스 정의
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
            mAdapterClickListener.onAdapterItemMarkClick(view, position);
        }
    }

    @Override
    public void onAdapterItemHeaderClick(View view, int position) {
        if(mAdapterClickListener!=null){
            mAdapterClickListener.onAdapterHeaderClick(view, position);
        }
    }

}
