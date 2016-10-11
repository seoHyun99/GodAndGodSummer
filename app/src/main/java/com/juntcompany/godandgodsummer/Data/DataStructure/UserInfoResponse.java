package com.juntcompany.godandgodsummer.Data.DataStructure;

import com.google.gson.annotations.SerializedName;
import com.juntcompany.godandgodsummer.Data.User;

/**
 * Created by EOM on 2016-08-04.
 */
public class UserInfoResponse {

    @SerializedName("result")
    public User user;

}
