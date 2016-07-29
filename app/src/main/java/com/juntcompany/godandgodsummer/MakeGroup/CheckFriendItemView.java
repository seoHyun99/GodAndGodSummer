package com.juntcompany.godandgodsummer.MakeGroup;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.R;

/**
 * Created by EOM on 2016-07-18.
 */
public class CheckFriendItemView extends RelativeLayout implements Checkable{


    public CheckFriendItemView(Context context) {
        super(context);
        init();
    }
    TextView textFriendName;
    ImageView imagePicture;
    ImageView checkView;

    private void init(){
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        inflate(getContext(), R.layout.view_friend_check, this);
        textFriendName = (TextView)findViewById(R.id.text_friend_name);
        imagePicture = (ImageView)findViewById(R.id.image_picture);
        checkView = (ImageView)findViewById(R.id.image_check_button);
    }


    public void setFriendName(String friendName){
        textFriendName.setText(friendName);
    }

    boolean isChecked = false;

    ////////////직접 만들어서 사용하는 부분.. 윗 부분분


    private void drawCheck(){ //setChecked 메소드로 한번 쓰임
        if (isChecked) {
            checkView.setImageResource(android.R.drawable.checkbox_on_background);
        }else {
            checkView.setImageResource(android.R.drawable.checkbox_off_background);
        }
    }
    @Override
    public void setChecked(boolean checked) { //toggle 메소드에서 사용됨
        if(isChecked != checked){
            isChecked = checked;
            drawCheck();
        }
    }


    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked);
    }
}
