package com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.ProfileTab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.MyProfile;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {


    public MyProfileFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    MyProfileAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new MyProfileAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        initData();
        return view;
    }

    private void initData(){
        MyProfile myProfile = new MyProfile();
        mAdapter.addHeader(myProfile);
        mAdapter.addProfileHeader(myProfile);
//        헤더를 두개 넣어야 에러 안남
        for(int i =0; i<4; i++){
            Timeline timeline = new Timeline();
            timeline.tlContent= i + "번째 내용이다";
            mAdapter.add(timeline);
        }
    }

}
