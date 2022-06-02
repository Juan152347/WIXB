package com.wixteam.barbershop.Users.User.Application.Login;

import com.wixteam.barbershop.Users.User.Domain.Ports.UserRepository;

import java.util.HashMap;

public class loginUser {
    private UserRepository repository;

    public loginUser(UserRepository repository) {
        this.repository = repository;
    }

    public HashMap<String,Object> execute(String username, String password){
        return  repository.Login(username,password);
    }
}
