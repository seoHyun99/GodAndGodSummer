package com.juntcompany.godandgodsummer.Login.SignIn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn1MainFragment extends Fragment {


    public SignIn1MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_sign_in1_main, container, false);
        Button btn = (Button)view.findViewById(R.id.button_signUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //        프래그먼트 세팅
                int count = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                Log.i("count", "Main count : " + count);
                Fragment f = new SignIn2TermsFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.signin_container, f);
                ft.addToBackStack(""+count);
                ft.commit(); //백스택에 해당 프래그먼트가 저장됨
                //        프래그먼트 세팅
            }
        });

        btn = (Button)view.findViewById(R.id.button_login_back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        return view;
    }

}
