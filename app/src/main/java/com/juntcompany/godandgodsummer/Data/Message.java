package com.juntcompany.godandgodsummer.Data;

/**
 * Created by EOM on 2016-07-14.
 */
public class Message {


    public static final int TYPE_MESSAGE_SEND = 0;
    public static final int TYPE_MESSAGE_RECEIVE = 1;
    public static final int TYPE_LOG = 3;
    public static final int TYPE_ACTION = 4;

    private int mType;
    private String mMessage;
    private String mUsername;
    public int getType() {
        return mType;
    };

    public String getMessage() {
        return mMessage;
    };

    public String getUsername() {
        return mUsername;
    };



    public static class Builder{
        private final int mType;
        private String mUsername;
        private String mMessage;

        public Builder(int type){ //type 이 있어야 생성됨
            mType = type;
        }

        public Builder username(String username) { //builder 클래스 메소드
            mUsername = username;
            return this;
        }
        public Builder message(String message) { //builder 클래스 메소드
            mMessage = message;
            return this;
        }

        public Message build() { // 앞에 생성자부터 메소드를 다 사용하고 마지막에 사용하는 메소드
            Message message = new Message();
            message.mType = mType;
            message.mUsername = mUsername;
            message.mMessage = mMessage;
            return message;
        }

    }

}
