package com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.ProfileTab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.MyProfile;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineHeaderViewHolder;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineViewHolder;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-05.
 */
public class MyProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<MyProfile> header = new ArrayList<MyProfile>();
    List<Timeline> items = new ArrayList<Timeline>();

    public void add(Timeline timeline) {
        items.add(timeline);
        notifyDataSetChanged();
    }

    public void addHeader(MyProfile myProfile){
        header.add(myProfile);
        notifyDataSetChanged();
    }
    public void addProfileHeader(MyProfile myProfile){
        header.add(myProfile);
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
//                holder.setOnItemClickListener(this);
                return holder;
            }
            case VIEW_TYPE_HEADER:{
//                timline 프래그먼트에서 사용한 헤더 재사용
                view = inflater.inflate(R.layout.view_header_timeline, parent, false);
                TimelineHeaderViewHolder holder = new TimelineHeaderViewHolder(view);
                return holder;
            }
            default:
//                timline 프래그먼트에서 사용한 뷰 재사용
                view = inflater.inflate(R.layout.view_timeline, parent, false);
                TimelineViewHolder holder = new TimelineViewHolder(view);

                return holder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            //헤더
            ((MyProfileHeaderViewHolder) holder).setData(header.get(position));
        }else if(position == 1){
//            타임라인 헤더뷰 재사용
            ((TimelineHeaderViewHolder) holder).setData(header.get(position));
        }else {
            int index = position - 2; //헤더가 두개이므로
//            타임라인 item viewHolder 재사용
            ((TimelineViewHolder) holder).setData(items.get(index));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 1) {
            return VIEW_TYPE_PROFILE_HEADER;
        }else if(position < 2){
            return VIEW_TYPE_HEADER;
        }
        return VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return items.size() + 2; // 헤더 포지션 2 더함
    }
}
