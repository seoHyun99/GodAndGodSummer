package com.juntcompany.godandgodsummer.Main.Chatting.ChattingGroupTab;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.juntcompany.godandgodsummer.Data.GroupRoom;
import com.juntcompany.godandgodsummer.MakeGroup.MakeGroupActivity;
import com.juntcompany.godandgodsummer.R;
import com.juntcompany.godandgodsummer.Setting.GroupSettingActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChattingGroupFragment extends Fragment {


    public ChattingGroupFragment() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    ChattingGroupAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chatting_group, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new ChattingGroupAdapter();
        mAdapter.setOnItemClickListener(new ChattingGroupAdapter.OnAdapterItemClickListener() {
            @Override
            public void onAdapterHeaderMakeGroupClick(View view, int position) {
                Toast.makeText(getContext(), "그룹 만들기", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), MakeGroupActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAdapterItemSettingClick(View view, int position) {
                Intent intent = new Intent(getContext(), GroupSettingActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        initData();

        return view;
    }


    private void initData(){
        for(int i=0; i<4; i++){
            GroupRoom groupRoom = new GroupRoom();
            mAdapter.add(groupRoom);
        }

    }
}
