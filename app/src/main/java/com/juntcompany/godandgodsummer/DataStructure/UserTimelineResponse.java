package com.juntcompany.godandgodsummer.DataStructure;

import com.google.gson.annotations.SerializedName;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.DataStructure.TimeLine.TimelineResult;

import java.util.List;

/**
 * Created by EOM on 2016-09-17.
 */
public class UserTimelineResponse {

    @SerializedName("result")
    public List<Timeline> results;
}
