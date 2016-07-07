package com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.ListTab.FriendListFragment;
import com.juntcompany.godandgodsummer.Main.Toolbar.FriendManage.RequestTab.FriendRequestFragment;

/**
 * Created by EOM on 2016-07-06.
 */
public class FriendManageViewPagerAdapter extends FragmentPagerAdapter {

    private static final int TAB_COUNT = 2; // 탭 개수
    public FriendManageViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FriendRequestFragment();
            case 1:
                return new FriendListFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

}
