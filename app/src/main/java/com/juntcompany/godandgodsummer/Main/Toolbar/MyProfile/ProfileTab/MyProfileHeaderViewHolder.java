package com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.ProfileTab;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.juntcompany.godandgodsummer.Data.MyProfile;
import com.juntcompany.godandgodsummer.Data.User;
import com.juntcompany.godandgodsummer.Main.MainActivity;
import com.juntcompany.godandgodsummer.Manager.PropertyManager;
import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-05.
 */
public class MyProfileHeaderViewHolder extends RecyclerView.ViewHolder{

    public interface OnItemSelectClickListener{
        public void onItemCorrectClick(View view, int position);
        public void onItemPictureClick(View view, int position);
    }
    OnItemSelectClickListener mItemClickListener;
    public void setOnItemClickListener(OnItemSelectClickListener listener){
        mItemClickListener = listener;
    }



    ImageView imageProfilePicture;
    TextView textUserName, textUserEmail;
    TextView textUserComment;

    TextView textReligion, textFriendNum, textReligionArea, textCity;
    Context mContext;

    public MyProfileHeaderViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        imageProfilePicture = (ImageView)itemView.findViewById(R.id.myProfileUserPicture);
        Log.i("viewholder", "viewholder loading");
//        if(!PropertyManager.getInstance().getProfileImage().equals("")){
//            //PropertyManager 로 image를 한번이라도 저장했으면 걸림
//            Glide.with(mContext).load(PropertyManager.getInstance().getProfileImage()).into(imageProfilePicture);
//        }
        imageProfilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener!=null){
                    mItemClickListener.onItemPictureClick(view, getAdapterPosition());
                }
    }
});
        textUserEmail = (TextView)itemView.findViewById(R.id.myProfileUserEmail);
        textUserName = (TextView)itemView.findViewById(R.id.myProfileUserName);
        textUserComment = (TextView)itemView.findViewById(R.id.myProfileComment);

        textReligion = (TextView)itemView.findViewById(R.id.myProfileReligion);
        textFriendNum = (TextView)itemView.findViewById(R.id.myProfileFriendNum);
        textReligionArea = (TextView)itemView.findViewById(R.id.myProfileReligionHome);
        textCity = (TextView)itemView.findViewById(R.id.myProfileCity);
        Button btn = (Button)itemView.findViewById(R.id.button_profile_change);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener != null){
                    mItemClickListener.onItemCorrectClick(view, getAdapterPosition());
                }
            }
        });


    }
    public void setData(User user){
//        textUserName.setText(myProfi);
//        if(!PropertyManager.getInstance().getProfileImage().equals("")){
//            //PropertyManager 로 image를 한번이라도 저장했으면 걸림
//            Glide.with(mContext).load(myProfile).into(imageProfilePicture);
//        }
//        Log.i("user", user.email +  user.userPhoto);
//        Glide.with(mContext).load(user.userPhoto).into(imageProfilePicture);
        textUserName.setText(user.name);
        textUserEmail.setText(user.email);
        textCity.setText(user.city);
        textFriendNum.setText(""+user.friendNum);
        textReligion.setText(user.religion);
        textReligionArea.setText(user.religionArea);
        textUserComment.setText(user.introduction);

    }
}
