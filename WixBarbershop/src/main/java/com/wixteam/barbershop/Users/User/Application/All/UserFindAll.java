package com.wixteam.barbershop.Users.User.Application.All;

import com.wixteam.barbershop.Users.User.Domain.Ports.UserRepository;
import com.wixteam.barbershop.Users.User.Domain.User;

import java.util.List;

public class UserFindAll {
    private UserRepository repository;
    public UserFindAll(UserRepository repository) {
        this.repository = repository;
    }
   public List<User> execute(){
           return  repository.all();
    }
}
