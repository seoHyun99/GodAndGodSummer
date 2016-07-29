package com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.DefaultTab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.juntcompany.godandgodsummer.Main.MainActivity;
import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TargetFragment extends Fragment {


    public TargetFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_target, container, false);


//       프로필 내용에 들어가는 프로그래스바 및 텍스트 세팅 //content_my_propfile_status 세팅
        ProgressBar faithgraph_progressbar = (ProgressBar)view.findViewById(R.id.faithgraph_progressbar);
        ProgressBar populargraph_progressbar = (ProgressBar)view.findViewById(R.id.populargraph_progressbar);
        ProgressBar donategraph_progressbar = (ProgressBar)view.findViewById(R.id.donategraph_progressbar);
        ProgressBar friendlygraph_progressbar = (ProgressBar)view.findViewById(R.id.friendlygraph_progressbar);

        TextView faithgraph_text =(TextView)view.findViewById(R.id.faithgraph_text);
        TextView populargraph_text =(TextView)view.findViewById(R.id.populargraph_text);
        TextView donategraph_text =(TextView)view.findViewById(R.id.donategraph_text);
        TextView friendlygraph_text =(TextView)view.findViewById(R.id.friendlygraph_text);

        faithgraph_progressbar.setProgress(70);
        faithgraph_text.setText(String.valueOf(faithgraph_progressbar.getProgress()));
        populargraph_progressbar.setProgress(60);
        populargraph_text.setText(String.valueOf(populargraph_progressbar.getProgress()));
        donategraph_progressbar.setProgress(90);
        donategraph_text.setText(String.valueOf(donategraph_progressbar.getProgress()));
        friendlygraph_progressbar.setProgress(50);
        friendlygraph_text.setText(String.valueOf(friendlygraph_progressbar.getProgress()));
//               프로필 내용에 들어가는 프로그래스바 및 텍스트 세팅

        Button btn = (Button)view.findViewById(R.id.button_last_target); //지난주 목표
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int count = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                Log.i("backstack", "backstack count" + count);
                Fragment f = new LastWeekTargetFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f); //메인의 container 에 프래그먼트가 대체됨
                ft.addToBackStack(""+count);
                ft.commit();
            }
        });
        btn = (Button)view.findViewById(R.id.button_target_settings); //목표 설정
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int count = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                Log.i("backstack", "backstack count" + count);
                Fragment f = new SetMyTargetFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f); //메인의 container 에 프래그먼트가 대체됨
                ft.addToBackStack(""+count);
                ft.commit();
            }
        });

        return view;
    }

}
