package com.juntcompany.godandgodsummer.MakeGroup;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.juntcompany.godandgodsummer.Data.Friend;
import com.juntcompany.godandgodsummer.Data.GroupRoom;
import com.juntcompany.godandgodsummer.R;

public class MakeGroupActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    MakeGroupAdapter mAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_group);

        //        툴바 세팅
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Get the ActionBar here to configure the way it behaves.
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.button_back);


        View viewToolbar =getLayoutInflater().inflate(R.layout.toolbar_make_group, null);
        Button toolbarBtn = (Button)viewToolbar.findViewById(R.id.button_toolbar_make_group);
        toolbarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAdapter.getCheckedItemsTrueCount() < 3){
                    Toast.makeText(getApplicationContext(), "친구추가를 더 해주세요", Toast.LENGTH_SHORT).show();
                }else {
                    finish();
                    //서버에 데이터 전송
                }
            }
        });

        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
////////////////////        툴바셋팅

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mAdapter = new MakeGroupAdapter();
        mAdapter.setOnItemClickListener(new MakeGroupAdapter.OnAdapterItemClickListener() {
            @Override
            public void onAdapterItemCheckClick(View view, int position) {
//               int count = mAdapter.getCheckedItems().size();
                int count =  mAdapter.getCheckedItemsTrueCount();
                Toast.makeText(getApplicationContext(), "" + count, Toast.LENGTH_SHORT).show();
                if(count >= 3){ //체크된것이 3개 이상인 경우 색 변함
                    toolbar.setBackgroundResource(R.color.colorPrimaryDark);
                }else {
                    toolbar.setBackgroundResource(R.color.colorGrey);
                }
            }
        });
//        Log.i("checkeditems", "checkeditem count :" + mAdapter.getCheckedItems() + " : " + mAdapter.getCheckedItems().size());
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        initData();

    }

    public void initData(){
        GroupRoom groupRoom = new GroupRoom();
        mAdapter.addHeader(groupRoom);

        for(int i=0; i<6; i++) {
            Friend friend = new Friend();
            friend.friendName = i +"이름";
            mAdapter.add(friend);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
