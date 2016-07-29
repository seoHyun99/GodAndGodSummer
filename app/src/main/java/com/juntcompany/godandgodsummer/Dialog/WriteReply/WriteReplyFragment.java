package com.juntcompany.godandgodsummer.Dialog.WriteReply;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.juntcompany.godandgodsummer.Data.Reply;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WriteReplyFragment extends DialogFragment {


    public WriteReplyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MyDialog);
    }

    RecyclerView recyclerView;
    WriteReplyAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_write_reply, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new WriteReplyAdapter();
        recyclerView.setAdapter(mAdapter);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        initData();

        Button btn = (Button)view.findViewById(R.id.button_heart);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn = (Button)view.findViewById(R.id.button_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn = (Button)view.findViewById(R.id.button_camera);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        EditText editReply = (EditText)view.findViewById(R.id.edit_reply);


        return view;
    }

    private void initData(){
        Timeline timeline = new Timeline();
        mAdapter.addHeader(timeline);
        for(int i=0; i<4; i++){
            Reply reply = new Reply();
            mAdapter.add(reply);
        }
    }

}
