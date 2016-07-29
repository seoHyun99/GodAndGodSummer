package com.juntcompany.godandgodsummer.Main.Chatting.ChattingListTab;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.juntcompany.godandgodsummer.Chatting.ChattingActivity;
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
        mAdapter.setOnItemClickListener(new ChattingListAdapter.OnAdapterItemClickListener() {
            @Override
            public void onAdapterItemViewClick(View view, int position) {
                Chat chat = mAdapter.getItem(position);
                Toast.makeText(getContext(), chat.friendName , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), ChattingActivity.class);
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
        for(int i=0; i<10; i++){
            Chat chat = new Chat();
            chat.friendName = i + "사람";
            chat.lastSpeak = i + "사람이 말한 마지막 말";
            chat.lastTime = i + "시간";
            mAdapter.add(chat);
        }
    }

}
