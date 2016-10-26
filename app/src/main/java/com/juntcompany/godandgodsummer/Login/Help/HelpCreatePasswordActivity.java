package com.juntcompany.godandgodsummer.Login.Help;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.juntcompany.godandgodsummer.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HelpCreatePasswordActivity extends AppCompatActivity {

    private final String Passwrod_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=[\\S]+$).{6,20}";

    private EditText inputPassWord;
    private Button complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_create_new_password);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.button_back);

        View viewToolbar = getLayoutInflater().inflate(R.layout.toolbar_only_title, null);
        TextView textTitle = (TextView) viewToolbar.findViewById(R.id.text_toolbar_title);
        textTitle.setText("계정 비밀번호");

        complete = (Button) findViewById(R.id.complete);
        inputPassWord = (EditText) findViewById(R.id.inputPassWord);
        inputPassWord.addTextChangedListener(textWatcherInput);

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                goActivity(HelpActivity.class);
            }
        });

        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Passwordvalidate(inputPassWord.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    //Todo: 로그인 첫 화면으로 이동.
                }
            }
        });
    }

    private boolean Passwordvalidate(final String hex) {
        Pattern pattern = Pattern.compile(Passwrod_PATTERN);
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    private void goActivity(Class c){
        Intent i = new Intent(this, c);
        startActivity(i);
        finish();
    }

    TextWatcher textWatcherInput = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(inputPassWord.getText().toString().length() > 5 && inputPassWord.getText().toString().length() < 21)
                complete.setVisibility(View.VISIBLE);
            else
                complete.setVisibility(View.INVISIBLE);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}