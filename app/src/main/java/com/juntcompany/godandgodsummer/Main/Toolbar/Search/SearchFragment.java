package com.juntcompany.godandgodsummer.Main.Toolbar.Search;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.Main.FriendInfo.FriendInfoFragment;
import com.juntcompany.godandgodsummer.Main.MainActivity;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineFragment;
import com.juntcompany.godandgodsummer.R;
import com.juntcompany.godandgodsummer.Util.GodAndGod;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    RecyclerView recyclerView;
    SearchAdapter mAdapter;
    EditText editSearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        Context mContext = GodAndGod.getContext();
//        InputMethodManager imm = (InputMethodManager)mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(editSearch.getWindowToken(), 0);


        View view = inflater.inflate(R.layout.fragment_search, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        MainActivity  activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        final ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.button_back);
//        actionBar.set
        View viewToolbar = getActivity().getLayoutInflater().inflate(R.layout.toolbar_main_search, null);
         editSearch = (EditText)viewToolbar.findViewById(R.id.edit_search);
        editSearch.requestFocus();

        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new SearchAdapter();
        mAdapter.setOnItemClickListener(new SearchAdapter.OnAdapterItemClickListener() {
            @Override
            public void onAdapterItemDeleteClick(View view, int position) {
                mAdapter.removeItem(position);
//                Toast.makeText(getContext(),"삭제", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterItemClick(View view, int position) {
                Fragment f = new FriendInfoFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f)
                        .addToBackStack(null)
                        .commit();
            }
        });
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
//      리사이클러뷰 세팅 끝

        initData();
        return view;
    }

    private void initData(){
        for(int i =0; i<4; i++){
            Friend friend = new Friend();
            friend.friendName = i + "번째 친구";
            mAdapter.add(friend);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                getActivity().getSupportFragmentManager().popBackStack();
                return true;
            }
        }
        return true;
    }


}
