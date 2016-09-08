package com.juntcompany.godandgodsummer.Login.SignIn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn3PolicyFragment extends Fragment {


    public SignIn3PolicyFragment() {
        // Required empty public constructor
    }

    private static final String Title= "개인정보취급방침";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in3_policy, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        SignInActivity activity = (SignInActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        ActionBar actionBar = ((SignInActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.button_back);
//        actionBar.set
        View viewToolbar = getActivity().getLayoutInflater().inflate(R.layout.toolbar_sign_in, null);
        TextView textTitle = (TextView)viewToolbar.findViewById(R.id.text_title);
        textTitle.setText(Title);
        final Button btnNext = (Button) viewToolbar.findViewById(R.id.button_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //        프래그먼트 세팅
                int count = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                Log.i("count", "policy count : " + count);
                Fragment f = new SignIn4PhoneFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.signin_container, f);
                ft.addToBackStack(""+count);
                ft.commit(); //백스택에 해당 프래그먼트가 저장됨
                //        프래그먼트 세팅

            }
        });
        final Button btnAgree = (Button)view.findViewById(R.id.button_agree);
        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!btnSelected) {
                    btnNext.setVisibility(View.VISIBLE);
                    btnAgree.setBackgroundResource(R.drawable.button_confirm);//초록색 배경
                    btnSelected = true;
                }else {
                    btnNext.setVisibility(View.GONE);
                    btnAgree.setBackgroundResource(R.drawable.button_agree);//회색 배경
                    btnSelected =false;
                }

            }
        });

        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));



        return view;
    }
    boolean btnSelected = false;  // btnAgree 용, 다음 활성화 할 수 있도록



}
