package com.juntcompany.godandgodsummer.Main.Toolbar.Search;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.Data.User;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineViewHolder;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-08.
 */
public class SearchViewHolder extends RecyclerView.ViewHolder {


    public interface OnItemSelectClickListener{
        public void onItemDeleteClick(View view, int position);
        public void onItemClick(View view, int position);
    }

    OnItemSelectClickListener mItemClickListener;

    public void setOnItemClickListener(OnItemSelectClickListener listener){
        mItemClickListener = listener;
    }

    ImageView imagePicture;
    TextView textFriendName;
    Button btnDelete;
    public SearchViewHolder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener!=null){
                    mItemClickListener.onItemClick(view, getAdapterPosition());
                }
            }
        });

        imagePicture = (ImageView)itemView.findViewById(R.id.image_picture);
        textFriendName = (TextView)itemView.findViewById(R.id.text_friend_name);
        btnDelete = (Button)itemView.findViewById(R.id.button_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener!=null){
                    mItemClickListener.onItemDeleteClick(itemView, getAdapterPosition());
                }
            }
        });
    }

    public void setData(User user){
//        imagePicture.setImageResource();
           textFriendName.setText(user.email);
    }
}
