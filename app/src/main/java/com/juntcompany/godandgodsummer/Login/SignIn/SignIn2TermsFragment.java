package com.juntcompany.godandgodsummer.Login.SignIn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn2TermsFragment extends Fragment {


    public SignIn2TermsFragment() {
        // Required empty public constructor
    }


    private static final String Title= "약관";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in2_terms, container, false);
        //       툴바 셋팅
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
                Log.i("count", "Terms count : " + count);
                Fragment f = new SignIn3PolicyFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.signin_container, f);
                ft.addToBackStack(""+count);
                ft.commit(); //백스택에 해당 프래그먼트가 저장됨
                //        프래그먼트 세팅

            }
        });
        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));


         Button btnAgree = (Button)view.findViewById(R.id.button_agree);
        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!btnSelected) {
                    btnNext.setVisibility(View.VISIBLE);
                    btnSelected = true;
                }else {
                    btnNext.setVisibility(View.GONE);
                    btnSelected =false;
                }

            }
        });

        return view;
    }
    boolean btnSelected= false;  // btnAgree 용, 다음 활성화 할 수 있도록


}
