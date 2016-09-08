package com.juntcompany.godandgodsummer.Chatting;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;
import com.juntcompany.godandgodsummer.Data.Message;
import com.juntcompany.godandgodsummer.R;
import com.juntcompany.godandgodsummer.Util.GodAndGod;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChattingFragment extends Fragment {


    public ChattingFragment() {
        // Required empty public constructor
    }

    private static final String NEW_MESSAGE = "new message";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GodAndGod app = (GodAndGod)getActivity().getApplication(); // 소켓 객체 가져오기
        mSocket = app.getSocket();
        // on(소켓에 등록된 이벤트 이름, emitter 리스너로 아래에 재정의한 emitter 리스너
        mSocket.on(Socket.EVENT_CONNECT, onConnect); //기존에 있는 이벤트들,

        mSocket.on(NEW_MESSAGE, onNewMessage); // 내가 만들어준 이벤트
        mSocket.connect();

    }
    private Boolean isConnected = false;
    private List<Message> mMessages = new ArrayList<Message>();
    EditText editInput;
    private Socket mSocket;
    RecyclerView recyclerView;
    MessageAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chatting, container, false);
         recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
//        mAdapter = new MessageAdapter(mMessages); //메시지를 넣어주는 과정, adapter에 item 에 message 객체 넣어줌
        // 노드 쓰려면 주석 풀기
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //리사이클러뷰 세팅
         editInput = (EditText)view.findViewById(R.id.edit_input);
        Button btn = (Button)view.findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendChatData();
            }
        });


        initData();

        return view;
    }

    private void sendChatData(){

        String message = editInput.getText().toString().trim();
        if(TextUtils.isEmpty(message)){ //메시지가 비었으면 아무것도 아님
            return;
        }
        editInput.setText("");
        Log.i("message", "edit message : " + message);
        addMessage("juntae", message); //내 메시지를 어댑터에 추가

        mSocket.emit(NEW_MESSAGE, message); // 소켓에 event 등록

    }

    private void addMessage(String username, String message){
        mMessages.add(new Message.Builder(Message.TYPE_MESSAGE_SEND).username(username).message(message).build());
        Log.i("message", "emit call ui message :" + username + ", " + message );
        mAdapter.notifyItemInserted(mMessages.size()-1);
//        mAdapter.addAll(mMessages);
        scrollToBottom();
        Toast.makeText(getContext(), username + message, Toast.LENGTH_SHORT).show();
    }

    //emitter 설정 - > 이벤트 발생시키는 것, onCreate 에 정의한 이벤트를 정의
    private Emitter.Listener onConnect = new Emitter.Listener(){

        @Override
        public void call(Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(!isConnected){
                        Toast.makeText(getContext()," connected", Toast.LENGTH_SHORT).show();
                        isConnected = true;
                    }
                }
            });
        }
    };
    private Emitter.Listener onNewMessage = new Emitter.Listener() { // 이 emitter 는 내 메시지에는 반응을 안함. 상대방이 보낸거를 받는 역할
        @Override
        public void call(final Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject)args[0];

                    Log.i("message", "json data : " + data.toString() );
                    String username ;
                    String message ;
                    try {
                        username = data.getString("username");
                        message = data.getString("message");
                        Log.i("message", message);
                        addMessage(username, message); // 상대방이 보낸 메시지를 어댑터에 추가
                    } catch (JSONException e) {

                        return;
                    }
                    Log.i("message", "emitter.listener : " +   message);
                }
            });
        }
    };


    private void initData(){

//        Message message = new Message();
//        message.mType = "receive";
//        mAdapter.add(message);
//        Message message1 = new Message();
//        message1.mType = "send";
//        mAdapter.add(message1);
    }
    private void scrollToBottom() {  // 리스트를 가장 밑으로 가게 하는 메소드
        recyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
    }

}
