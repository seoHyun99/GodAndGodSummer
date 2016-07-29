package com.juntcompany.godandgodsummer.Main.Toolbar.Marked;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.MyProfile;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineViewHolder;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-08.
 */
public class MarkedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Timeline> items = new ArrayList<Timeline>();

    public void add(Timeline data) {
        items.add(data);
        notifyDataSetChanged();
    }


    public void addAll(List<Timeline> timelines) {
        items.addAll(timelines);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
           View view = inflater.inflate(R.layout.view_timeline, parent, false);
            TimelineViewHolder holder = new TimelineViewHolder(view);
//            holder.setOnItemClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TimelineViewHolder) holder).setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
