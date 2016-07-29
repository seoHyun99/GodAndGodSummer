package com.juntcompany.godandgodsummer.Dialog.WriteReply;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.Reply;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineHeaderViewHolder;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineViewHolder;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by EOM on 2016-07-11.
 */
public class WriteReplyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Timeline header = new Timeline();
    List<Reply> items = new ArrayList<Reply>();

    public void addHeader(Timeline timeline){
        header = timeline;
        notifyDataSetChanged();
    }

    public void add(Reply reply){
        items.add(reply);
        notifyDataSetChanged();
    }

    public void addAll(List<Reply> replies){
        items.addAll(replies);
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 100;

    //    헤더인지 일반 아이템인지 판별
    @Override
    public int getItemViewType(int position) {
        Log.i("getItemViewType","2번 getItemViewType");
//        2번으로 호출됨
        if(position< 1){
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
                view = inflater.inflate(R.layout.view_reply, parent, false);
                WriteReplyViewHolder holder = new WriteReplyViewHolder(view);

                return holder;
            }
            default:{
                view = inflater.inflate(R.layout.view_header_timeline_reply, parent, false);
                WriteReplyTimelineHeaderViewHolder holder = new WriteReplyTimelineHeaderViewHolder(view);

                return holder;
            }
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position==0){

            ((WriteReplyTimelineHeaderViewHolder) holder).setData(header);
        }else {
            int index = position - 1; //헤더 하나 제외
            ((WriteReplyViewHolder) holder).setData(items.get(index));
        }
    }

    @Override
    public int getItemCount() {
        return items.size() + 1;
    }
}
