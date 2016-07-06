package com.juntcompany.godandgodsummer.Main.TimeLine;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juntcompany.godandgodsummer.Data.MyProfile;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.Main.MainActivity;
import com.juntcompany.godandgodsummer.R;
import com.juntcompany.godandgodsummer.WriteBoard.WriteBoardActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment {


    public TimelineFragment() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    TimelineAdapter timelineAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
//       툴바 셋팅
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        MainActivity  activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.set
        View viewToolbar = getActivity().getLayoutInflater().inflate(R.layout.toolbar_main_timeline, null);
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

//        리사이클러뷰 세팅
         recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
          timelineAdapter = new TimelineAdapter();
        timelineAdapter.setOnItemClickListener(new TimelineAdapter.OnAdapterItemClickListener() {
            @Override
            public void onAdapterHeaderClick(View view, int position) {
                Intent intent = new Intent(getContext(), WriteBoardActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAdapterItemLikeClick(View view, int position) {
                Log.i("TimelineFragment" , "onAdapterItemLikeClick");
                Timeline timeline = timelineAdapter.getItem(position);

                timeline.tlLikeCount +=1;
                timelineAdapter.add(timeline);

            }
        });

        recyclerView.setAdapter(timelineAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
//      리사이클러뷰 세팅 끝

        initData();

        return view;
    }

   private void initData(){
       Log.i("initData", "initData");
       for(int i =0; i<10; i++) {

           Timeline tl = new Timeline();
           tl.tlUsername = i + "user";
           tl.tlLikeCount = 3;
           tl.tlReplyCount = 30;
           tl.tlContent = i + "번째";
           timelineAdapter.add(tl);
       }
       MyProfile myProfile = new MyProfile();
        myProfile.myImage = getResources().getDrawable(R.drawable.profile1);
       timelineAdapter.addHeader(myProfile);
   }
}
