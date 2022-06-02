package com.wixteam.barbershop.Users.User.Application.All;

import com.wixteam.barbershop.Users.User.Domain.Ports.UserRepository;
import com.wixteam.barbershop.Users.User.Domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AllBarbers {
    private  List<User> users;

    public AllBarbers(List<User> users) {
        this.users = users;
    }

    public List<HashMap<String,Object>> response (){
        List<HashMap<String,Object>> response = users.stream().filter(user -> user.data().get("type").equals("Barber")).map( user -> user.data()).collect(Collectors.toList());
        return  response;
    }
}
