package com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.NewsTab.NewsFragment;
import com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.ProfileTab.MyProfileFragment;
import com.juntcompany.godandgodsummer.Main.Toolbar.MyProfile.SettingTab.SettingFragment;

/**
 * Created by EOM on 2016-07-05.
 */
public class MyProfileViewPagerAdapter extends FragmentPagerAdapter {
    private static final int TAB_COUNT = 3; // 탭 개수
    public MyProfileViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MyProfileFragment();
            case 1:
                return new NewsFragment();
            case 2:
                return new SettingFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}
