package com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.ListTab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendListFragment extends Fragment {


    public FriendListFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    FriendListAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new FriendListAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        initData();

        return view;
    }

    private void initData(){
        for(int i=0; i<5; i++){
            Friend friend = new Friend();
            mAdapter.add(friend);
        }
    }

}
