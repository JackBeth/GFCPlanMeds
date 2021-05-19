package com.example.gfcplanmeds.data;

import java.io.Serializable;

public class User implements Serializable {

    public String UserName;
    public String Password;
    public String Email;
    public String PhoneNo;

    public User(){
    }

    public User(String Username, String Password, String Email, String PhoneNo) {

        this.UserName = Username;
        this.Password = Password;
        this.Email = Email;
        this.PhoneNo = PhoneNo;
    }

}
