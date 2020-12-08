package com.example.deliverme;

import java.lang.reflect.Array;
import java.util.List;
import java.util.*;
public class User {
    String id;
    String allName;
    String phone;
    String mail;
    String admin;

//    ArrayList <Package> clientPac;
//    ArrayList <Package> messengerPac;

    public User(String id, String allName, String mail, String phone, String admin)
    {
        this.id=id;
        this.allName=allName;
        this.mail=mail;
        this.phone=phone;
        this.admin=admin;

//        clientPac=new ArrayList<Package>();
//        messengerPac=new ArrayList<Package>();
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getAdmin() {
        return admin;
    }

    public String getId() {
        return id;
    }

    public String getAllName() {
        return allName;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAllName(String allName) {
        this.allName = allName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


}

