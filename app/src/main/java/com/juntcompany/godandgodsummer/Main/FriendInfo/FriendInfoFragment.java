package com.juntcompany.godandgodsummer.Main.FriendInfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.Dialog.BeNotFriendDialogFragment;
import com.juntcompany.godandgodsummer.Dialog.MessageNotFragment;
import com.juntcompany.godandgodsummer.Main.MainActivity;
import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendInfoFragment extends Fragment {


    public FriendInfoFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    RecyclerView recyclerView;
    FriendInfoAdapter mAdapter;
    private static final String DIALOG = "dialog";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_info, container, false);

        //       툴바 셋팅
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.button_back);
//        actionBar.set
        View viewToolbar = getActivity().getLayoutInflater().inflate(R.layout.toolbar_main_search, null);

        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));

        //////////////툴바 세팅

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new FriendInfoAdapter();
        mAdapter.setOnItemClickListener(new FriendInfoAdapter.OnAdapterItemClickListener() {
            @Override
            public void onAdapterItemAddClick(View view, int position) {
//                Toast.makeText(getContext(),"친구 추가", Toast.LENGTH_SHORT).show();
                BeNotFriendDialogFragment df = new BeNotFriendDialogFragment();
                df.show(getFragmentManager(), DIALOG);
            }

            @Override
            public void onAdapterMessageClick(View view, int position) {
//                Toast.makeText(getContext(),"메시지", Toast.LENGTH_SHORT).show();
                MessageNotFragment df = new MessageNotFragment();
                df.show(getFragmentManager(), DIALOG);
            }
        });
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        initData();

        return view;
    }

    private void initData(){
        Friend friend = new Friend();
        mAdapter.addHeader(friend);
        for(int i=0; i<3; i++){
            Timeline timeline = new Timeline();
            mAdapter.add(timeline);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                int count = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                Log.i("backstack", ""+ count);
                getActivity().getSupportFragmentManager().popBackStack();
                int count2 = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                Log.i("backstack", ""+ count2);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
