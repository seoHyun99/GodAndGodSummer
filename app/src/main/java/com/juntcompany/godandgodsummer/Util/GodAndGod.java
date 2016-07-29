package com.juntcompany.godandgodsummer.Util;

import android.app.Application;
import android.content.Context;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

/**
 * Created by EOM on 2016-04-27.
 */
public class GodAndGod extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
//        FacebookSdk.sdkInitialize(this);
        context = this;
    }

    public static Context getContext() {
        return context;
    }

    //////소켓 객체 가져오기 위해 만듬
    private Socket mSocket;
    {
        try {
            mSocket = IO.socket(Constants.CHAT_SERVER_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public Socket getSocket() {
        return mSocket;
    }

    //소켓
}
