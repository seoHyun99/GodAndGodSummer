package com.juntcompany.godandgodsummer.DataStructure.TimeLine;

import com.google.gson.annotations.SerializedName;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.DataStructure.TimeLine.WriteResult;

/**
 * Created by EOM on 2016-08-04.
 */
public class WriteResultResponse {

    @SerializedName("message")
    public String message;
    public Timeline timeline;



}
