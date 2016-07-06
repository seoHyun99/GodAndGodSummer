package com.juntcompany.godandgodsummer.Main.TimeLine;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.MyProfile;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-06-30.
 */
public class TimelineHeaderViewHolder extends RecyclerView.ViewHolder {


    //    버튼에 리스너 달기 위해 interface 필요
    public interface OnItemClickListener {
        public void onAdapterItemHeaderClick(View view, int position);
//    이 인터페이스를 implement 하는 곳에서는 onAdapterItemLikeClick 를 재정의 해야함
    }
    OnItemClickListener mAdapterClickListener;  // 위 인터페이스 객체
    //    holer.setOnItemclickListener 로 쓰임
    public void setOnItemClickListener(OnItemClickListener listener){
        mAdapterClickListener = listener; //위 인터페이스 객체가 저장됨
    }

    ///////////////////////////////////////////////////////////////////////////////////////클릭기능

    ImageView imageView;
    TextView textWriteBoard;
    public TimelineHeaderViewHolder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAdapterClickListener!=null){
                    mAdapterClickListener.onAdapterItemHeaderClick(itemView, getAdapterPosition());
                    Log.i("header click", "header click");
                }
            }
        });
        imageView = (ImageView)itemView.findViewById(R.id.profile_image);
        textWriteBoard = (TextView)itemView.findViewById(R.id.text_Write_Board);

    }

    public void setData(MyProfile myProfile){
        imageView.setImageDrawable(myProfile.myImage);
    }


}
