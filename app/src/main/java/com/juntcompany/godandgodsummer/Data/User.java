package com.juntcompany.godandgodsummer.Data;

import java.io.Serializable;

/**
 * Created by EOM on 2016-07-04.
 */
public class User implements Serializable{
    public String phoneNumber;
    public String email;
    public String nickName;
    public String birthDay;
    public String password;
    public String religion;
    public String gender;

    @Override
    public String toString() {
        return phoneNumber + " ,  " + email + ", "+  nickName + ", " + birthDay + " , " + password + " , " + religion + ", " + gender;
    }
}
