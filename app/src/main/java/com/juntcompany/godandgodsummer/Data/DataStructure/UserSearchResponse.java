package com.juntcompany.godandgodsummer.Data.DataStructure;

import com.google.gson.annotations.SerializedName;
import com.juntcompany.godandgodsummer.Data.User;

import java.util.List;

/**
 * Created by EOM on 2016-09-17.
 */
public class UserSearchResponse {

    @SerializedName("results")
    public List<User> users;

}
