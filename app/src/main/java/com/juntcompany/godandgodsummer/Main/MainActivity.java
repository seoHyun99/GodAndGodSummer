package com.juntcompany.godandgodsummer.Main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.juntcompany.godandgodsummer.Main.Activity.ActivityLogFragment;
import com.juntcompany.godandgodsummer.Main.Chatting.ChattingFragment;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineFragment;
import com.juntcompany.godandgodsummer.Main.Video.VideoFragment;
import com.juntcompany.godandgodsummer.R;

public class MainActivity extends AppCompatActivity {

    boolean isBackPressed = false;
    public static final int MESSAGE_BACK_KEY_TIMEOUT = 0;
    public static final int BACK_KEY_TIME = 2000;
    Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_BACK_KEY_TIMEOUT :
                    isBackPressed = false;
                    return true;
            }
            return false;
        }
    });

//    백프레스 종료 용

    TabLayout tabLayout;
    Fragment f; //탭에 나오는 프래그먼트 용
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        // Get the ActionBar here to configure the way it behaves.
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.setDisplayShowTitleEnabled(false);


        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_timeline));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_chat));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_video));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_notice));

//
        f = new TimelineFragment();
//        초기 화면용 프래그먼트  timeline 이 나와야함
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, f)
                .commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.i("tab position", "" + position);
                switch (position){
                    case 0: {
                        f = new TimelineFragment();
                        break;
                    }
                    case 1:{
                        f= new ChattingFragment();
                        break;
                    }
                    case 2:{
                        f = new VideoFragment();
                        break;
                    }
                    case 3:{
                        f = new ActivityLogFragment();
                        break;
                    }
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f)
                        .commit();
//                content_main.xml 에 있는 container 에 프래그먼트가 띄워짐
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if(!isBackPressed){
            Toast.makeText(this, "뒤로 버튼을 한번 더 누르시면 종료됩니다", Toast.LENGTH_SHORT).show();
            isBackPressed = true;
            mHandler.sendEmptyMessageDelayed(MESSAGE_BACK_KEY_TIMEOUT, BACK_KEY_TIME);
        }else {
            mHandler.removeMessages(MESSAGE_BACK_KEY_TIMEOUT);
            finish();
        }
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
