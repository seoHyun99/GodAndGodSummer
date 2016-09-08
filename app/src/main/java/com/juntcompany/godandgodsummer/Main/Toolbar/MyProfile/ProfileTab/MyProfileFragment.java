package com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.ProfileTab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.MyProfile;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.Dialog.PictureSettingDialogFragment;
import com.juntcompany.godandgodsummer.Manager.PropertyManager;
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
    private static final String DIALOG ="dialog";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
//////////////////리사이클러 뷰 세팅
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new MyProfileAdapter();
        mAdapter.setOnItemClickListener(new MyProfileAdapter.OnAdapterItemClickListener() {
            @Override
            public void onAdapterHeaderProfileCorrectClick(View view, int position) {
                int count = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                Fragment f = new ProfileCorrectFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f); //메인의 container 에 프래그먼트가 대체됨
                ft.addToBackStack(""+count);
                ft.commit();

                /////메인 container 에 대체되어야 함
            }

            @Override
            public void onAdapterHeaderProfilePictureClick(final View view, final int position) {
                PictureSettingDialogFragment df = new PictureSettingDialogFragment();

                df.show(getFragmentManager(), DIALOG);
            }

            @Override
            public void onAdapterHeaderClick(View view, int position) {

            }

            @Override
            public void onAdapterItemLikeClick(View view, int position) {

            }

            @Override
            public void onAdapterItemViewClick(View view, int position) {

            }

            @Override
            public void onAdapterItemReportClick(View view, int position) {

            }

            @Override
            public void onAdapterItemReplyClick(View view, int position) {

            }

            @Override
            public void onAdapterItemMarkClick(View view, int position) {

            }
        });
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

///////////////////리사이클러 뷰 세팅
        initData();
        return view;
    }

    private void initData(){
        MyProfile myProfile = new MyProfile();
        mAdapter.addProfileHeader(myProfile);
        mAdapter.addHeader(myProfile);

//        헤더를 두개 넣어야 에러 안남
        for(int i =0; i<4; i++){
            Timeline timeline = new Timeline();
            timeline.content= i + "번째 내용이다";
            mAdapter.add(timeline);
        }
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        MyProfile myProfile = new MyProfile();
//        myProfile.myImage = PropertyManager.getInstance().getProfileImage();
//        mAdapter.addChangeProfileHeader(myProfile);
//    }
}
