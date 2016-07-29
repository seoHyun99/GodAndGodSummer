package com.juntcompany.godandgodsummer.Main.TimeLine;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-06-30.
 */
public class TimelineViewHolder extends RecyclerView.ViewHolder{

//    버튼에 리스너 달기 위해 interface 필요
    public interface OnItemSelectClickListener {
        public void onItemLikeClick(View view, int position);
        public void onItemClick(View view, int position);
        public void onItemReplyClick(View view, int position);
        public void onItemReportClick(View view, int position);
        public void onItemMarkClick(View view, int position);
//    이 인터페이스를 implement 하는 곳에서는 onItemLikeClick 를 재정의 해야함
    }


    OnItemSelectClickListener mAdapterClickListener;  // 위 인터페이스 객체
//    holer.setOnItemclickListener 로 쓰임
    public void setOnItemClickListener(OnItemSelectClickListener listener){
        mAdapterClickListener = listener; //위 인터페이스 객체가 저장됨
}

    ImageView tlUserPicture;
    TextView tlContent;
    TextView tlUserName;
    TextView tlLikeCount;
    TextView tlReplyCount;
    TableRow tableLike;
    TableRow tableReply;

    public TimelineViewHolder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAdapterClickListener!=null){
                    mAdapterClickListener.onItemClick(itemView, getAdapterPosition());
                    Log.i("click", "click total itemview");
                }
            }
        });
        tlUserPicture = (ImageView)itemView.findViewById(R.id.timeline_user_picture);
        tlUserName = (TextView)itemView.findViewById(R.id.timeline_user_name);
        tlLikeCount = (TextView)itemView.findViewById(R.id.timeline_user_like_num);
        tlContent = (TextView) itemView.findViewById(R.id.timeline_content);
        tlReplyCount = (TextView)itemView.findViewById(R.id.timeline_reply_count);
        tableLike = (TableRow)itemView.findViewById(R.id.likeBox);
        tableReply = (TableRow)itemView.findViewById(R.id.replyBox);
        Button btnReport= (Button)itemView.findViewById(R.id.button_report);
        ImageView timelineMark = (ImageView)itemView.findViewById(R.id.timeline_mark);
        tableLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAdapterClickListener!=null){
                    mAdapterClickListener.onItemLikeClick(itemView, getAdapterPosition());
                    Log.i("click", "click like button");
                }
            }
        });
        tableReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAdapterClickListener!=null) {
                    mAdapterClickListener.onItemReplyClick(itemView, getAdapterPosition());
                }
            }
        });
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAdapterClickListener!=null) {
                    mAdapterClickListener.onItemReportClick(itemView, getAdapterPosition());
                }
            }
        });
        timelineMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAdapterClickListener!=null){
                    mAdapterClickListener.onItemMarkClick(itemView, getAdapterPosition());
                }
            }
        });
    }

//    실질적으로 데이터가 들어가는 부분
    public void setData(Timeline timeline){
        tlUserPicture.setImageResource(R.drawable.profile2);
        tlUserName.setText(timeline.tlUsername);
        tlLikeCount.setText(""+timeline.tlLikeCount);
        tlReplyCount.setText(""+timeline.tlReplyCount);
        tlContent.setText(timeline.tlContent);
    }


}
