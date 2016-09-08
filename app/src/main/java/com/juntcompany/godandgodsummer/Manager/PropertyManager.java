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

    private static final String FIELD_USER_EMAIL = "user_email";
    public void setUserEmail(String email){
        mEditor.putString(FIELD_USER_EMAIL, email);
        mEditor.commit();
    }
    public String getUserEmail(){
        return mPrefs.getString(FIELD_USER_EMAIL, "");
    }

    private static final String FIELD_USER_PHONE_NUMBER = "user_phone_number";
    public void setUserPhoneNumber(String phoneNumber){
        mEditor.putString(FIELD_USER_PHONE_NUMBER, phoneNumber);
        mEditor.commit();
    }
    public String getUserPhoneNumber(){
        return mPrefs.getString(FIELD_USER_PHONE_NUMBER, "");
    }

    private static final String FIELD_USER_PASSWORD = "user_password";
    public void setUserPassword(String password){
        mEditor.putString(FIELD_USER_PASSWORD, password);
        mEditor.commit();
    }
    public String getUserPassword(){
        return mPrefs.getString(FIELD_USER_PASSWORD, "");
    }

    private static final String FIELD_USER_ID = "user_id";
    public void setUserId(int userId){
        mEditor.putInt(FIELD_USER_ID, userId);
        mEditor.commit();
    }
    public int getUserId(){
        return mPrefs.getInt(FIELD_USER_ID, 0);
    }

    private static final String FIELD_USER_NAME = "user_name";
    public void setUserName(String userName){
        mEditor.putString(FIELD_USER_NAME, userName);
        mEditor.commit();
    }
    public String getUserName(){
        return mPrefs.getString(FIELD_USER_NAME, "");
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
