package com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.RequestTab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-06.
 */
public class FriendRequestHeaderViewHolder extends RecyclerView.ViewHolder{


    TextView textView;
    public FriendRequestHeaderViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.text_header);

    }

    public void setData(String headerText){
        textView.setText(headerText);
    }
}
