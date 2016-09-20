package com.juntcompany.godandgodsummer.Main.Toolbar.Search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.juntcompany.godandgodsummer.Data.User;
import com.juntcompany.godandgodsummer.DataStructure.UserSearchResponse;
import com.juntcompany.godandgodsummer.Main.FriendInfo.FriendInfoFragment;
import com.juntcompany.godandgodsummer.Main.MainActivity;
import com.juntcompany.godandgodsummer.R;
import com.juntcompany.godandgodsummer.Util.Rest.ApiClient;
import com.juntcompany.godandgodsummer.Util.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        editSearch.addTextChangedListener(new TextWatcher() { // 검색창에 user email 을 치면 텍스트 칠때마다 찾게 함
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editSearch.getText().toString().length()>2) {
                    searchUserNetwork(editSearch.getText().toString());
                    Toast.makeText(getContext(), editSearch.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
//////////////////////////툴바 세팅 끝
        ////////////////////////리사이클러뷰 세팅
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
                User user = mAdapter.getItem(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable(FriendInfoFragment.FRIEND_INFO_MESSAGE, user);
                Fragment f = new FriendInfoFragment();
                f.setArguments(bundle);
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
////////////////////////////////////      리사이클러뷰 세팅 끝

        initData();
        return view;
    }

    private void initData(){
        for(int i =0; i<4; i++){
            User user = new User();
             user.email= i + "번째 친구";
            mAdapter.add(user);
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

    private void searchUserNetwork(String email){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<UserSearchResponse> call = apiInterface.userSearch(email);
        call.enqueue(new Callback<UserSearchResponse>() {
            @Override
            public void onResponse(Call<UserSearchResponse> call, Response<UserSearchResponse> response) {
                if(response.isSuccessful()){
                    mAdapter.clear();
                    mAdapter.addAll(response.body().users);
                }
            }

            @Override
            public void onFailure(Call<UserSearchResponse> call, Throwable t) {
                Toast.makeText(getContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
