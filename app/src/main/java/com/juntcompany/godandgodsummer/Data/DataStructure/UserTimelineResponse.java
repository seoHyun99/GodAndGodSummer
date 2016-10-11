package com.juntcompany.godandgodsummer.Data.DataStructure;

import com.google.gson.annotations.SerializedName;
import com.juntcompany.godandgodsummer.Data.Timeline;

import java.util.List;

/**
 * Created by EOM on 2016-09-17.
 */
public class UserTimelineResponse {

    @SerializedName("result")
    public List<Timeline> results;
}
