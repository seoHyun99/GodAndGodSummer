package com.juntcompany.godandgodsummer.Main.Video;


import android.content.Intent;
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
import android.widget.Toast;

import com.juntcompany.godandgodsummer.Data.Video;
import com.juntcompany.godandgodsummer.Main.MainActivity;
import com.juntcompany.godandgodsummer.R;
import com.juntcompany.godandgodsummer.Util.YoutubeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {


    public VideoFragment() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    VideoAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_video, container, false);
//        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
//        EditText editSearch = (EditText)actionBar.getCustomView().findViewById(R.id.edit_search);
//        editSearch.setText("동영상 검색");
//                툴바 세팅
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar2 = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar2.setDisplayShowCustomEnabled(true);
        actionBar2.setDisplayShowTitleEnabled(false);
//        actionBar.set
        View viewToolbar = getActivity().getLayoutInflater().inflate(R.layout.toolbar_main_video, null);
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
        actionBar2.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
//        툴바 세팅


        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new VideoAdapter();
        mAdapter.setOnItemClickListener(new VideoAdapter.OnAdapterItemClickListener() {
            @Override
            public void onAdapterItemViewClick(View view, int position) {
                Video video = mAdapter.getItem(position);
                Toast.makeText(getContext(), video.videoName, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), YoutubeActivity.class);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter.addHeader(HEADER_TITLE);
        initData();

        return view;
    }
    private static final String HEADER_TITLE= "전체 동영상";
    private void initData(){

//        for(int i=0; i<10; i++){
//            Video video = new Video();
//            video.videoName =  i + "번째 동영상";
//            video.videoOwner = i + "번째 주인";
//            mAdapter.add(video);
//        }
        Video video1 = new Video();
        video1.videoName = "아산교구 성령대회";
        video1.videoOwner = "이성진";
        video1.videoUpdateDate = "9월 10일";
        video1.videoThumbNail = "https://img.youtube.com/vi/p_oW4B4qMyY/0.jpg";
        mAdapter.add(video1);
        Video video2 = new Video();
        video2.videoName = "마산교구";
        video2.videoOwner = "마왕";
        video2.videoUpdateDate = "8월 20일";
        video2.videoThumbNail = "https://img.youtube.com/vi/gB-MiPm0hnY/0.jpg";
        mAdapter.add(video2);
        Video video3 = new Video();
        video3.videoName = "법륜스님 집회";
        video3.videoOwner = "법륜";
        video3.videoUpdateDate = "8월 10일";
        video3.videoThumbNail = "https://img.youtube.com/vi/fSNjgSebht8/0.jpg";
        mAdapter.add(video3);
        Video video4 = new Video();
        video4.videoName = "혜민스님 집회";
        video4.videoOwner = "혜민스님";
        video4.videoUpdateDate = "8월 3일";
        video4.videoThumbNail = "https://img.youtube.com/vi/T7lR1_th1Qo/0.jpg";
        mAdapter.add(video4);
        Video video5 = new Video();
        video5.videoName = "불국사 집회";
        video5.videoOwner = "스님";
        video5.videoUpdateDate = "9월 5일";
        video5.videoThumbNail = "https://img.youtube.com/vi/hgQJTzNqqT0/0.jpg";
        mAdapter.add(video5);
    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//
////        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
////        EditText editSearch = (EditText)actionBar.getCustomView().findViewById(R.id.edit_search);
////        editSearch.setText("검색");
//    }
}
