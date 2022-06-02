package com.wixteam.barbershop.Users.User.Domain;

import com.wixteam.barbershop.Products.Order.Domain.Order;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.Phone;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.UserPassword;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.UserType;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.UserId;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.UserName;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private UserId userid;
    private UserName username;
    private UserPassword userPassword;
    private UserType usertype;
    private Phone phone;
    private ArrayList<Order> orders;

    public User() {
    }

    public User(UserId userid, UserName username, UserPassword userPassword, UserType usertype, Phone phone) {
        this.userid = userid;
        this.username = username;
        this.userPassword = userPassword;
        this.usertype = usertype;
        this.phone = phone;
        this.orders = new ArrayList<>();
    }
    public static User create(){
        return null;
    }
    public HashMap<String,Object> data(){
        HashMap<String,Object> data = new HashMap<>(){
            {
                put("id",userid.value());
                put("name",username.value());
                put("phone",phone.value());
                put("type",usertype.value());

;            }

        };
        return  data;
    }

    public UserName getUsername() {
        return username;
    }

    public void setUsername(UserName username) {
        this.username = username;
    }

    public UserPassword getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(UserPassword userPassword) {
        this.userPassword = userPassword;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
