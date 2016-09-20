package com.juntcompany.godandgodsummer.Data;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.SerializedName;
import com.juntcompany.godandgodsummer.DataStructure.TimeLine.WriteResult;
import com.juntcompany.godandgodsummer.DataStructure.UserResult;

import java.io.Serializable;
import java.util.List;

/**
 * Created by EOM on 2016-06-30.
 */
public class Timeline implements Serializable {
//    public Drawable tlUserPicture;
//
//
//    public String tlUsername;
//    public int tlLikeCount;
//    public int tlReplyCount;
//    public String tlContent;

    @SerializedName("_id")
    public String boardId;
    @SerializedName("updatedAt")
    public String updatedAt;
    @SerializedName("createdAt")
    public String createdAt;
    @SerializedName("username")
    public String username;
    @SerializedName("email")
    public String email;
    @SerializedName("userPhoto")
    public String userPhoto;
    @SerializedName("content")
    public String content;
    @SerializedName("photo")
    public String photo;
    @SerializedName("like_count")
    public int likeCount;
    @SerializedName("reply_count")
    public int replyCount;
    @SerializedName("__v")
    public String __v;

    @SerializedName("like")
    public List<Like> likes;
    @SerializedName("reply")
    public List<Reply> replies;

}
