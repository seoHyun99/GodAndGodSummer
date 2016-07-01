package com.juntcompany.godandgodsummer.Main.Chatting.ChattingListTab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.Chat;
import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChattingListFragment extends Fragment {


    public ChattingListFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    ChattingListAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chatting_list, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new ChattingListAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        initData();

        return view;
    }

    private void initData(){
        for(int i=0; i<10; i++){
            Chat chat = new Chat();
            chat.friendName = i + "사람";
            chat.lastSpeak = i + "사람이 말한 마지막 말";
            chat.lastTime = i + "시간";
            mAdapter.add(chat);
        }
    }

}
