package com.juntcompany.godandgodsummer.Login.SignIn;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.juntcompany.godandgodsummer.Data.User;
import com.juntcompany.godandgodsummer.R;

public class SignInActivity extends AppCompatActivity {

    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        user = new User();

        Fragment f = new SignIn1MainFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.signin_container, f);
        ft.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: {
                getSupportFragmentManager().popBackStack();
//                백스택에 저장한거를 하나씩 빼내는 역할로 뒤로 가기 버튼
//                대신 프래그먼트 만들때마다 백스택에 프래그먼트를 저장해야 함.
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }


    public void callSignUpInfo(User user){
        Toast.makeText(getApplicationContext(), "message" + user, Toast.LENGTH_SHORT).show();
        Log.i("activity user", user.phoneNumber +" : " + user.birthDay);
        this.user = user;
        Log.i("activity user", this.user.phoneNumber +" : " + this.user.birthDay);
    }

    public void callSignUpLast(){
        Log.i("user", this.user.phoneNumber + this.user.email);
    }
}
