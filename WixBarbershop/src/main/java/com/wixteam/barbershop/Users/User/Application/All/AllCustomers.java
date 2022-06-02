package com.wixteam.barbershop.Users.User.Application.All;

import com.wixteam.barbershop.Users.User.Domain.Ports.UserRepository;
import com.wixteam.barbershop.Users.User.Domain.User;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AllCustomers {

    private  List<User> users;

    public AllCustomers(List<User> users) {
        this.users = users;
    }

    public List<HashMap<String,Object>> response (){
        List<HashMap<String,Object>> response = users.stream().filter(user -> user.data().get("type").equals("Customer")).map( user -> user.data()).collect(Collectors.toList());
        return  response;
    }
}
