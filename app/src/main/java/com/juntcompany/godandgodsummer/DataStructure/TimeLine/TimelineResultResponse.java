package com.juntcompany.godandgodsummer.DataStructure.TimeLine;

import com.google.gson.annotations.SerializedName;
import com.juntcompany.godandgodsummer.Data.Timeline;

import java.util.List;

/**
 * Created by EOM on 2016-09-01.
 */
public class TimelineResultResponse {

    @SerializedName("results")
    public  List<Timeline> results;
}
