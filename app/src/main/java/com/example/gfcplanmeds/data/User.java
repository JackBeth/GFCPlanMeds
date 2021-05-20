package com.example.gfcplanmeds.data;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    public String Uid;
    public String UserName;
    public String Password;
    public String Email;
    public String PhoneNo;
    public String DoctorName;
    public String OfficeName;

    public List<Medicine> Medicines;


    public User(){
    }

    public User(String Username, String Password, String Email, String PhoneNo, String DoctorName, String OfficeName) {

        this.UserName = Username;
        this.Password = Password;
        this.Email = Email;
        this.PhoneNo = PhoneNo;
        this.DoctorName = DoctorName;
        this.OfficeName = OfficeName;
    }

}
