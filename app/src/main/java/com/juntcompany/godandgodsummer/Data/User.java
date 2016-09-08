package com.juntcompany.godandgodsummer.Data;

import com.google.gson.annotations.SerializedName;
import com.juntcompany.godandgodsummer.DataStructure.UserResult;

import java.io.Serializable;

/**
 * Created by EOM on 2016-07-04.
 */
public class User implements Serializable{


    @SerializedName("user_id")
    public int userId;

    @SerializedName("user_phone")
    public String phoneNumber;
    @SerializedName("user_email")
    public String email;
    @SerializedName("user_name")
    public String name;
    @SerializedName("user_birth")
    public String birthDay;
    @SerializedName("user_password")
    public String password;
    @SerializedName("user_religion")
    public String religion;
    @SerializedName("user_gender")
    public String gender;

    public UserResult result;


    @Override
    public String toString() {
        return phoneNumber + " ,  " + email + ", "+ name + ", " + birthDay + " , " + password + " , " + religion + ", " + gender;
    }


}
