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
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Data.User;
import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn7BirthFragment extends Fragment {


    public SignIn7BirthFragment() {
        // Required empty public constructor
    }

    String birth; //bundle 로 보낼 값
    private static final String Title= "생일입력";
    public static final String USER_MESSAGE = "user_message";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in7_birth, container, false);

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
        Button btnNext = (Button) viewToolbar.findViewById(R.id.button_next);
        btnNext.setVisibility(View.VISIBLE);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //        프래그먼트 세팅
                User user = (User)getArguments().getSerializable(SignIn7BirthFragment.USER_MESSAGE);
                user.birthDay = "900905";
                Bundle bundle = new Bundle();
                bundle.putSerializable(SignIn8PasswordFragment.USER_MESSAGE, user);

                int count = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                Log.i("count", "birth count : " + count);
                Fragment f = new SignIn8PasswordFragment();
                f.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.signin_container, f);
                ft.addToBackStack(""+count);
                ft.commit(); //백스택에 해당 프래그먼트가 저장됨
                //        프래그먼트 세팅
            }
        });
        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));

        DatePicker datePicker = (DatePicker)view.findViewById(R.id.datePicker);
        datePicker.init(1990, 01, 13, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                birth = ""+year+monthOfYear+dayOfMonth;
                Log.i("birth", birth);
            }
        });

        return view;
    }

}
