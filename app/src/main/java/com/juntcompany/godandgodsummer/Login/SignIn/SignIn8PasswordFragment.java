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

import com.juntcompany.godandgodsummer.Data.User;
import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn8PasswordFragment extends Fragment {


    public SignIn8PasswordFragment() {
        // Required empty public constructor
    }

    EditText editPassword; //user data 에 입력할 값
    private static final String Title= "비밀번호 입력";
    public static final String USER_MESSAGE = "user_message";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in8_password, container, false);

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
                User user = (User)getArguments().getSerializable(SignIn8PasswordFragment.USER_MESSAGE);
                user.password = editPassword.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putSerializable(SignIn9religionFragment.USER_MESSAGE, user);

                int count = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                Log.i("count", "password count : " + count);
                Fragment f = new SignIn9religionFragment();
                f.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.signin_container, f);
                ft.addToBackStack(""+count);
                ft.commit(); //백스택에 해당 프래그먼트가 저장됨
                //        프래그먼트 세팅
            }
        });
        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));

        editPassword = (EditText)view.findViewById(R.id.edit_password);
        editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editPassword.getText().toString().length() >4){
                    btnNext.setVisibility(View.VISIBLE);
                }else {
                    btnNext.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        return view;
    }

}
