package com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.RequestTab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.R;

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
    FriendRecommendAdapter bAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_request, container, false);
//        Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new FriendRequestAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
/////////////////////////////////////////////////////////////////////////
//

        initData();
        return view;
    }

    private void initData(){
        mAdapter.addHeader("친구요청");
        for(int i=0; i<4; i++){
            Friend friend = new Friend();
            friend.friendName = "엄준태님이당";
            mAdapter.add(friend);
        }
    }

}
