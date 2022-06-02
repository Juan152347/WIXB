package com.wixteam.barbershop.Users.User.Application.Update;

import com.wixteam.barbershop.Users.User.Domain.Ports.UserRepository;
import com.wixteam.barbershop.Users.User.Domain.User;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.*;

public class userUpdate {
    private UserRepository repository;

    public userUpdate(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String userid, String username, String userPassword, String phone){
        User user = new User(new UserId(userid) , new UserName(username) , new UserPassword(userPassword) , new UserType("Barber"), new Phone(phone));
        repository.update(user, userid);
    }
}
