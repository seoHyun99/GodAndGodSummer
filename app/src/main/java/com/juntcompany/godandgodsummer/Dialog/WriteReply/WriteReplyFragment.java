package com.juntcompany.godandgodsummer.Dialog.WriteReply;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Api;
import com.juntcompany.godandgodsummer.Data.Reply;
import com.juntcompany.godandgodsummer.Data.Timeline;
import com.juntcompany.godandgodsummer.DataStructure.TimeLine.WriteResult;
import com.juntcompany.godandgodsummer.Main.TimeLine.TimelineFragment;
import com.juntcompany.godandgodsummer.Manager.PropertyManager;
import com.juntcompany.godandgodsummer.R;
import com.juntcompany.godandgodsummer.Util.Rest.ApiClient;
import com.juntcompany.godandgodsummer.Util.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    Timeline timeline;
    List<Reply> replies;
    RecyclerView recyclerView;
    WriteReplyAdapter mAdapter;
    public final static String REPLY_MESSAGE = "message";
    EditText editReply;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = getArguments();
        timeline = (Timeline)bundle.getSerializable(REPLY_MESSAGE); // 전 TimelineFragment 에서 값 가져오기.

        replies = timeline.replies;
        View view = inflater.inflate(R.layout.fragment_write_reply, container, false);

        //////////////리사이클러뷰 세팅
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new WriteReplyAdapter();

        recyclerView.setAdapter(mAdapter);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);



        //////////////리사이클러뷰 세팅
        setHeaderData();
        setReplyData();
//        initData();

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

                writeReplyNetwork( editReply.getText().toString());
            }
        });

//        btn = (Button)view.findViewById(R.id.button_camera);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

         editReply = (EditText)view.findViewById(R.id.edit_reply);


        return view;
    }

    private void setReplyData(){
        mAdapter.addAll(replies);
//        Log.i("writeReply timeline", replies.get(0).replyContent);
    }
    private void setHeaderData(){
        mAdapter.addHeader(timeline);
        Log.i("writeReply reply", timeline.boardId + timeline.content);
    }

    private void initData(){
        Timeline timeline = new Timeline();
        mAdapter.addHeader(timeline);
        for(int i=0; i<4; i++){
            Reply reply = new Reply();
            mAdapter.add(reply);
        }
    }

    private void writeReplyNetwork(final String replyContent){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<WriteResult> call = apiInterface.writeReply(timeline.boardId, PropertyManager.getInstance().getUserName(),PropertyManager.getInstance().getUserEmail(),
                                                     replyContent, PropertyManager.getInstance().getProfileImage() );

        call.enqueue(new Callback<WriteResult>() {
            @Override
            public void onResponse(Call<WriteResult> call, Response<WriteResult> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getContext(), response.body().result.message, Toast.LENGTH_SHORT).show();
                    //네트워크에서 받아온걸 하지 않고 클라이언트에서 수정.
                    Reply reply = new Reply();
                    reply.replyContent = replyContent;
                    reply.replyUserEmail = PropertyManager.getInstance().getUserEmail();
                    reply.replyUsername = PropertyManager.getInstance().getUserName();
                    reply.replyUserImage = PropertyManager.getInstance().getProfileImage();
                    mAdapter.add(reply);

                }
            }

            @Override
            public void onFailure(Call<WriteResult> call, Throwable t) {
                Toast.makeText(getContext(), "네트워크 상태를 확인해 주세요", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //////////////////////////상위 프래그먼트에 값 전달하기
    public interface OnDialogResultListener {
        public void onReplyResult(List<Reply> replies);

    }
    OnDialogResultListener mDialogListener;
    public void setOnDialogResultListener(OnDialogResultListener listener) {
        mDialogListener = listener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

        if(mDialogListener!=null){
            mDialogListener.onReplyResult(replies);
        }
    }
}
