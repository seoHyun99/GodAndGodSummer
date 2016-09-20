package com.juntcompany.godandgodsummer.Dialog;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeFriendDialogFragment extends DialogFragment {


    public BeFriendDialogFragment() {
        // Required empty public constructor
    }

    public interface OnDialogResultListener {
        public void onPositiveResult(String value);
        public void onNegativeResult();
    }
    OnDialogResultListener mDialogListener;
    public void setOnDialogResultListener(OnDialogResultListener listener) {
        mDialogListener = listener;
    }
    /////////////////다욜로그 버튼에 리스너 달기

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MyDialog);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_be_friend_dialog, container, false);
        Button btn = (Button)view.findViewById(R.id.button_cancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mDialogListener!=null){
                    mDialogListener.onNegativeResult();
                }
                dismiss();
            }
        });
        btn = (Button)view.findViewById(R.id.button_confirm); // 친구 추가
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mDialogListener!=null){
                    mDialogListener.onPositiveResult("yes");

                }
                dismiss();
            }
        });

        return view;
    }

}
