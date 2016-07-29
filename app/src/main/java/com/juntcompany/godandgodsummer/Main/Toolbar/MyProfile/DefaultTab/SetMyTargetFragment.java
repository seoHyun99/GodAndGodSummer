package com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.DefaultTab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juntcompany.godandgodsummer.Main.MainActivity;
import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetMyTargetFragment extends Fragment {


    public SetMyTargetFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);  //꼭 해야 homebutton 이 동작함
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("lifeFragment", "oncreatedView");
        View view = inflater.inflate(R.layout.fragment_set_my_target, container, false);

//        툴바 세팅

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.button_back);
//        actionBar.set
        View viewToolbar = getActivity().getLayoutInflater().inflate(R.layout.toolbar_profile_check, null);
        Button btn = (Button)viewToolbar.findViewById(R.id.button_check);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });
        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));

//        툴바 세팅

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                getActivity().getSupportFragmentManager().popBackStack();
//
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        Log.i("lifeFragment", "onDetach");
//        actionBar.show();
//        actionBarFrag.hide();
//    }


}
