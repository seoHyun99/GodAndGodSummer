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

import com.juntcompany.godandgodsummer.Data.User;
import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn11ConfirmFragment extends Fragment {


    public SignIn11ConfirmFragment() {
        // Required empty public constructor
    }

    private static final String Title= "정보확인";
    public static final String USER_MESSAGE = "user_message";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in11_confirm, container, false);

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

        Bundle userBundle = getArguments();
        final User user = (User) userBundle.getSerializable(SignIn11ConfirmFragment.USER_MESSAGE); //마지막 user 데이터// 서버에 전송
        Button btnNext = (Button) viewToolbar.findViewById(R.id.button_next);
        btnNext.setVisibility(View.VISIBLE);
        btnNext.setText("완료");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //        프래그먼트 세팅

                int count = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                Log.i("count", "confirm count : " + count);
                Fragment f = new SignIn3PolicyFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.signin_container, f);
                ft.addToBackStack(""+count);
                ft.commit(); //백스택에 해당 프래그먼트가 저장됨
                //        프래그먼트 세팅

                ((SignInActivity) getActivity()).callSignUpLast(user); // user 를 서버에 전송하는 메소드. 액티비티에 있고 마지막으로 콜하는 메소드
            }
        });
        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));

        TextView textPhone = (TextView)view.findViewById(R.id.phoneText);
        TextView textEmail = (TextView)view.findViewById(R.id.emailText);
        TextView textName = (TextView)view.findViewById(R.id.nickText);
        TextView textBirth = (TextView)view.findViewById(R.id.birthText);
        TextView textPassword = (TextView)view.findViewById(R.id.pwText);
        TextView textReligion = (TextView)view.findViewById(R.id.religionText);
        TextView textGender = (TextView)view.findViewById(R.id.genderText);

        textPhone.setText(user.phoneNumber);
        textEmail.setText(user.email);
        textName.setText(user.name);
        textBirth.setText(user.birthDay);
        textPassword.setText(user.password);
        textReligion.setText(user.religion);
        textGender.setText(user.gender);

        return view;
    }

}
