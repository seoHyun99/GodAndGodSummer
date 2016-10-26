package com.juntcompany.godandgodsummer.Login.Help;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.juntcompany.godandgodsummer.Dialog.NoMatchCodeDialog;
import com.juntcompany.godandgodsummer.R;


public class HelpConfirmAccountActivity extends AppCompatActivity {

    public static Context mContext;

    TextView sendMSG, userInputData;
    Button sendCode;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_confirm_account);

        final String code = "1234"; //임시 데이터

        userInputData = (TextView) findViewById(R.id.userInputData);
        sendMSG = (TextView) findViewById(R.id.sendMSG);
        sendCode = (Button) findViewById(R.id.receiveCode2);
        final Button revestCode = (Button) findViewById(R.id.receiveCode1);
        final Button next = (Button) findViewById(R.id.next);
        final EditText inputCode = (EditText) findViewById(R.id.inputCode);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.button_back);

        View viewToolbar = getLayoutInflater().inflate(R.layout.toolbar_only_title, null);
        TextView textTitle = (TextView) viewToolbar.findViewById(R.id.text_toolbar_title);
        textTitle.setText("계정 인증");

        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));

        //findEmail, findPhone에서 인텐트 값을 받아옴, email:1, phone:2
        Intent intent = getIntent();
        index = intent.getIntExtra("index", 0);
        String data = intent.getStringExtra("data");

        //index값 구분.
        switch (index) {
            case 1:
                email(data);
                break;
            case 2:
                phone(data);
                break;
            default:
                Log.d("wrong index", String.valueOf(index));
        }

        revestCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "코드가 다시 전송되었습니다.", Toast.LENGTH_SHORT).show();
                sendCodeToUser();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputCode.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "코드를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (code.equals(inputCode.getText().toString())) {
                    Intent i = new Intent(view.getContext(), NoMatchCodeDialog.class);
                    i.putExtra("index", index);

                    NoMatchCodeDialog dialog = new NoMatchCodeDialog();
                    dialog.show(getSupportFragmentManager(), "dialog");
                } else {
                    goActivity(HelpCreatePasswordActivity.class);
                }
            }
        });
    }

    private void email(String s) {
        userInputData.setText(s);
        sendMSG.setText("다음 이메일 주소로 메시지가 전송되었습니다");

        sendCodeToUser();

        sendCode.setText("SMS로 코드 받기");
        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goActivity(HelpFindPhoneActivity.class);
            }
        });
    }

    private void phone(String s) {
        char[] arr_phoneNumbers = new char[s.length()];
        arr_phoneNumbers = s.toCharArray();

        if (s.length() == 10) {
            arr_phoneNumbers[3] = arr_phoneNumbers[4] = arr_phoneNumbers[5] = '*';
        } else {
            arr_phoneNumbers[3] = arr_phoneNumbers[4] = arr_phoneNumbers[5] = arr_phoneNumbers[6] = '*';
        }

        String str_phoneNumber = new String(arr_phoneNumbers, 0, arr_phoneNumbers.length);

        userInputData.setText(str_phoneNumber);
        sendMSG.setText("다음 핸드폰 번호로 메시지가 전송되었습니다");

        sendCodeToUser();

        sendCode.setText("이메일로 코드 받기");
        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goActivity(HelpFindEmailActivity.class);
            }
        });
    }

    private void goActivity(Class c) {
        Intent goActivity = new Intent(this, c);
        startActivity(goActivity);
        finish();
    }

    private void sendCodeToUser() {
        //Todo : 사용자에게 인증 코드 보내주는 부분.
    }
}
