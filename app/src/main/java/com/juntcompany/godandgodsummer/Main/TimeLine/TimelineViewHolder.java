package com.juntcompany.godandgodsummer.Main.TimeLine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
    ImageView tlContentPhoto;
    TextView tlUserName;
    TextView tlLikeCount;
    TextView tlReplyCount;
    TableRow tableLike;
    TableRow tableReply;
    Context mContext;

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
        mContext = itemView.getContext();
        tlUserPicture = (ImageView)itemView.findViewById(R.id.timeline_user_picture);
        tlUserName = (TextView)itemView.findViewById(R.id.timeline_user_name);
        tlLikeCount = (TextView)itemView.findViewById(R.id.timeline_user_like_num);
        tlContent = (TextView) itemView.findViewById(R.id.timeline_content);
        tlContentPhoto = (ImageView)itemView.findViewById(R.id.timeline_content_photo);
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
//        if(!TextUtils.isEmpty(timeline.userPhoto)){
//            Log.i("userPhoto", "" + (timeline.userPhoto == null));
//            Glide.with(mContext).load(timeline.userPhoto).into(tlUserPicture);
//        }else {
//            Log.i("userPhoto", "" + (timeline.userPhoto == null));
//            tlUserPicture.setImageResource(R.drawable.default_me);
//        }
        tlUserPicture.setImageResource(R.drawable.profile1);
        Glide.with(mContext).load(timeline.photo);
        tlUserName.setText(timeline.username);
        tlLikeCount.setText(""+timeline.likeCount);
        tlReplyCount.setText(""+timeline.replyCount);
        tlContent.setText(timeline.content);
    }


}
