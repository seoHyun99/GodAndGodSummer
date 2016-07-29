package com.juntcompany.godandgodsummer.Dialog;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.juntcompany.godandgodsummer.Manager.PropertyManager;
import com.juntcompany.godandgodsummer.R;

import java.io.File;
import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureSettingDialogFragment extends DialogFragment {

//    //MyProfileFragment 에서
    public interface OnImageValueReceiver {
        public void onImageValue(String success);
    }

    OnImageValueReceiver mImageReceiver;

    public void setOnImageListener(OnImageValueReceiver listener) {
        mImageReceiver = listener;
    }

    public PictureSettingDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MyDialog);
    }


    private int PICK_IMAGE_REQUEST = 1;
    ImageView imageTest;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picture_setting_dialog, container, false);
        imageTest =(ImageView)view.findViewById(R.id.image_test);
        RelativeLayout btn = (RelativeLayout) view.findViewById(R.id.relative_btn_picture);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ACTION_GET_CONTENT 드라이버에서 가져오기
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*"); //이미지 가져오기 위해 새로운 창 띄우는 기능
// Always show the chooser (if there are multiple options available)
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();
            Log.i("uri", uri.toString());
            Cursor c = getActivity().getContentResolver().query(uri, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
            if (c.moveToNext()) {
                String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
                PropertyManager.getInstance().setProfileImage(path); //이미지를 저장
//                File file = new File(path);
//                Uri fileUri = Uri.fromFile(file);
                if(mImageReceiver!=null) { // 현재 프래그먼트에서 만든 interface 객체로
                    mImageReceiver.onImageValue("success"); //MyProfileFragment 로 값을 전달할 예정
                }
//                Glide.with(getContext()).load(fileUri).into(imageTest);
            }
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
//                imageTest.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            // Log.d(TAG, String.valueOf(bitmap));
        }
    }
}
