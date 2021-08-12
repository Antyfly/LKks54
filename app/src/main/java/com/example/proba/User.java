package com.example.proba;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
@IgnoreExtraProperties
public class User implements Serializable {
    public String email;
    public String fname;
    public String fathername;
    public String group;
    public int role;
    public String obras;
    public String raspis;
    public String sname;
    public String data_rogd;

    public User(String email, String fname, String sname, String group, int role, String fathername, String obras, String data_rogd, String raspis)
    {
        this.fname = fname;
        this.sname = sname;
        this.email = email;
        this.group = group;
        this.role = role;
        this.fathername = fathername;
        this.obras = obras;
        this.data_rogd = data_rogd;
        this.raspis = raspis;
    }
    public User()
    {

    }
}
