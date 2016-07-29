package com.juntcompany.godandgodsummer.Main.TimeLine;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.juntcompany.godandgodsummer.Data.MyProfile;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.Dialog.ReportDialogFragment;
import com.juntcompany.godandgodsummer.Dialog.WriteReply.WriteReplyFragment;
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
    private static final String REPLY_DIALOG = "dialog";
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
//       툴바 셋팅
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        MainActivity  activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        final ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
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
                Log.i("TimelineFragment" , "onItemLickClick");
                Timeline timeline = timelineAdapter.getItem(position);

                timeline.tlLikeCount +=1;
                timelineAdapter.add(timeline);

            }

            @Override
            public void onAdapterItemViewClick(View view, int position) {
                Toast.makeText(getContext(), "전체 클릭", Toast.LENGTH_SHORT).show();
                WriteReplyFragment df = new WriteReplyFragment();
                df.show(getFragmentManager(), REPLY_DIALOG);
            }

            @Override
            public void onAdapterItemReportClick(View view, int position) {
                Toast.makeText(getContext(), "신고 버튼 클릭", Toast.LENGTH_SHORT).show();
                ReportDialogFragment df = new ReportDialogFragment();
                df.show(getFragmentManager(), REPLY_DIALOG);
            }

            @Override
            public void onAdapterItemReplyClick(View view, int position) {
                Toast.makeText(getContext(), "댓글 버튼 클릭", Toast.LENGTH_SHORT).show();
                WriteReplyFragment df = new WriteReplyFragment();
                Bundle bundle = new Bundle();
                bundle.putString(ReportDialogFragment.REPLY_MESSAGE, "reply");
                df.setArguments(bundle);
                df.show(getFragmentManager(), REPLY_DIALOG);

            }

            @Override
            public void onAdapterItemMarkClick(View view, int position) {
                Toast.makeText(getContext(), "마크 버튼 클릭", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(timelineAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
//      리사이클러뷰 세팅 끝
//리프레쉬 레이아웃 세팅
         refreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });
        refreshLayout.setColorSchemeColors(Color.YELLOW, Color.RED, Color.GREEN);
//        리프레쉬 레이아웃 세팅 끝

        initData();
        initHeaderData();

        return view;
    }

    SwipeRefreshLayout refreshLayout;

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
       refreshLayout.setRefreshing(false);  //데이터가 추가되면 리프레슁을 false 해야함

   }
    private void initHeaderData(){
        MyProfile myProfile = new MyProfile();

        myProfile.myImage2 = getResources().getDrawable(R.drawable.profile1);
        timelineAdapter.addHeader(myProfile);
    }
}
