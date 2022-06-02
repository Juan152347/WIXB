package com.wixteam.barbershop.Users.User.Application.Create;

import com.wixteam.barbershop.Users.User.Domain.Ports.UserRepository;
import com.wixteam.barbershop.Users.User.Domain.User;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.*;

public class UserBarberCreator {
    private UserRepository repository;

    public UserBarberCreator(UserRepository repository) {
        this.repository = repository;
    }
    public void execute(String userid, String username,String userPassword,String phone){
        User user = new User(new UserId(userid) , new UserName(username) , new UserPassword(userPassword) , new UserType("Barber"), new Phone(phone));
        repository.save(user);
    }
}
