package com.juntcompany.godandgodsummer.Data;

import android.graphics.drawable.Drawable;

import java.util.List;

/**
 * Created by EOM on 2016-06-30.
 */
public class Timeline {
    public Drawable tlUserPicture;
    public String tlUsername;
    public int tlLikeCount;
    public int tlReplyCount;
    public String tlContent;

    List<Reply> replies;
}
