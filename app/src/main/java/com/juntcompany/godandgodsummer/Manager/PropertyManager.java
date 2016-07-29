package com.juntcompany.godandgodsummer.Manager;

import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;

import com.juntcompany.godandgodsummer.Util.GodAndGod;

/**
 * Created by EOM on 2016-07-15.
 */
public class PropertyManager {

    private static PropertyManager instance;

    public static PropertyManager getInstance(){
        if(instance == null){
            instance = new PropertyManager();
        }
        return instance;
    }

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    private PropertyManager(){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(GodAndGod.getContext());
        mEditor = mPrefs.edit();
    }

    private static final String FIELD_PROFILE_IMAGE = "profile_image";

    public void setProfileImage(String filePath){
        mEditor.putString(FIELD_PROFILE_IMAGE, filePath);
        mEditor.commit();
    }
    public String getProfileImage(){
        return mPrefs.getString(FIELD_PROFILE_IMAGE, "");
    }
}
