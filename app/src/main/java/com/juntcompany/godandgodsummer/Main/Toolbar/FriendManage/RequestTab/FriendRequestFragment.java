package com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.RequestTab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.Data.SectionHeader;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendRequestFragment extends Fragment {


    public FriendRequestFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    RecyclerView recyclerViewBottom;
    FriendRequestAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_request, container, false);
//        Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new FriendRequestAdapter();
        mAdapter.setOnItemClickListener(new FriendRequestAdapter.OnAdapterItemClickListener() {
            @Override
            public void onAdapterConfirmClick(View view, int position) {
                Toast.makeText(getContext(), "확인", Toast.LENGTH_SHORT).show();
                mAdapter.removeItem(position);
            }

            @Override
            public void onAdapterDeleteClick(View view, int position) {
                Toast.makeText(getContext(), "삭제", Toast.LENGTH_SHORT).show();
                mAdapter.removeItem(position);
            }
        });
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
/////////////////////////////////////////////////////////////////////////
//

        initData();
        return view;
    }
    ArrayList<Friend> friends;
    private void initData(){

        Friend friend = new Friend();
        friend.friendName = "dddd";
        friends  = new ArrayList<Friend>();
        for(int i =0; i<4; i++){
            friends.add(friend);
        }
        mAdapter.addFirstSection("친구 요청", friends);
        mAdapter.addSecondSection("친구 추천", friends);
    }

}
