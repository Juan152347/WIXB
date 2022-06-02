package com.wixteam.barbershop.Users.User.Application.All;

import com.wixteam.barbershop.Users.User.Domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AllUsers {
    private List<User> users;

    public AllUsers(List<User> users) {
        this.users = users;
    }

    public List<HashMap<String,Object>> response (){
        return users.stream().map( user -> user.data()).collect(Collectors.toList());
    }
}
