package com.juntcompany.godandgodsummer.Main.Activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.ActivityLog;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-07.
 */
public class ActivityLogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    List<ActivityLog> items = new ArrayList<ActivityLog>();

    public void add(ActivityLog activityLog){
        items.add(activityLog);
        notifyDataSetChanged();
    }

    public void addAll(List<ActivityLog> activityLogs){
        items.addAll(activityLogs);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_activity_log, parent, false);
        ActivityLogViewHolder holder = new ActivityLogViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ActivityLogViewHolder)holder).setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
