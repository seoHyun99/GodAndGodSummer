package com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.NewsTab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juntcompany.godandgodsummer.Data.News;
import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {


    public NewsFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    NewsAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        Button btn = (Button)view.findViewById(R.id.button_support);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new NewsAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        initData();
        return view;
    }


    private void initData(){

            News news = new News();
            news.eventName = "둔산성광교회";
            news.eventContent="유스컨퍼런스에 여러분을 초대합니다.";
            news.eventContentSecond="중부권 청소년의 깨어있음이 다시 시작됩니다!";
            news.eventTime = "12월 2~4일 오후 2시~저녁9시";
            mAdapter.add(news);

            News news1 = new News();
            news1.eventName = "여의도순복음교회";
            news1.eventContent="여의도순복음교회 사역에 여러분을 초대합니다.";
        news1.eventContentSecond="인터넷 생방송을 홈페이지에서 시청 가능합니다.";
            news1.eventTime = "매주 주일 11시";
            mAdapter.add(news1);

            News news2 = new News();
            news2.eventName = "마커스 인도 집회";
            news2.eventContent="마커스 인도 집회가 시작됩니다.";
        news2.eventContentSecond="사역의 준비 가운데 많은 분들의 중보기도가 필요합니다.";
            news2.eventTime = "9월 25일 저녁 8시";
            mAdapter.add(news2);

            News news3 = new News();
            news3.eventName = "법륜스님 즉문즉설";
            news3.eventContent="여러분의 궁금증을 나누는 자리입니다.";
            news3.eventContentSecond="평소에 가슴 답답한 내용을 함께 공유합니다.";
            news3.eventTime = "9월 30일";
            mAdapter.add(news3);

    }
}
