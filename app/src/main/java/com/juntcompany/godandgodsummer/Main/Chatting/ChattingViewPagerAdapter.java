package com.juntcompany.godandgodsummer.Main.Chatting;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.juntcompany.godandgodsummer.Main.Chatting.ChattingGroupTab.ChattingGroupFragment;
import com.juntcompany.godandgodsummer.Main.Chatting.ChattingListTab.ChattingListFragment;

/**
 * Created by EOM on 2016-07-01.
 */
public class ChattingViewPagerAdapter extends FragmentPagerAdapter {

    private static final int TAB_COUNT = 2; // 탭 개수
    public ChattingViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ChattingListFragment();
            case 1:
                return new ChattingGroupFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}
