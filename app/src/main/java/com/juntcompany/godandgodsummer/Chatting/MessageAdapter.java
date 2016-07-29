package com.juntcompany.godandgodsummer.Chatting;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgodsummer.Data.Message;
import com.juntcompany.godandgodsummer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EOM on 2016-07-14.
 */
public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Message> items = new ArrayList<Message>();
    private int[] mUsernameColors;

    public MessageAdapter(List<Message> messages){
        items = messages;
    } //아이템에 메시지를 넣는 과정

    public void add(Message message){
        items.add(message);
        notifyDataSetChanged();
    }
    public void addAll(List<Message> messages){
        items.addAll(messages);
        notifyDataSetChanged();
    }

    //////////////////////////////////////////////////////////////////cursor 쓰는거




    //////////////////////////////////////////////////////////////////
    @Override
    public int getItemViewType(int position) {

        Message data = items.get(position);
        if(data.getType() == Message.TYPE_MESSAGE_RECEIVE){
            return Message.TYPE_MESSAGE_RECEIVE;
        }else if(data.getType() == Message.TYPE_MESSAGE_SEND){
            return Message.TYPE_MESSAGE_SEND;
        }else if(data.getType() == Message.TYPE_LOG){
            return Message.TYPE_LOG;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType){
            case Message.TYPE_MESSAGE_RECEIVE:{
                view = inflater.inflate(R.layout.view_chat_message_receive, parent, false);
                MessageReceiveViewHolder holder = new MessageReceiveViewHolder(view);

                return holder;
            }
            case Message.TYPE_MESSAGE_SEND:{
                view = inflater.inflate(R.layout.view_chat_message_send, parent, false);
                MessageSendViewHolder holder = new MessageSendViewHolder(view);
                Log.i("send", "send oncreate view holder");
                return holder;
            }
            case Message.TYPE_LOG:{

            }
            case  Message.TYPE_ACTION:{

            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Message message = items.get(position);
        switch (getItemViewType(position)){
            case Message.TYPE_MESSAGE_RECEIVE:{
                ((MessageReceiveViewHolder)holder).setData("ddd","ddd");
            }
            case Message.TYPE_MESSAGE_SEND:{
                ((MessageSendViewHolder)holder).setData(message.getUsername(), message.getMessage());
//                ((MessageSendViewHolder)holder).setData("sss","sss")
                Log.i("send", "send onbind view holder");
            }
            case Message.TYPE_LOG:{

            }
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
