package com.juntcompany.godandgodsummer.Main.Toolbar.Marked;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.Main.MainActivity;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineAdapter;
import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarkedFragment extends Fragment {


    public MarkedFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    MarkedAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_marked, container, false);

//       툴바 셋팅
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.set
        View viewToolbar = getActivity().getLayoutInflater().inflate(R.layout.toolbar_main_timeline, null);
        final EditText editSearch = (EditText)viewToolbar.findViewById(R.id.edit_search);
        editSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).getSearchFragment();
            }
        });
        Button btn = (Button)viewToolbar.findViewById(R.id.toolbar_btn_mark);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).getToolbarFragment(MainActivity.FRAGMENT_MARKED);
            }
        });
        btn = (Button)viewToolbar.findViewById(R.id.toolbar_btn_friend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).getToolbarFragment(MainActivity.FRAGMENT_FRIEND);
            }
        });
        btn = (Button)viewToolbar.findViewById(R.id.toolbar_btn_profile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).getToolbarFragment(MainActivity.FRAGMENT_PROFILE);
        }
        });
        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
////////////////////        툴바셋팅

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new MarkedAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        initData();

        return view;
    }

    private void initData(){
        for(int i=0; i<5; i++){
            Timeline timeline = new Timeline();
            mAdapter.add(timeline);
        }

    }

}
